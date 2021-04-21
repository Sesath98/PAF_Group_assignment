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
import com.google.gson.*;


import model.project;
@Path("/Projects")
public class ProjectService {
	project projectObj = new project();
	
	
	@GET
	@Path("/view")
	@Produces(MediaType.TEXT_HTML)
	public String viewProjects()
	 {
		return projectObj.viewProjects(); 
	 }
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertProject(@FormParam("authorName") String aname,
	 @FormParam("projectCategory") String pcat,
	 @FormParam("projectName") String pname,
	 @FormParam("projectPrice")String pprice,
	 @FormParam("authorEmail") String aemail,
	@FormParam("projectDesc") String pdesc)
	{
	 String output = projectObj.insertProject(aname, pcat, pname,pprice, aemail,pdesc);
	return output;
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProject(String projectData)
	{
	//Convert the input string to a JSON object
	 JsonObject projectObject = new JsonParser().parse(projectData).getAsJsonObject();
	//Read the values from the JSON object
	 String projectID =projectObject.get("projectID").getAsString();
	 String authorName = projectObject.get("authorName").getAsString();
	 String projectCategory = projectObject.get("projectCategory").getAsString();
	 String projectName = projectObject.get("projectName").getAsString();
	 String projectPrice = projectObject.get("projectPrice").getAsString();
	 String authorEmail= projectObject.get("authorEmail").getAsString();
	 String projectDesc = projectObject.get("projectDesc").getAsString();
	 String output = projectObj.updateProject(projectID , authorName , projectCategory , projectName, projectPrice , authorEmail , projectDesc);
	return output;
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteProject(String projectData)
	{
	//Convert the input string to an XML document
	JsonObject projectObject = new JsonParser().parse(projectData).getAsJsonObject();

	//Read the value from the element <itemID>
	 String projectID = projectObject.get("projectID").getAsString();
	 String output = projectObj.deleteProject(projectID);
	return output;
	}

}
