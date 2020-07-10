package spittr.web;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;
import javax.ws.rs.PathParam;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import spittr.Spittle;

@RestController
@RequestMapping("/restJDBCAllUsers")
public class RestControllerrr {

	private static final String MAX_LONG_AS_STRING="9223372036854775807";


	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	public List<Spittle> spittles(
	@RequestParam(value="max",
	defaultValue=MAX_LONG_AS_STRING) long max,
	@RequestParam(value="count", defaultValue="20") int count) throws SQLException, ClassNotFoundException {
		
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:postgresql://localhost/temp","postgres", "pass@123");
		Statement stmt =connection.createStatement();
		
		
		ResultSet rs=stmt.executeQuery("select * from aa");
		
		List<Spittle> ls=new ArrayList<>();
		
		Spittle aa;
		

		while(rs.next()) 
		{	aa= new Spittle();
			aa.setId(Long.parseLong(rs.getString(1)));
			aa.setMessage(rs.getString(2));
			ls.add(aa);
			
		}
		
		connection.close();
		System.out.println(max+"aaaaaaaaawwwwwwwwwwww"+count);
	return ls;
	
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET,produces="application/json")
	public Spittle getSpittle( @PathVariable int id) throws SQLException, ClassNotFoundException {
		
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:postgresql://localhost/temp","postgres", "pass@123");
		Statement stmt =connection.createStatement();
		System.out.println(id+"ccaaaaawwwwwccccc");
		
		ResultSet rs=stmt.executeQuery("select * from aa where id="+id);
		
		
		Spittle aa= new Spittle();
		while(rs.next())
		{
			aa.setId(Long.parseLong(rs.getString(1)));
			aa.setMessage(rs.getString(2));
		}
		
		connection.close();
	
	return aa;
	
	}
	
	@RequestMapping(value="/{id}/{name}", method=RequestMethod.GET,produces="application/json")
	public Spittle createSpittleByGet( @PathVariable int id,  @PathVariable String name) throws SQLException, ClassNotFoundException {
		
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:postgresql://localhost/temp","postgres", "pass@123");
		Statement stmt =connection.createStatement();
		System.out.println(id+"ccaaaaawwwwwccccc");
		
		try{
		stmt.executeQuery("insert into aa values("+id+", '"+name+"')");
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		
		Spittle aa= new Spittle();

		connection.close();
		
		aa.setId((long)id);
		aa.setMessage(name);
	return aa;
	
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@RequestMapping(value="/create", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public ResponseEntity<Spittle> createSpittleByPOST(@RequestBody Spittle spittle, UriComponentsBuilder ucb) throws SQLException, ClassNotFoundException {
		
		System.out.println("entered");
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:postgresql://localhost/temp","postgres", "pass@123");
		Statement stmt =connection.createStatement();
		System.out.println(spittle.getId()+"ccaaaaawwwwwccccc");
		
		try{
		stmt.execute("insert into aa values("+spittle.getId()+", '"+spittle.getMessage()+"')");
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		connection.close();
		
		//method 1
		/*HttpHeaders headers = new HttpHeaders();
				URI locationUri = URI.create(
				"http://localhost:8080/dynMVC1/restJDBCAllUsers/" + spittle.getId());
				headers.setLocation(locationUri);
				ResponseEntity<Spittle> responseEntity =
				new ResponseEntity<Spittle>(
				spittle, headers, HttpStatus.CREATED);
				return responseEntity;*/
		
		
		//method 2
		HttpHeaders headers = new HttpHeaders();
		URI locationUri =
		ucb.path("/restJDBCAllUsers/")
		.path(String.valueOf(spittle.getId()))
		.build()
		.toUri();
		headers.setLocation(locationUri);
		ResponseEntity<Spittle> responseEntity =
		new ResponseEntity<Spittle>(
		spittle, headers, HttpStatus.CREATED);
		return responseEntity;
		
		
//	return spittle;
	
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public Spittle updateSpittleByPUT(@RequestBody Spittle spittle, @PathVariable int id) throws SQLException, ClassNotFoundException {
		
		
		//method 1
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost/temp");
		ds.setUsername("postgres");
		ds.setPassword("pass@123");
		
		JdbcTemplate jd=new JdbcTemplate(ds);
		jd.update("update  aa  set  a= ? where id =?", spittle.getMessage(),id);
		
		
		//method 2
		/*System.out.println("entered");
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:postgresql://localhost/temp","postgres", "pass@123");
		PreparedStatement pstmt =connection.prepareStatement("update  aa  set  a=? where id =?");
		pstmt.setInt(2,id);
		pstmt.setString(1,spittle.getMessage());
		System.out.println(spittle.getId()+"ccaaaaawwwwwccccc");
		
		try{
		System.out.println(pstmt.executeUpdate());
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		connection.close();*/
		return spittle;
	
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE,produces="application/json")
	public String deleteNyDELETE( @PathVariable int id) throws SQLException, ClassNotFoundException {
		
		
		//method 1
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost/temp");
		ds.setUsername("postgres");
		ds.setPassword("pass@123");
		
		JdbcTemplate jd=new JdbcTemplate(ds);
		jd.update("delete from aa where id =?", id);
		
		
		//method 2
		/*System.out.println("entered");
		Class.forName("org.postgresql.Driver");
		Connection connection = null;
		connection = DriverManager.getConnection("jdbc:postgresql://localhost/temp","postgres", "pass@123");
		PreparedStatement pstmt =connection.prepareStatement("update  aa  set  a=? where id =?");
		pstmt.setInt(2,id);
		pstmt.setString(1,spittle.getMessage());
		System.out.println(spittle.getId()+"ccaaaaawwwwwccccc");
		
		try{
		System.out.println(pstmt.executeUpdate());
		}catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		connection.close();*/
		return "deleted";
	
	}
	
	
	
}
