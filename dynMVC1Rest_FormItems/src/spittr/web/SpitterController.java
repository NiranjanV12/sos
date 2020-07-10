package spittr.web;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.AppRepository;
@Controller
@RequestMapping("/spitter")
public class SpitterController {

	@RequestMapping(value="/register", method=GET)
	public String showRegistrationForm(Model model) {
		System.out.println("ergister formmmmmmmmmmmmmmmmmmmmm");
	model.addAttribute(new Spitter());
	return "registerForm";
	}
}