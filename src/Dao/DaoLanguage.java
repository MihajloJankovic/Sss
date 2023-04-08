package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sss.model.*;

public class DaoLanguage {
	
	
	public List<Language> getAllbyUser(int ID)
	{
		List <Language> langs = new ArrayList<Language>();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sss","root","root");  

			PreparedStatement stmt=con.prepareStatement("select language from sss.userlanguage where user = ?");
			stmt.setInt(1,ID);
			ResultSet rs=stmt.executeQuery();  
			int i =1;

			while(rs.next())  
			{
				
				String language = rs.getString(i++);
				Language la = Language.valueOf(language);
				langs.add(la);
			}
			
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			
		
		return langs;
		
	}
	

}
