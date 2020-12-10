package com.wf.training.bootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Bean will be created
// registered with HandlerMapper

// shall contain processing logic
@Controller
public class HomeController {

	
	
	// to respond to root URL (home/welcome file)
	@RequestMapping("/")
	public String home() {
		// add business logic
		
		// respond back with a view page name
		return "index";
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
		// add business logic
		
		// respond back with a view page name
		return "error-page";
	}
	
	@RequestMapping("/custom-login")
	public String customLogin() {
		// add business logic
		
		// respond back with a view page name
		return "custom-login";
	}
	
	
}
