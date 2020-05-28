package com.kuebiko.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuebiko.dao.SignupDao;
import com.kuebiko.dao.SignupDaoImpl;
import com.kuebiko.entity.SignupEntity;

@Controller
public class LoginController {

	@GetMapping({ "/auth", "/", "/tea" })
	public String loginPage() {
		// WEB-INF/pages/login.jsp
		return "login";
	}

	@PostMapping("/auth")
	public String loginPost(@RequestParam String username,@RequestParam String password,Model model,HttpSession session) {
		SignupDao signupDao = new SignupDaoImpl();
		SignupEntity signupEntity = signupDao.authUser(username, password);
		if (signupEntity != null) {
			model.addAttribute("email", signupEntity.getEmail());
			model.addAttribute("name", signupEntity.getName());
			model.addAttribute("salutation", signupEntity.getSalutation());
			// Expiration -30 minutes
			session.setAttribute("role", signupEntity.getRole());
			// session.setMaxInactiveInterval(60*5);
			/*
			 * if("marry1000".equals(username)) { session.setAttribute("role","admin");
			 * }else { session.setAttribute("role","customer"); }
			 */
			session.setAttribute("name", signupEntity.getName());
			session.setAttribute("email", signupEntity.getEmail());
			session.setAttribute("salutation", signupEntity.getSalutation());
			return "success";
		} else {
			model.addAttribute("message", "Sorry username and password are not correct!");
			return "login";
		}
	}
}
