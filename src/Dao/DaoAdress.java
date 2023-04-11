package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sss.model.Adress;
import sss.model.User;

public class DaoAdress {

	public Adress getOne(int id)
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("select * from sss.adress where id = ?");  
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery(); 
			
			int i =1;
			while(rs.next())  
			{
				int adressid = rs.getInt(i++);
				String Street = rs.getString(i++);
				String number = rs.getString(i++);
				String city = rs.getString(i++);
				String Country = rs.getString(i++);
				Adress a = new Adress(adressid,Street,number,city,Country);
			   return a;
				
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
		return null;  
			
	}
	public int Save(Adress adres) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("INSERT INTO sss.adress(`Street`,`StreetNubmer`,`City`,`Country`)VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);  
			stmt.setString(1,adres.getStreet());
			stmt.setString(2,adres.getStreetNubmer());
			stmt.setString(3,adres.getCity());
			stmt.setString(4,adres.getCountry());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
			int key = rs.next() ? rs.getInt(1) : 0;
			con.close(); 
			return key;
				
			
			
			 
			
		
			
	}
}
