package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IBookDao;
import com.app.pojos.Books;
import com.app.pojos.Copies;

@RestController

@RequestMapping("/books")
public class BookController {
	@Autowired
	private IBookDao dao;

	public BookController() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside book conrtroller");
	}
	
	@GetMapping("/{subject}") 
	public ResponseEntity<?> findByNames(@PathVariable String subject)
	{
		System.out.println("inside bookcontroller findbyNames");
		List<Books> b=dao.findByName(subject);
		if(b.size()==0)
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
		}
		return new ResponseEntity<List<Books>>(b, HttpStatus.OK);
	}
	@GetMapping ("/list")
	public ResponseEntity<?>  listbooks()
	{
		System.out.println("in list users");
		List<Books> c=dao.getAllBooks();
		if(c.size()==0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
		return new ResponseEntity<List<Books>>(c, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addbooks(@RequestBody Books b)
	{
		System.out.println("inside addbooks");
		try {
			return new ResponseEntity<Books>(dao.addBooks(b),HttpStatus.CREATED) ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

}

