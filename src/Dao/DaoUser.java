package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sss.model.*;

public class DaoUser {
	
	private DaoLanguage daolang = new DaoLanguage();
	private DaoAdress daoadress = new DaoAdress();
	
	
	public List<User> getAll() throws SQLException{
		
		
		List <User> users = new ArrayList<User>();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user;");  
			int i =1;
		
			while(rs.next())  
			{
				int id = rs.getInt(i++);
				String firstname = rs.getString(i++);
				String lastname = rs.getString(i++);
				String email = rs.getString(i++);
				String phoneNumber = rs.getString(i++);
				int adressid = rs.getInt(i++);
				Adress a = daoadress.getOne(adressid);
				String Cardnumber = rs.getString(i++);
				Language MainLanguage = Language.valueOf(rs.getString(i++));
				List<Language> langs = daolang.getAllbyUser(id);
				users.add(new User(id,firstname,lastname,email,phoneNumber,a,Cardnumber,langs,MainLanguage));
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			
		return users;
		}
	public User getOne(int idd) throws SQLException{
		
		
		List <User> users = new ArrayList<User>();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  


			PreparedStatement stmt=con.prepareStatement("select * from sss.user where ID = ?");  
			stmt.setInt(1,idd);
			ResultSet rs=stmt.executeQuery(); 
			int i =1;
		
			while(rs.next())  
			{
				int id = rs.getInt(i++);
				String firstname = rs.getString(i++);
				String lastname = rs.getString(i++);
				String email = rs.getString(i++);
				String phoneNumber = rs.getString(i++);
				int adressid = rs.getInt(i++);
				Adress a = daoadress.getOne(adressid);
				String Cardnumber = rs.getString(i++);
				Language MainLanguage = Language.valueOf(rs.getString(i++));
				List<Language> langs = daolang.getAllbyUser(id);
				User pera  = new User(id,firstname,lastname,email,phoneNumber,a,Cardnumber,langs,MainLanguage);
				return pera;
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		return null;  
			
	
		}

}
