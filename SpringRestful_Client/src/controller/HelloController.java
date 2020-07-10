package controller;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="hello")
public class HelloController {

	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value="/hellows" ,method=RequestMethod.GET)
	public String hellows(ModelMap mode) {
		System.out.println("hellows contoller strt");
		HelloRestClient hc =new HelloRestClient();
		mode.put("result", hc.hello());
		System.out.println("hellows contoller end");
		return "hellows";
	}
	
	@RequestMapping(value="/hellowsUser" ,method=RequestMethod.GET)
	public String hellowsUsers(ModelMap mode) {
		System.out.println("hellows contoller strt");
		HelloRestClient hc =new HelloRestClient();
		mode.put("result", hc.hello2());
		System.out.println("hellowsUsers contoller end");
		return "hellows";
	}

}
