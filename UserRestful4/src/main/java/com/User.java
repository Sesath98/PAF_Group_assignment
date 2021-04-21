package com;


import model.Usermodel;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Path("/User")
public class User {
		
		Usermodel UserObj = new Usermodel();
		
		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		
		public String readItems()
		{
		
			return UserObj.readItems();
		
		}
	
		
		@POST
		@Path("/insert")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertUsers(@FormParam("userId") int userId,
		@FormParam("username") String username,
		@FormParam("phone_no") String phone_no,
		@FormParam("address") String address,
		@FormParam("designation") String designation)
		{
		String output = UserObj.insertUsers(userId, username, phone_no, address ,designation);
		return output;
		}
		
		
		@PUT
		@Path("/delete")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateUsers(String itemData)
		{
		//Convert the input string to a JSON object
		JsonObject UserObject = new JsonParser().parse(itemData).getAsJsonObject();
		//Read the values from the JSON object
		
		String userId = UserObject.get("userId").getAsString();
		String username = UserObject.get("username").getAsString();
		String phone_no = UserObject.get("phone_no").getAsString();
		String address = UserObject.get("address").getAsString();
		String designation = UserObject.get("designation").getAsString();
		String output = UserObj.updateUsers(userId, username, phone_no, address ,designation);
		return output;
		}
		
		
		@DELETE
		@Path("/delete")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteItem(String itemData)
		{
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());
		//Read the value from the element <id>
		String UserID = doc.select("userId").text();
		String output = UserObj.deleteUsers(UserID);
		return output;
		}
		
		
	
	
}
