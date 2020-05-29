package com.kuebiko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuebiko.dao.SignupDao;
import com.kuebiko.entity.SignupEntity;

@Controller
public class SignupController {
	
	 @Autowired
	 private SignupDao signupDao;
	
	  @PostMapping("/usignup")
		public String usignup(@ModelAttribute SignupEntity signupEntity) {
		    signupDao.signup(signupEntity);
			return "redirect:/users";
	 }
	
	@GetMapping("/editSignup")
	public String editSignup(@RequestParam int  sid,Model model) {
			//Adding signupList into request scope
			SignupEntity entity=signupDao.findById(sid);
			model.addAttribute("entity", entity);
			return "editSignup";
    } 
 
	
	   @GetMapping("/deleteSignup")
		public String deleteUser(@RequestParam int  sid) {
 		   signupDao.deleteById(sid);
			return "redirect:/users";
	 } 
	 
	
	@GetMapping("/users")
	public String showUser(Model model) {
		List<SignupEntity> signupList=signupDao.findAll();
		model.addAttribute("signupList", signupList);
		return "signups";		
	}

}
