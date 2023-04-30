package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import sss.model.Adress;
import sss.model.Appointment;
import sss.model.Client;
import sss.model.Coach;
import sss.model.Report;
import sss.model.User;

public class DaoAppointment {
	private DaoCoach pera1= new DaoCoach();
	private DaoUser p= new DaoUser();
	private DaoReport p1= new DaoReport();
	public Appointment getOne(int idd)
	{
		Appointment ab = new Appointment();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("select * from sss.appointment where id = ?");  
			stmt.setInt(1,idd);
			ResultSet rs=stmt.executeQuery(); 
			
		
		
			int i =1;
			while(rs.next())  
			{
				int id = rs.getInt(i++);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime date = LocalDateTime.parse(rs.getString(i++),formatter);
				Coach pera = pera1.getOne(rs.getInt(i++));
				int h = rs.getInt(i++);
				User a = new User();
				  if (rs.wasNull()) 
				  {
				  
				  }
				  else
				  {
					 a = p.getOne(h);
				  }
				
				
				Report b = p1.getOne(a.getId());
				Client p = new Client(a, b);
				Boolean r = Boolean.valueOf(rs.getString(i++));
				Boolean c = Boolean.valueOf(rs.getString(i++));
				int price = rs.getInt(i++);
				
				Appointment ag = new Appointment(id, date, pera, p, c, r,price);
				ab=ag;
				
			   return ab;
				
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e); return ab;}
		
		return null;
		
			
	}
	public List<Appointment> getAll(int idd)
	{
		List<Appointment> s = new ArrayList<Appointment>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("select * from sss.appointment where coach = ?");  
			stmt.setInt(1,idd);
			ResultSet rs=stmt.executeQuery(); 
			

			
			
			while(rs.next())  
			{
				int i =1;
				int id = rs.getInt(i++);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime date = LocalDateTime.parse(rs.getString(i++),formatter);
				Coach pera = pera1.getOne(rs.getInt(i++));
				int h = rs.getInt(i++);
				User a = new User();
				  if (rs.wasNull()) 
				  {
				  
				  }
				  else
				  {
					 a = p.getOne(h);
				  }
				
				
				Report b = p1.getOne(a.getId());
				Client p = new Client(a, b);
				Boolean r = Boolean.valueOf(rs.getString(i++));
				Boolean c = Boolean.valueOf(rs.getString(i++));
				int price = rs.getInt(i++);
				
				Appointment ab = new Appointment(id, date, pera, p, c, r,price);
				
			   s.add(ab);
				
			}
			con.close();  
			
			return s;
			}catch(Exception e){ System.out.println(e);return s; }
		
	
			
	}
	public List<Appointment> getAllByUser(int idd)
	{
		List<Appointment> s = new ArrayList<Appointment>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("select * from sss.appointment where client = ? and canceled = 0 ");  
			stmt.setInt(1,idd);
			ResultSet rs=stmt.executeQuery(); 
			

			
			
			while(rs.next())  
			{
				int i =1;
				int id = rs.getInt(i++);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime date = LocalDateTime.parse(rs.getString(i++),formatter);
				Coach pera = pera1.getOne(rs.getInt(i++));
				int h = rs.getInt(i++);
				User a = new User();
				  if (rs.wasNull()) 
				  {
				  
				  }
				  else
				  {
					 a = p.getOne(h);
				  }
				
				
				Report b = p1.getOne(a.getId());
				Client p = new Client(a, b);
				Boolean r = Boolean.valueOf(rs.getString(i++));
				Boolean c = Boolean.valueOf(rs.getString(i++));
				int price = rs.getInt(i++);
				
				Appointment ab = new Appointment(id, date, pera, p, c, r,price);
				
			   s.add(ab);
				
			}
			con.close();  
			
			return s;
			}catch(Exception e){ System.out.println(e);return s; }
		
	
			
	}
	public List<Appointment> getAllReal()
	{
		List<Appointment> s = new ArrayList<Appointment>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("select * from sss.appointment where reserved = 0 and canceled = 0 and StartDateTime >= NOW();");  
			ResultSet rs=stmt.executeQuery(); 
			

			
			
			while(rs.next())  
			{
				int i =1;
				int id = rs.getInt(i++);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				LocalDateTime date = LocalDateTime.parse(rs.getString(i++),formatter);
				Coach pera = pera1.getOne(rs.getInt(i++));
				int h = rs.getInt(i++);
				User a = new User();
				  if (rs.wasNull()) 
				  {
				  
				  }
				  else
				  {
					 a = p.getOne(h);
				  }
				
				
				Report b = p1.getOne(a.getId());
				Client p = new Client(a, b);
				Boolean r = Boolean.valueOf(rs.getString(i++));
				Boolean c = Boolean.valueOf(rs.getString(i++));
				int price = rs.getInt(i++);
				
				Appointment ab = new Appointment(id, date, pera, p, c, r,price);
				
			   s.add(ab);
				
			}
			con.close();  
			
			return s;
			}catch(Exception e){ System.out.println(e);return s; }
		
	
			
	}
	public int Save(Appointment a) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("INSERT INTO sss.appointment(`StartDateTime`,`coach`,`client`,`reserved`,`canceled`,`price`)VALUES(?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);  
			stmt.setString(1,a.getStartDateTime().toString());
			stmt.setInt(2, a.getCoach().getId());
			stmt.setNull(3,Types.NULL);
			stmt.setBoolean(4, a.isReserved());
			stmt.setBoolean(5, a.isCanceled());
			stmt.setInt(6, a.getPrice());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
			int key = rs.next() ? rs.getInt(1) : 0;
			con.close(); 
			return key;
				
			
			
			 
			
		
			
	}
	public int Reserve(int id,String a) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("update sss.appointment set reserved = 1,client = ? where id = ?", Statement.RETURN_GENERATED_KEYS);  
			stmt.setInt(1,id);
			stmt.setString(2,a);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
			int key = rs.next() ? rs.getInt(1) : 0;
			con.close(); 
			return key;
				
			
			
			 
			
		
			
	}
	public int Cancle(String a) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("update sss.appointment set reserved = 0,client = ?,canceled =0 where id = ?", Statement.RETURN_GENERATED_KEYS);  
			stmt.setNull(1, Types.NULL);
			stmt.setString(2,a);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
			int key = rs.next() ? rs.getInt(1) : 0;
			con.close(); 
			return key;
				
			
			
			 
			
		
			
	}
	public int CanclePay(String a) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("update sss.appointment set reserved = 0,canceled =1 where id = ?", Statement.RETURN_GENERATED_KEYS);  
			stmt.setString(1,a);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
			int key = rs.next() ? rs.getInt(1) : 0;
			con.close(); 
			return key;
				
			
			
			 
			
		
			
	}
}
