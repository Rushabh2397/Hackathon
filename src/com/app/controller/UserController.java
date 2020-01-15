package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IUserDao;
import com.app.pojos.Copies;
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
	
	@GetMapping
	public  ResponseEntity<?> validate(@RequestParam String email,@RequestParam String password)
	{
		System.out.println("inside validate method");
		Users d=dao.validateUser(email, password);
		if(d.getEmail().equals(email) && d.getPasswd().equals(password) )
		{
			return new ResponseEntity<Users>(d, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
	}
	
	
	@GetMapping("/listu") 
	public ResponseEntity<?>  listUser()
	{
		System.out.println("in list users");
		List<Users> s=dao.getAllUsers();
		if(s.size()==0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
		return new ResponseEntity<List<Users>>(s, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addUsers(@RequestBody Users u)
	{
		System.out.println("inside addUser");
		try {
			return new ResponseEntity<Users>(dao.addUserDetails(u),HttpStatus.CREATED) ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	

//	
//	@GetMapping
//	public ResponseEntity<?> listEmps() {
//		System.out.println("in list emps");
//		List<Employee> allEmps = service.getAllEmps();
//		if (allEmps.size() == 0)
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		return new ResponseEntity<List<Employee>>(allEmps, HttpStatus.OK);
//	}
}
