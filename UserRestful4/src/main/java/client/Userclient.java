package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

public class Userclient {

		public static void main (String []args) {
			

			Client client = Client.create();
			
			WebResource resource = client.resource("http://localhost:8081/UserRestful4/myService/user/all");
			String output = resource.get(String.class);
//			return "From available users" + output;
			
			System.out.println("From available users" + output);
			
		}			
		
}
