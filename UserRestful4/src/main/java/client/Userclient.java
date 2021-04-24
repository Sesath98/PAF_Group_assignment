//package client;
//
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.WebResource;
//
//import javax.ws.rs.client.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//public class Userclient {
//
//		public static void main (String []args) {
//			
////			Client client = Client.create();
////					
////			String output = resource.get(String.class);
//////			return "From available users" + output;
////			
////			System.out.println("From available users" + output);
////			Response response = client.target("http://localhost:8081/UserRestful4/myService/user/all").request().get();			
//		
//			javax.ws.rs.client.Client client = ClientBuilder.newClient();
//			
//			WebTarget target = client.target("http://localhost:8081/UserRestful4/userService/user/all");
//			System.out.println(
//					 
//					target.request(MediaType.TEXT_HTML).get(String.class)		
//					); 	
//	
//		}			
//		

