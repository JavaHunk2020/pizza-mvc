package com.kuebiko.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuebiko.controller.dto.SignupDTO;
import com.kuebiko.service.SignupService;

@Controller
public class LoginController {
	
	@Autowired
	private SignupService signupService;

	@GetMapping({ "/auth", "/", "/tea" })
	public String loginPage() {
		// WEB-INF/pages/login.jsp
		return "login";
	}

	@PostMapping("/auth")
	public String loginPost(@RequestParam String username,@RequestParam String password,Model model,HttpSession session) {
		SignupDTO signupDTO = signupService.authUser(username, password);
		if (signupDTO != null) {
			model.addAttribute("email", signupDTO.getEmail());
			model.addAttribute("name", signupDTO.getName());
			model.addAttribute("salutation", signupDTO.getSalutation());
			// Expiration -30 minutes
			session.setAttribute("role", signupDTO.getRole());
			// session.setMaxInactiveInterval(60*5);
			/*
			 * if("marry1000".equals(username)) { session.setAttribute("role","admin");
			 * }else { session.setAttribute("role","customer"); }
			 */
			session.setAttribute("name", signupDTO.getName());
			session.setAttribute("email", signupDTO.getEmail());
			session.setAttribute("salutation", signupDTO.getSalutation());
			return "success";
		} else {
			model.addAttribute("message", "Sorry username and password are not correct!");
			return "login";
		}
	}
}
