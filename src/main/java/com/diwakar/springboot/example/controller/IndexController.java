package com.diwakar.springboot.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public StringBuilder index() {
	
		StringBuilder welcomeMessage = new StringBuilder();
		
		welcomeMessage.append("Welcome to Spring Boot Application.");
		welcomeMessage.append(" Put a smile on your face :-) , as you have successfully set up and ran your first application.");
		welcomeMessage.append("- Diwakar");
		
		return welcomeMessage;
	}

	
	//In case you want to re-direct to JSP pages,
	//Remove @ResponseBody and put the String  as return type of this index() method and return the jsp page name without .jsp extension. 
	
}
