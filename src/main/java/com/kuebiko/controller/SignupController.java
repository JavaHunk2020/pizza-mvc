package com.kuebiko.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 
	 //<img src="image?sid =1"
	 @GetMapping("/image")
		public void showImage(@RequestParam  int sid,HttpServletResponse httpServletResponse) throws IOException {
		 byte[]  photo=signupService.findImageById(sid);
		 ServletOutputStream outputStream =httpServletResponse.getOutputStream();
		 if(photo!=null) {
			 httpServletResponse.setContentType("image/png");
			 outputStream.write(photo);
		 }else {
			 outputStream.write(new byte[] {});
		 }
		 outputStream.flush();
	   }
	 
	 @PostMapping("/signup")
		public String signupPost(@ModelAttribute SignupDTO signupDTO) throws IOException {
		 //MultipartFile into byte[]
		 byte[] bphoto=signupDTO.getPhoto().getBytes();
		 signupDTO.setBphoto(bphoto);
		 signupDTO.setRole("customer");
		 signupDTO.setDatecreated(new Timestamp(new Date().getTime()));
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
	
	
	@GetMapping("/psignup")
	public String showPaginatedData(@RequestParam(required=false,defaultValue="1") String  pageid,Model model) {
		int pageSize=2;
		int ppageid=Integer.parseInt(pageid);
		if(ppageid<=0) {
			ppageid=1;
		}
		//2
		//6
		if(ppageid>1) {
			ppageid=(ppageid-1)*pageSize+1;  
		}
		List<SignupDTO> signupList=signupService.getSignups(ppageid, pageSize);
		int totalRecords=signupService.findTotalSignup();
		model.addAttribute("signupList", signupList);
		model.addAttribute("recordStarts", ppageid);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageid", pageid);
		model.addAttribute("totalRecords", totalRecords);
		return "psignups";		
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
