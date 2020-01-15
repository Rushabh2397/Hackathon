package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.daos.CopiesDao;
import com.app.pojos.Copies;

@RestController
@RequestMapping("/copies")
public class CopiesController {
	
	@Autowired
	private CopiesDao dao;
	
	public CopiesController() {
		System.out.println("Inside Copies Constructor");
	}
	
	@PostMapping
	public ResponseEntity<?> addCopies(@RequestBody Copies c)
	{
		System.out.println("inside addcopies");
		try {
			return new ResponseEntity<Copies>(dao.addcopies(c),HttpStatus.CREATED) ;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@GetMapping("/{book_id}")
	public ResponseEntity<?> searchById(@PathVariable int book_id )
	{
		System.out.println("inside search");
		List<Copies> d=dao.bookAvailability(book_id);
		if(d.size()==0)
		{
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
		}
		return new ResponseEntity<List<Copies>>(d, HttpStatus.OK);
		
	}
	

}


