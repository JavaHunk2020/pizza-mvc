package com.kuebiko.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuebiko.controller.dto.ApplicationResponse;
import com.kuebiko.controller.dto.SignupDTO;
import com.kuebiko.service.SignupService;

@RestController
@RequestMapping("/v3")
public class JSONController {
	 
	@Autowired
	 private SignupService signupService;
	
	
	  //GET,DELETE,POST,PUT
	  @PutMapping("/users")
		public ApplicationResponse usignup(@RequestBody SignupDTO signupDTO) {
		   signupService.updateSignup(signupDTO);
		   ApplicationResponse applicationResponse=new ApplicationResponse();
		   applicationResponse.setCode(122);
		   applicationResponse.setStatus("success");
		   applicationResponse.setMessage("data is updated");
		   return applicationResponse;
	 }
	
	//{}
	@PostMapping("/users")
	public ApplicationResponse createUser(@RequestBody SignupDTO signupDTO) {
		 //MultipartFile into byte[]
		 signupDTO.setRole("customer");
		 signupDTO.setDatecreated(new Timestamp(new Date().getTime()));
		 signupService.persist(signupDTO);
		 ApplicationResponse applicationResponse=new ApplicationResponse();
		   applicationResponse.setCode(122);
		   applicationResponse.setStatus("success");
		   applicationResponse.setMessage("data is created");
		   return applicationResponse;
	}
	
	//Accept -application/json
	//Accept -application/xml
	@GetMapping("/users")
	public List<SignupDTO> showUser() {
		List<SignupDTO> signupList=signupService.findAll();
		return signupList;		
	}
	
	//users/5
	@GetMapping("/users/{sid}")
	public SignupDTO showUser(@PathVariable int  sid) {
			//Adding signupList into request scope
		    SignupDTO signupDTO=signupService.findById(sid);
			return signupDTO;
    } 
	
	   @DeleteMapping("/users/{sid}")
		public ApplicationResponse deleteUser(@PathVariable int  sid) {
		   signupService.deleteById(sid);
		   ApplicationResponse applicationResponse=new ApplicationResponse();
		   applicationResponse.setCode(122);
		   applicationResponse.setStatus("success");
		   applicationResponse.setMessage("data is deleted");
		   return applicationResponse;
		   //{"code":122,"status":"success","message":"data is deleted"}
	 } 

}
