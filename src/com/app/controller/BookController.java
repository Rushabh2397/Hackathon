package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.IBookDao;
import com.app.pojos.Books;

@RestController

@RequestMapping("/books")
public class BookController {
	@Autowired
	private IBookDao dao;

	public BookController() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside book conrtroller");
	}
	
	@GetMapping("{/name}") 
	public ResponseEntity<?> findByNames(@RequestParam String name)
	{
		System.out.println("inside bookcontroller findbyNames");
		List<Books> b=dao.findByName(name);
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

}

