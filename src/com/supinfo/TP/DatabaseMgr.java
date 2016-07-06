package com.supinfo.TP;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseMgr 
{
		
		private final String url="jdbc:mysql://127.0.0.1:3306/suptodo";
		private final String username="root";
		private final String password="";
		protected Connection con;
		
		public DatabaseMgr() {
			try{
				this.con =DriverManager.getConnection(this.url,this.username,this.password); ;
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
}



