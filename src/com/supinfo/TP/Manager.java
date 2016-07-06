package com.supinfo.TP;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager extends User {
	public String Name;
	public String Password;
	public TodoList todo;
	
	public Manager(String name,String password)
	{
		this.Name=name;
		this.Password=password;
	}
	
	public boolean login() throws SQLException{
		
	    PreparedStatement pstmt = this.con.prepareStatement(
			"SELECT Id FROM manager WHERE Name = ? AND Password = ?"
	    	);
	    
		pstmt.setString(1, this.Name);
		pstmt.setString(2, this.Password);

        ResultSet id=pstmt.executeQuery();
        
		if(id.next())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void addManager() throws SQLException{
		
	    PreparedStatement pstmt = this.con.prepareStatement(
			"insert into manager(Name,Password) values(?,?)"
	    	);
	    
		pstmt.setString(1, Name);
		pstmt.setString(2, Password);
		pstmt.executeUpdate();
        
	}
	
	public void Add_Todo(String todo,String date)
	{	
		this.todo= new TodoList(111111,todo,date);
		try {
			this.todo.Add_Todo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
