package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class project {
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagement", "root", "");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	
	
public String insertProject(String aname, String pcategory, String ptitile, String aemail, String pdesc)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 // create a prepared statement
	 String query = "insert into project (`projectID`,`authorName`,`projectCategory`,`projectName`,`authorEmail`,`projectDesc`)"
	 + " values (?, ?, ?, ?, ?,?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, aname);
	 preparedStmt.setString(3, pcategory);
	 preparedStmt.setString(4, ptitile);
	 preparedStmt.setString(5, aemail);
	 preparedStmt.setString(6, pdesc);
	// execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while inserting the Project";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
}
