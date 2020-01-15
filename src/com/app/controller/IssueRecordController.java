package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.IssueRecord;

@RestController
@RequestMapping("/issue")
public class IssueRecordController {
	
	@Autowired
	private IssueRecordDao dao;

	public IssueRecordController() {
		// TODO Auto-generated constructor stub
		System.out.println("inside IssuerecordController");
	}
	
	@GetMapping("/{u_id}")
	public ResponseEntity<?> searchByUid(@PathVariable int u_id)
	{
		System.out.println("inside search by uid");
		List<IssueRecord> i=dao.searchById(u_id);
		if(i.size()==0)
		{
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); 
		}
		return new ResponseEntity<List<IssueRecord>>(i, HttpStatus.OK);
	}
	
}
