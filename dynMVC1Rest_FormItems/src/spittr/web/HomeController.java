package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import spittr.Spittle;
@Controller
public class HomeController {
@RequestMapping(value="/", method=GET)
public String home() {
	System.out.println("aaaaaaaaahome ");
return "home";
}

/*@RequestMapping(value="/abc", method=GET)
public String abc() {
	System.out.println("abcccccccccccccccccccccccccccccccccccccc ");
return "create";
}
*/

/*
@RequestMapping(value="/reqRestAllUsers", method=GET)
public String reqRestAllUsers(Model model) {
	System.out.println("reqRestAllUsers ");
	RestTemplate rest = new RestTemplate();
	
	ResponseEntity<Object[]> res=rest.getForEntity("http://localhost:8080/dynMVC1/restJDBCAllUsers",
			Object[].class);
	
	//ResponseEntity<Spittle> res=rest.getForEntity("http://localhost:8080/dynMVC1/restJDBCAllUsers/{id}",Spittle.class, 102);
	//For put and similarly for post,delete.....rest.put("http://localhost:8080/spittr-api/spittles/{id}",spittle, spittle.getId());
	Object[] obj=res.getBody();
	
	List<Spittle> spittleList =new ArrayList<>();
	LinkedHashMap<String , String> ls;
	Spittle sp;
	
	for(int i=0;i<obj.length;i++){
	
	ls=(LinkedHashMap<String, String>)obj[i];
	sp=new Spittle();
	sp.setId(Long.parseLong(String.valueOf(ls.get("id"))));

	sp.setMessage(ls.get("message"));
	spittleList.add(sp);
	}

	model.addAttribute("spittleList",spittleList);
	
return "DisplaySpittles";
}
*/
}