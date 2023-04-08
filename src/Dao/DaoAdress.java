package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
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
}
