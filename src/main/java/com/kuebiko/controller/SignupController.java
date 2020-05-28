package com.kuebiko.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kuebiko.entity.SignupEntity;
import com.kuebiko.query.SQLQuery;
import com.kuebiko.utils.SQLConnectionUtils;

@Controller
public class SignupController {
	
	  @PostMapping("/usignup")
		public String usignup(@ModelAttribute SignupEntity signupEntity) {
			try {
				Connection connection = SQLConnectionUtils.getConn();
				//Compiling query and assigning into PreparedStatement object
				PreparedStatement pstmt=connection.prepareStatement(SQLQuery.UPDATE_SIGNUP_BY_SID);
				//setting the values inside PreparedStatement object
				pstmt.setString(1,signupEntity.getUsername());
				pstmt.setString(2,signupEntity.getPassword());
				pstmt.setString(3,signupEntity.getEmail());
				pstmt.setString(4,signupEntity.getName());
				pstmt.setString(5,signupEntity.getSalutation());
				pstmt.setInt(6,signupEntity.getSid());
				//Fire the query
				pstmt.executeUpdate();
				
			}catch (Exception e) {
					e.printStackTrace();
			}
			return "redirect:/users";
	 }
	
	@GetMapping("/editSignup")
	public String editSignup(@RequestParam int  sid,Model model) {
	try {
			Connection connection = SQLConnectionUtils.getConn();
			//Compiling query and assigning into PreparedStatement object
			PreparedStatement pstmt=connection.prepareStatement(SQLQuery.SELECT_SIGNUPS_SID);
			//setting the values inside PreparedStatement object
			//Fire the query
			//public static String SELECT_SIGNUPS="select sid,username,password,email,name,salutation,datecreated from signup_tbl";
			pstmt.setInt(1, sid);
			ResultSet rs= pstmt.executeQuery();
			SignupEntity entity=new SignupEntity();
			if(rs.next()) {
				entity.setSid(rs.getInt(1));
				entity.setUsername(rs.getString(2));
				entity.setPassword(rs.getString(3));
				entity.setEmail(rs.getString(4));
				entity.setName(rs.getString(5));
				entity.setSalutation(rs.getString(6));
				entity.setDatecreated(rs.getTimestamp(7));
			}	
			//Adding signupList into request scope
			model.addAttribute("entity", entity);
		}catch (Exception e) {
				e.printStackTrace();
		}
		return "editSignup";
 } 
 
	
	   @GetMapping("/deleteSignup")
		public String deleteUser(@RequestParam int  sid,Model model) {
			try {
				Connection connection = SQLConnectionUtils.getConn();
				//Compiling query and assigning into PreparedStatement object
				PreparedStatement pstmt=connection.prepareStatement(SQLQuery.DELETE_SIGNUP);
				//setting the values inside PreparedStatement object
				pstmt.setInt(1,sid);
				pstmt.executeUpdate();
			}catch (Exception e) {
					e.printStackTrace();
			}
			//Forwarding request to the servlet!!!!
			return "redirect:/users";
	 } 
	 
	
	@GetMapping("/users")
	public String showUser(Model model) {
		
		try {
			Connection connection = SQLConnectionUtils.getConn();
			//Compiling query and assigning into PreparedStatement object
			PreparedStatement pstmt=connection.prepareStatement(SQLQuery.SELECT_SIGNUPS);
			//setting the values inside PreparedStatement object
			//Fire the query
			//public static String SELECT_SIGNUPS="select sid,username,password,email,name,salutation,datecreated from signup_tbl";
			ResultSet rs= pstmt.executeQuery();
			List<SignupEntity> signupList=new  ArrayList<>();
			while(rs.next()) {
				SignupEntity entity=new SignupEntity();
				entity.setSid(rs.getInt(1));
				entity.setUsername(rs.getString(2));
				entity.setPassword(rs.getString(3));
				entity.setEmail(rs.getString(4));
				entity.setName(rs.getString(5));
				entity.setSalutation(rs.getString(6));
				entity.setDatecreated(rs.getTimestamp(7));
				signupList.add(entity);
			}	
			//Adding signupList into request scope
			model.addAttribute("signupList", signupList);
		}catch (Exception e) {
				e.printStackTrace();
		}
		return "signups";		
	}

}
