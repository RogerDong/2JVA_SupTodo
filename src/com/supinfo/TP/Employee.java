package com.supinfo.TP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee extends User 
{
	public String Name;
	public String Password;
	
	public Employee(String name,String password){
		
		this.Name=name;
		this.Password=password;
	}
	
	public boolean login(){
		//ResultSet id =null;
		try
		{	
			PreparedStatement pstmt = this.con.prepareStatement(
				"SELECT id FROM employee WHERE Name = ? AND Password = ?"
				);
			
			pstmt.setString(1, this.Name);
			pstmt.setString(2, this.Password);

			ResultSet id = pstmt.executeQuery();
		
			if(id.next())
			{
				return true;
			}else
			{
				return false;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public void addEmployee() throws SQLException{
		
	    PreparedStatement pstmt = this.con.prepareStatement(
			"insert into employee(Name,Password) values(?,?)"
	    	);
	    
		pstmt.setString(1,Name);
		pstmt.setString(2,Password);
		pstmt.executeUpdate();
        
	}
	public ArrayList<String> get_Todo() throws SQLException{
		
		ArrayList<String> myMessage=new ArrayList<String>();
		
		this.con.setAutoCommit(false);
		PreparedStatement pstmt = this.con.prepareStatement(
				"SELECT message FROM todo");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			myMessage.add(rs.getString("message"));
		}
		return myMessage;
	}

}
