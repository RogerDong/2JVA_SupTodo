package com.supinfo.TP;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodoList extends DatabaseMgr
{
	public String Messagee;
	public String Date;
	public int UserId;
	public TodoList(int id,String msg,String date ){
		
		this.UserId=id;
		this.Messagee=msg;
		this.Date=date;
		
	}
	public void Add_Todo() throws SQLException{
		
		PreparedStatement pstmt = this.con.prepareStatement(
				"INSERT INTO todo(MESSAGE,UserID,CHECKED,AddDate) values(?,?,?,?)"
			);
		
		pstmt.setString(1, this.Messagee);
		pstmt.setInt(2, this.UserId);
		pstmt.setString(3, "false");
		pstmt.setString(4, this.Date);
		
		pstmt.executeUpdate();
	}

}
