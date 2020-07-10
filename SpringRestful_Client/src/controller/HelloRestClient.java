package controller;

import java.text.MessageFormat;

import javax.ws.rs.core.*;

import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.*;

public class HelloRestClient{
	private WebResource webResource;
	private Client client;
	private static final String BASE_URI="http://localhost:8080/RestfulSpring/rest";
	
	public HelloRestClient(){
	client=Client.create(new DefaultClientConfig());
	webResource=client.resource(BASE_URI).path("hellorest");
	}
	
	public String hello() throws UniformInterfaceException{
WebResource	resource=webResource;
System.out.println("client hello 1");
resource=resource.path(MessageFormat.format("hello", new Object[] {}));
System.out.println("client hello 2");
Builder b=resource.accept(MediaType.TEXT_PLAIN);
return b.get(String.class);


}
	
	public String hello2() throws UniformInterfaceException{
WebResource	resource=webResource;
System.out.println("client hello 1");
resource=resource.path(MessageFormat.format("helloUser", new Object[] {}));
System.out.println("client hello 2");
Builder b=resource.accept(MediaType.APPLICATION_JSON);
return b.get(String.class);


}
	
/*	public String hi(String name ) throws UniformInterfaceException{
WebResource	resource=webResource;
resource=resource.path(MessageFormat.format("hi/{name}", new Object[] {name}));
return resource.accept(MediaType.TEXT_PLAIN).get(String.class);

} */
	 
	}
	

