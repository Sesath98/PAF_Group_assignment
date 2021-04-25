package com;

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

import model.inq;

import com.google.gson.*;
@Path("/Feedback")

public class inqservice {

	inq feedbackobj = new inq();

	 @GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readfeedback()
	{
	return feedbackobj.readFeedback();
	//return "Hello";
	}

	 @POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertfeedback(
	@FormParam("id") String id,
	@FormParam("name") String name,
	@FormParam("email") String email,
	@FormParam("message") String message)
	{
	String output = feedbackobj.insertFeedback(id,name,email,message);
	return output;
	}

	 @PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateFeedback(String itemData)
	{
	//Convert the input string to a JSON object
	JsonObject feedbackObject = new JsonParser().parse(itemData).getAsJsonObject();
	//Read the values from the JSON object
	String id = feedbackObject.get("id").getAsString();
	String name = feedbackObject.get("name").getAsString();
	String email = feedbackObject.get("email").getAsString();
	String message = feedbackObject.get("message").getAsString();
	String output = feedbackobj.updateFeedback(id, name, email,message);
	return output;
	}
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletefeedback(String itemData)
	{
	JsonObject feedbackObject = new JsonParser().parse(itemData).getAsJsonObject();
	//Read the value from the element <itemID>
	String id = feedbackObject.get("id").getAsString();
	String output = feedbackobj.deleteFeedback(id);
	return output;
	}
	
}
