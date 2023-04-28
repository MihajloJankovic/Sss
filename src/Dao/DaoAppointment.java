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
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
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
				
			   return ab;
				
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
		return null;  
			
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
}
