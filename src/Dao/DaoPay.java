package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sss.model.Adress;
import sss.model.Appointment;
import sss.model.Goal;
import sss.model.Language;
import sss.model.Props;
import sss.model.Report;
import sss.model.User;
import sss.model.type;

public class DaoPay {

	DaoAppointment dao = new DaoAppointment();
	DaoUser  ca= new DaoUser();
	public void AutoPay()
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  
			List<Appointment> aps = dao.getAllPay();
			for (Appointment appointment : aps) 
			{
				
						PreparedStatement stmt=con.prepareStatement("INSERT INTO sss.pay(`coach`,`client`,`price`,`date`)VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);  
						stmt.setInt(1,appointment.getClient().getUser().getId());
						stmt.setInt(2,appointment.getClient().getUser().getId());
						stmt.setInt(3,appointment.getPrice());
						stmt.setString(4,appointment.getStartDateTime().toString());
						stmt.executeUpdate();
			
					
			}
			con.close(); 

			
			}
			catch(Exception e){ System.out.println(e);}
		
		
	
			
			
			
			
			
			
			
			
	}

	public List<String> BestCoaches()
	{
		List<String> coaches = new ArrayList<String>();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  
			
						PreparedStatement stmt=con.prepareStatement("SELECT DISTINCT coach from  pay a where(select Sum(price) from pay b where a.coach = b.coach)>0", Statement.RETURN_GENERATED_KEYS);  
				
				
				
						ResultSet rs=stmt.executeQuery(); 
						int i =1;
					
						while(rs.next())  
						{
						
							int coach = rs.getInt(i);
							
							coaches.add(ca.getOne(coach).getFirstname());
							
						}
						
						con.close();  
						return coaches;
			
					
			
			

			
			}
			catch(Exception e){ System.out.println(e);}
		return coaches;
		
		
	
			
			
			
			
			
			
			
			
	}
	public double IncomeiNTERVAL(String d1,String d2)
	{
	
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  
			
						PreparedStatement stmt=con.prepareStatement("SELECT SUM(price) from  pay  WHERE (date BETWEEN '"+d1+"' AND '"+ d2+"')", Statement.RETURN_GENERATED_KEYS);  
				
						ResultSet rs=stmt.executeQuery(); 
						int i =1;
					
						while(rs.next())  
						{
						
							double coach = rs.getInt(i) * 0.1;
							
							return coach;
							
						}
						
						con.close();  
						
			
					
			
			

			
			}
			catch(Exception e){ System.out.println(e);}
		return 0;
		
				
	}
	public double Month()
	{
	
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  
			
						PreparedStatement stmt=con.prepareStatement("SELECT SUM(price) from  pay where date  > (NOW() - INTERVAL 31 DAY) ", Statement.RETURN_GENERATED_KEYS);  
				
				
				
						ResultSet rs=stmt.executeQuery(); 
						int i =1;
					
						while(rs.next())  
						{
						
							double coach = rs.getInt(i) * 0.1;
							
							return coach;
							
						}
						
						con.close();  
						
			
					
			
			

			
			}
			catch(Exception e){ System.out.println(e);}
		return 0;
		
				
	}
	public double IncomeWeek()
	{
	
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  
			
						PreparedStatement stmt=con.prepareStatement("SELECT SUM(price) from  pay where date  > (NOW() - INTERVAL 7 DAY) ", Statement.RETURN_GENERATED_KEYS);  
				
				
				
						ResultSet rs=stmt.executeQuery(); 
						int i =1;
					
						while(rs.next())  
						{
						
							double coach = rs.getInt(i) * 0.1;
							
							return coach;
							
						}
						
						con.close();  
						
			
					
			
			

			
			}
			catch(Exception e){ System.out.println(e);}
		return 0;
		
				
	}
	public double IncomeToday()
	{
	
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  
			
						PreparedStatement stmt=con.prepareStatement("SELECT SUM(price) from  pay where date = CURDATE() ", Statement.RETURN_GENERATED_KEYS);  
				
				
				
						ResultSet rs=stmt.executeQuery(); 
						int i =1;
					
						while(rs.next())  
						{
						
							Double coach = rs.getInt(i) * 0.1;
							
							return coach;
							
						}
						
						con.close();  
						
			
					
			
			

			
			}
			catch(Exception e){ System.out.println(e);}
		return 0;
		
				
	}
}
