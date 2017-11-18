package edu.mum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.domain.Register;
import edu.mum.service.RegisterService;
import edu.mum.service.UserCredentialsService;

@Controller
public class HomeController {

	@Autowired
	RegisterService registerService;

	@Autowired
	UserCredentialsService userCredentialService;

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model, Principal principal) {

		model.addAttribute("greeting", "Welcome to our community, Kimosabe!!");
		model.addAttribute("tagline", "The one and only place to live, work and play!!");

		model.addAttribute("userName", principal.getName());
		Register register = registerService
				.findByUserCredentials(userCredentialService.findByUsername(principal.getName()));

		model.addAttribute("hasImage", register.isHasImage());

		return "welcome";
	}

	// @ModelAttribute ("homeTestOrder")
	// public String testOrder() {
	//
	// // test interceptor Order
	// System.out.println("CONTROLLER @MODELATTRIBUTE PREHANDLE");
	//
	// return "This is CONTROLLER ORDER!";
	// }

}
