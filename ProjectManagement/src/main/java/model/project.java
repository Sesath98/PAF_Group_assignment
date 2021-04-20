package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class project {
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagement", "root", "");
	 System.out.println("Connection successful");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
}
