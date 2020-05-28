package com.kuebiko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Repository ,@Service , Component
@Controller
public class HelloController {
	
	//Method =GET
	//action =fool 
	@GetMapping("/fool")
	public String us7us7e() {
		   return "signup";  //signup.jsp
	}

}
