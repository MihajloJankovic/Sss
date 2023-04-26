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
import sss.model.Coach;
import sss.model.Language;
import sss.model.Rank;
import sss.model.User;
import sss.model.type;

public class DaoCoach {
	private DaoUser a = new DaoUser();
public List<Coach> getAll() throws SQLException{
		
	
		
		List <Coach> users = new ArrayList<Coach>();
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select coach.id,coach.rank,coach.degree,AVG(s.rating) from coach CROSS JOIN coachreting s  where approved = true group by id");  
			
		
			while(rs.next())  
			{
				int i =1;
				int id = rs.getInt(i++);
				Rank rank = Rank.valueOf(rs.getString(i++));
				String degree = rs.getString(i++);
				double rating = rs.getDouble(i++);
				Coach pera = new Coach(id,rank,rating,degree);
				users.add(pera);
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			
		return users;
		}
public List<Coach> getAllforApproval() throws SQLException, ClassNotFoundException{
	
	
	
	List <Coach> users = new ArrayList<Coach>();
	
	
		
		
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sss","root","root");  

		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select coach.id,coach.rank,coach.degree,AVG(s.rating) from coach CROSS JOIN coachreting s where approved = false group by id");  


		while(rs.next())  
		{
			int i =1;
			int id = rs.getInt(i++);
			Rank rank = Rank.valueOf(rs.getString(i++));
			String degree = rs.getString(i++);
			double rating = rs.getDouble(i++);
			Coach pera = new Coach(id,rank,rating,degree);
			users.add(pera);
		}
		
		con.close();  
		
		
	return users;
	}
	public Coach getOne(int idd) throws SQLException{
		
		
		Coach user = null;
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  


			PreparedStatement stmt=con.prepareStatement("select coach.id,coach.rank,coach.degree,AVG(s.rating) from coach CROSS JOIN coachreting s  where coach.id = ? group by id;");  
			stmt.setInt(1,idd);
			ResultSet rs=stmt.executeQuery(); 
			int i =1;
		
			while(rs.next())  
			{
				int id = rs.getInt(i++);
				Rank rank = Rank.valueOf(rs.getString(i++));
				String degree = rs.getString(i++);
				double rating = rs.getDouble(i++);
				Coach pera = new Coach(id,rank,rating,degree);
				user = pera;
			}
			
			con.close(); 
			return user;
			}catch(Exception e){ System.out.println(e);}
		return null;  
			
	
		}
	public void SaveRating(int id ,int rating) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("insert into coachreting(id,rating) values(?,?);", Statement.RETURN_GENERATED_KEYS);  
			stmt.setInt(1,id);
			stmt.setInt(2,rating);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
			
			con.close(); 

				
			
			
			 
			
		
			
	}
	public void Save(int id ,Rank rank,String degree) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  
		
			PreparedStatement stmt=con.prepareStatement("insert into coach(id,rank,degree,approved) values(?,?,?,0);", Statement.RETURN_GENERATED_KEYS);  
			stmt.setLong(1, id);
			stmt.setString(2,rank.toString());
			stmt.setString(3,degree);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
			
			con.close(); 

				
			
			
			 
			
		
			
	}
	public void Approve(int id) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  
		
			PreparedStatement stmt=con.prepareStatement("update coach  set approved = 1 where id = ?", Statement.RETURN_GENERATED_KEYS);  
			stmt.setLong(1, id);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
			
			con.close(); 

				
			
			
			 
			
		
			
	}
	public void Decline(int id) throws ClassNotFoundException, SQLException
	{
		 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  
		
			PreparedStatement stmt=con.prepareStatement("delete from  coach where id = ?", Statement.RETURN_GENERATED_KEYS);  
			stmt.setLong(1, id);
			stmt.executeUpdate();
			a.Delete(id);
			ResultSet rs = stmt.getGeneratedKeys();  
			
			con.close(); 

				
			
			
			 
			
		
			
	}

}
