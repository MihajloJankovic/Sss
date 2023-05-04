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
import sss.model.Props;
import sss.model.Report;

public class DaoPay {

	DaoAppointment dao = new DaoAppointment();
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
}
