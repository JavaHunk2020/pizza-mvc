package com.kuebiko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuebiko.controller.dto.SignupDTO;
import com.kuebiko.service.SignupService;

@Controller
public class SignupController {
	
	 
	 @Autowired
	 private SignupService signupService;
	 
	 
	 @GetMapping("/signup")
		public String showSignup() {
			return "signup";
	 }
	 
	 @PostMapping("/signup")
		public String signupPost(@ModelAttribute SignupDTO signupDTO) {
		 signupService.persist(signupDTO);
			return "login";
	 }
	
	  @PostMapping("/usignup")
		public String usignup(@ModelAttribute SignupDTO signupDTO) {
		  signupService.updateSignup(signupDTO);
			return "redirect:/users";
	 }
	
	@GetMapping("/editSignup")
	public String editSignup(@RequestParam int  sid,Model model) {
			//Adding signupList into request scope
		    SignupDTO entity=signupService.findById(sid);
			model.addAttribute("entity", entity);
			return "editSignup";
    } 
 
	
	   @GetMapping("/deleteSignup")
		public String deleteUser(@RequestParam int  sid) {
		   signupService.deleteById(sid);
			return "redirect:/users";
	 } 
	 
	
	@GetMapping("/users")
	public String showUser(Model model) {
		List<SignupDTO> signupList=signupService.findAll();
		model.addAttribute("signupList", signupList);
		return "signups";		
	}

}
