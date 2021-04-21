package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Cart;

@Path("/Cart")
public class CartService {
	
	
	Cart cartobj = new Cart();
	
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readItems() 
	 { 
		return cartobj.readItems(); 
		//return "Hello";
	 } 
	
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertItem(
			
	 @FormParam("id") String id,
	 @FormParam("name") String name, 
	 @FormParam("price") String price, 
	 @FormParam("noofproduct") String noofproduct) 
	{ 
	 String output = cartobj.insertItem(id,name,price,noofproduct); 
	return output; 
	}
	

}
