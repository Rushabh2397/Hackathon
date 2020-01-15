package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IUserDao;
import com.app.pojos.Users;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired 
	private IUserDao dao;
	
	public UserController() {
		// TODO Auto-generated constructor stu
		System.out.println("inside user Controler"+getClass().getName());
	}
	
	public ResponseEntity<?> processLoginForm(@RequestParam String email,@RequestParam String password)
	{
		Users u=dao.validateUser(email, password);
		if(u.getEmail().equals(email))
		{
			return new ResponseEntity<Users>(u,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		
	}
	
	
}
