package ws;

import java.util.*;

import javax.ws.rs.GET; 
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
  

@Path("/hellorest")
	public class HelloRest{

	@GET 
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(){
		System.out.println("@produces HelloRest");
		
		return " Stringgggggggg";
	}
	

	@GET 
	@Path("/helloUser")
	@Produces(MediaType.APPLICATION_JSON)
	public MyUser hello2(){
		System.out.println("@produces HelloRest MyUser Class");
		MyUser mu=new MyUser();
		mu.id="aaaa";
		mu.name="niranjan";
		return mu;
	}
	
	
	@GET 
	@Path("/hi/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String hi(@PathParam(value="name") String name){
	return "Hi "+name;
	}
	@GET 
	@Path("/sum/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sum(@PathParam(value="a") String a, @PathParam(value="b") String b){
	return "Sum is "+(Integer.parseInt(a)+Integer.parseInt(b));

	
}
}