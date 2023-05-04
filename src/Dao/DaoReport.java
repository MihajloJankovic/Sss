package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import sss.model.Adress;
import sss.model.Goal;
import sss.model.Props;
import sss.model.Report;
import sss.model.User;

public class DaoReport {
	DaoUser p = new DaoUser();
	//  
	public Report getOne(int idd)
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("SELECT * FROM report WHERE id=(SELECT max(id) FROM report) and user = ?;");  
			stmt.setInt(1,idd);
			ResultSet rs=stmt.executeQuery(); 
			
			int i =1;
			while(rs.next())  
			{
				int id = rs.getInt(i++);
				Double height = rs.getDouble(i++);
				Double weight = rs.getDouble(i++);
				String health = rs.getString(i++);
				int user =rs.getInt(i++) ;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String date = rs.getString(i++) ;
		        LocalDate localDate = LocalDate.parse(date, formatter);
				
				List<Props> props = new ArrayList<Props>();
				List<Goal> goals = new ArrayList<Goal>();
				
				PreparedStatement stmt1=con.prepareStatement("SELECT distinct goal FROM goals WHERE id=?;");  
				stmt1.setInt(1,user);
				ResultSet rs1=stmt1.executeQuery(); 
			
				while(rs1.next())  
				{
					int g = 1;
					goals.add(Goal.valueOf(rs1.getString(g)));
					
				
					
					
				}
				PreparedStatement stmt2=con.prepareStatement("SELECT distinct prop FROM props WHERE id=?;");  
				stmt2.setInt(1,user);
				ResultSet rs2=stmt2.executeQuery(); 
				
				while(rs2.next())  
				{
					 int h = 1;
					props.add(Props.valueOf(rs2.getString(h)));
					
				
					
					
				}
				Report a = new Report(id, height, weight, health,goals,props,user,localDate);
			   return a;
				
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
		return null;  
			
	}
	public Report getOneByID(int idd)
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("SELECT  * FROM report WHERE id= ?");  
			stmt.setInt(1,idd);
			ResultSet rs=stmt.executeQuery(); 
			
			int i =1;
			while(rs.next())  
			{
				int id = rs.getInt(i++);
				Double height = rs.getDouble(i++);
				Double weight = rs.getDouble(i++);
				String health = rs.getString(i++);
				int user =rs.getInt(i++) ;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String date = rs.getString(i++) ;
		        LocalDate localDate = LocalDate.parse(date, formatter);
				
				List<Props> props = new ArrayList<Props>();
				List<Goal> goals = new ArrayList<Goal>();
				
				PreparedStatement stmt1=con.prepareStatement("SELECT  distinct goal FROM goals WHERE id=?;");  
				stmt1.setInt(1,user);
				ResultSet rs1=stmt1.executeQuery(); 
			
				while(rs1.next())  
				{
					int g = 1;
					goals.add(Goal.valueOf(rs1.getString(g)));
					
				
					
					
				}
				PreparedStatement stmt2=con.prepareStatement("SELECT distinct prop FROM props WHERE id=?;");  
				stmt2.setInt(1,user);
				ResultSet rs2=stmt2.executeQuery(); 
				
				while(rs2.next())  
				{
					 int h = 1;
					props.add(Props.valueOf(rs2.getString(h)));
					
				
					
					
				}
				Report a = new Report(id, height, weight, health,goals,props,user,localDate);
			   return a;
				
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
		return null;  
			
	}
	public List<Report> getAllByUser(int idd)
	{
		List<Report> reps= new ArrayList<Report>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("SELECT * FROM report WHERE  user = ?;");  
			stmt.setInt(1,idd);
			ResultSet rs=stmt.executeQuery(); 
			
			
			while(rs.next())  
			{
				int i =1;
				int id = rs.getInt(i++);
				Double height = rs.getDouble(i++);
				Double weight = rs.getDouble(i++);
				String health = rs.getString(i++);
				int user =rs.getInt(i++) ;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String date = rs.getString(i++) ;
		        LocalDate localDate = LocalDate.parse(date, formatter);
				
				List<Props> props = new ArrayList<Props>();
				List<Goal> goals = new ArrayList<Goal>();
				
				PreparedStatement stmt1=con.prepareStatement("SELECT distinct goal FROM goals WHERE id=?;");  
				stmt1.setInt(1,user);
				ResultSet rs1=stmt1.executeQuery(); 
				
				while(rs1.next())  
				{
					int g = 1;
					goals.add(Goal.valueOf(rs1.getString(g++)));
					
				
					
					
				}
				PreparedStatement stmt2=con.prepareStatement("SELECT distinct prop FROM props WHERE id=?;");  
				stmt2.setInt(1,user);
				ResultSet rs2=stmt2.executeQuery(); 
				 
				while(rs2.next())  
				{
					int g = 1;
					props.add(Props.valueOf(rs2.getString(g++)));
					
				
					
					
				}
				Report a = new Report(id, height, weight, health,goals,props,user,localDate);
			   reps.add(a);
				
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
		return reps; 
			
	}
	public int Save(double a,double b,String c,int d,List<Goal> goals,List<Props> props) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("INSERT INTO sss.report(`height`,`weight`,`healthstatus`,`user`,`date`)VALUES(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);  
			stmt.setDouble(1,a);
			stmt.setDouble(2,b);
			stmt.setString(3,c);
			stmt.setInt(4, d);
			stmt.setString(5, LocalDate.now().toString());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
			int key = rs.next() ? rs.getInt(1) : 0;

			for (Goal goal : goals) {
				
				PreparedStatement stmt1=con.prepareStatement("INSERT INTO sss.goals(`id`,`goal`)VALUES(?,?);", Statement.RETURN_GENERATED_KEYS);  
				stmt1.setInt(1,d);
				stmt1.setString(2,goal.toString());
	
				
				stmt1.executeUpdate();
			}
	for (Props goal : props) {
				
				PreparedStatement stmt1=con.prepareStatement("INSERT INTO sss.props(`id`,`prop`)VALUES(?,?);", Statement.RETURN_GENERATED_KEYS);  
				stmt1.setInt(1,d);
				stmt1.setString(2,goal.toString());
	
				
				stmt1.executeUpdate();
			}
			con.close(); 
			return key;
				
			
			
			 
			
		
			
	}
}
