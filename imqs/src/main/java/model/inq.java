package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class inq {

	private Connection connect()
	{
	Connection con = null;
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	//Provide the correct details: DBServer/DBName, username, password
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedbackproject", "root", "");
	}
	catch (Exception e)
	{e.printStackTrace();}
	return con;
	}
	public String readFeedback() {
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Dtabase connection error"; }
	// Prepare the html table to be displayed
	output = "<table border='1'><tr><th>ID</th><th>Name</th>" +
	"<th>Email</th>" +
	"<th>Message</th></tr>";
	String query = "select * from feedbackpro";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	// iterate through the rows in the result set
	while (rs.next())
	{
	String id = rs.getString("id");
	String name = rs.getString("name");
	String email = rs.getString("email");
	String message = rs.getString("message");

	 // Add into the html table
	output += "<tr><td>" + id + "</td>";
	output += "<td>" + name + "</td>";
	output += "<td>" + email + "</td>";
	output += "<td>" + message + "</td>";
	// buttons
//	output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
//	+ "<td><form method='post' action='items.jsp'>"
//	+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
//	+ "<input name='itemID' type='hidden' value='" + id
//	+ "'>" + "</form></td></tr>";
	}
	con.close();
	// Complete the html table
	output += "</table>";
	}
	catch (Exception e)
	{
	output = "Error while reading the items.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	public String insertFeedback(String id, String name, String email, String message)
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for inserting."; }
	// create a prepared statement
	String query = " insert into feedbackpro(id,name,email,message)"
	+ " values (?, ?, ?, ?)";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	// binding values
	preparedStmt.setString(1, id);
	preparedStmt.setString(2, name);
	preparedStmt.setString(3,email);
	preparedStmt.setString(4, message);
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Inserted successfully";
	}
	catch (Exception e)
	{
	output = "Error while inserting the Feedback";
	System.err.println(e.getMessage());
	}
	return output;
	}
	public String updateFeedback(String id, String name, String email,String message)
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for updating."; }
	// create a prepared statement
	String query = "UPDATE feedbackpro SET name=?,email=?,message=? WHERE id=?";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	// binding values
	preparedStmt.setString(1, name);
	preparedStmt.setString(2, email);
	preparedStmt.setString(3, message);
	preparedStmt.setString(4, id);

	 // execute the statement
	preparedStmt.execute();
	con.close();
	output = "Updated successfully";
	}
	catch (Exception e)
	{
	output = "Error while updating the Feedback information.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	public String deleteFeedback(String id)
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{return "Error while connecting to the database for deleting."; }
	// create a prepared statement
	String query = "delete from feedbackpro where id=?";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	// binding values
	preparedStmt.setString(1,id);
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Deleted successfully";
	}
	catch (Exception e)
	{
	output = "Error while deleting the Feedback Detail.";
	System.err.println(e.getMessage());
	}
	return output;
	}
	
}
