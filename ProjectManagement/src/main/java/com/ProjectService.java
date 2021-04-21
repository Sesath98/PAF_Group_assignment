package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	


}
