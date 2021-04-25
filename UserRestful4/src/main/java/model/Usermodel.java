package model;

import java.sql.*;
import java.sql.Connection;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.User;
import com.google.gson.*;

import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

public class Usermodel {
	
	
	//creating database connection 
	private Connection connect()
	{
		
	Connection con = null;
	
	try
	{
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paf_project ", "root", "");
	
	}
	catch (Exception e)
	{
		e.printStackTrace();
		
	}
	return con;
	}
	
	
	
	//inserting User values into database
	public String insertUsers(int id, String name, String phone_num, String address_ , String designation_)
	{
	String output = "";
	try
	{
	Connection con = connect();
	if (con == null)
	{
		return "Error while connecting to the database for inserting."; 
		
	}
	// create a prepared statement 
	String query = " insert into users(userId,username,phone_no,address,designation)"
	          + " values (?, ?, ?, ?, ?)";
	
	PreparedStatement preparedStmt = con.prepareStatement(query);
	
	
	preparedStmt.setInt(1, id);
	preparedStmt.setString(2, name);
	preparedStmt.setString(3, phone_num);
	preparedStmt.setString(4, address_);
	preparedStmt.setString(5, designation_);
	

	
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Inserted successfully";
	
	}
	
	catch (Exception e)
	
	{
	output = "Error while inserting the users into database.";
	System.err.println(e.getMessage());
	
	}
	
	return output;
	
	}	
	
	
	
	public String readItems()
	
	{
		
	String output = "";
	
	try
	{
		
	Connection con = connect();
	
	if (con == null)
	{
		return "Error while connecting to the database for reading."; 
		
	}
	
	output = "<table border='1'><tr><th>User ID</th><th>User Name</th>" +
	"<th>Phone number</th>" +
	"<th>Address</th>" +
	"<th>Designation</th></tr>";
	
	String query = "select * from users";
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	
	
	
	while (rs.next())
	{
		
	String id = Integer.toString(rs.getInt("userId"));
	String name = rs.getString("username");
	String phone_num = rs.getString("phone_no");
	String address_ = rs.getString("address");
	String designation_ = rs.getString("designation");
	
	// Add into the html table
	output += "<tr><td>" + id + "</td>";
	output += "<td>" + name + "</td>";
	output += "<td>" + phone_num + "</td>";
	output += "<td>" + address_ + "</td>";
	output += "<td>" + designation_ + "</td>";


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
	
	
	
	
	
	
	public String updateUsers(String id, String name, String phone_num, String address_ , String designation_)
	
	{
		
	String output = "";
	
	try
	
	{
		
	Connection con = connect();
	
	if (con == null)			
	{
		return "Error while connecting to the database for updating."; }
	// create a prepared statement
	String query = "UPDATE users SET username=?,phone_no=?,address=?,designation =?WHERE userId=?";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	
	// binding values
	
	preparedStmt.setString(1, name);
	preparedStmt.setString(2, phone_num);
	preparedStmt.setString(3, address_);
	preparedStmt.setString(4, designation_);
	preparedStmt.setString(5, id);
	
	// execute the statement
	
	preparedStmt.execute();
	con.close();
	output = "Updated successfully";
	
	}
	
	catch (Exception e)
	
	{
	output = "Error while updating the users.";
	System.err.println(e.getMessage());
	
	}
	return output;
	
	}
	
	
	
	
	public String deleteUsers(String id)
	
	{
	String output = "";
	
	try
	{
		
	Connection con = connect();
	if (con == null)
	
	{
		return "Error while connecting to the database for deleting."; 
	}
	
	// create a prepared statement
	
	String query = "delete from users where userId=?";
	PreparedStatement preparedStmt = con.prepareStatement(query);
	
	// binding values
	preparedStmt.setInt(1, Integer.parseInt(id));
	
	
	System.out.println(id);
	
	// execute the statement
	preparedStmt.execute();
	con.close();
	output = "Deleted successfully";
	
	}
	catch (Exception e)
	
	{
		
	output = "Error while deleting the users.";
	System.err.println(e.getMessage());
	
	}
	
	return output;
	
	}

	}

