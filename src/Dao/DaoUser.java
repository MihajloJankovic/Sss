package Dao;

import java.awt.image.ColorConvertOp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sss.model.*;

public class DaoUser {
	
	private DaoLanguage daolang = new DaoLanguage();
	private DaoAdress daoadress = new DaoAdress();
	
	
	public List<User> getAllCustomers() throws SQLException{
		
		
		List <User> users = new ArrayList<User>();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user where type = 'CUSTOMER';");  
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
				type Type =type.valueOf(rs.getString(i++));
				users.add(new User(id,firstname,lastname,email,phoneNumber,a,Cardnumber,langs,MainLanguage,Type));
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			
		return users;
		}
	public List<User> getAllCustomerscouach(int idd) throws SQLException{
		
		
		List <User> users = new ArrayList<User>();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

		
			PreparedStatement stmt=con.prepareStatement("select user.* from user ,appointment where user.type = 'CUSTOMER' and user.ID = appointment.client and  appointment.coach =  ?");  
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
				type Type =type.valueOf(rs.getString(i++));
				users.add(new User(id,firstname,lastname,email,phoneNumber,a,Cardnumber,langs,MainLanguage,Type));
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
				type admin = type.valueOf(rs.getString(i++));
				User pera  = new User(id,firstname,lastname,email,phoneNumber,a,Cardnumber,langs,MainLanguage,admin);
				return pera;
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		return null;  
			
	
		}
	
public User finduser(String emaila) throws SQLException{
		
		
		List <User> users = new ArrayList<User>();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  


			PreparedStatement stmt=con.prepareStatement("select * from sss.user where email = ?;");  
			stmt.setString(1,emaila);
			ResultSet rs=stmt.executeQuery(); 
			int i =1;
		
			rs.next();	
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
				type Type =type.valueOf(rs.getString(i++));
				User pera  = new User(id,firstname,lastname,email,phoneNumber,a,Cardnumber,langs,MainLanguage,Type);
				con.close();  
				return pera;
			
			
		
			}catch(Exception e){ System.out.println(e);}
		return null;  
			
	
		}
public User Save(User user) throws SQLException{
	
	

	
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sss","root","root");  
		PreparedStatement stmt1=con1.prepareStatement("select count(email) from sss.user where email = ?");  
		stmt1.setString(1,user.getEmail());
		ResultSet rs1=stmt1.executeQuery(); 
		
	
		rs1.next();
		int k = rs1.getInt(1);
		if(k!= 0)
		{
			return null;
		}
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sss","root","root");  

		
		int adres = daoadress.Save(user.getAdress());
		PreparedStatement stmt=con.prepareStatement("INSERT INTO sss.user(`firstname`,`lastname`,`email`,`phone`,`adress`,`cardnumber`,`mainlanguage`,`type`)VALUES(?,?,?,?,?,?,?,?);",PreparedStatement.RETURN_GENERATED_KEYS);  
		stmt.setString(1,user.getEmail());
		
		
		
		stmt.setString(1,user.getFirstname());
		stmt.setString(2,user.getLastname());
		stmt.setString(3,user.getEmail());
		stmt.setString(4,user.getPhoneNumber());
		stmt.setInt(5,adres);
		stmt.setString(6,user.getCardNumber());
		stmt.setString(7,String.valueOf(user.getMainLanguage()));
		stmt.setString(8,user.getType().toString());
	
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();  
		int key = rs.next() ? rs.getInt(1) : 0;

		
		
		user.setId(key);
		con.close();  
		daolang.SaveLanguages(user);
		return user;
		

		}catch(Exception e){ System.out.println(e);}
	return null;  
		

	}

public void Delete(int id) throws SQLException{
	
	

	
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sss","root","root");  
		PreparedStatement stmt1=con1.prepareStatement("delete from sss.user where id = ?");  
		stmt1.setInt(1,id);
		stmt1.executeUpdate();
		
	
		con1.close();  
		
		

		}catch(Exception e){ System.out.println(e);}

		

	}
}
