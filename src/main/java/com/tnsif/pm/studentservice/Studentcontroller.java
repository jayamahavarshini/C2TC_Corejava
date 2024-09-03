package com.tnsif.pm.studentservice;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Studentcontroller {

	@Autowired
	private Studentservice service;
	@GetMapping("/Student")
	public List<Student>list(){
		return service.listAll();
	}
	// Retrieve Id
	@GetMapping("/Student/{id}")
	public ResponseEntity<Student> get(@PathVariable Long id)
	
	{
		try {
			Student student =service.get(id);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
			
		}
		catch(Exception e) {
			
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	// Create
	@PostMapping("/Student")
	public void add(@RequestBody Student student)
	{
	
		service.save(student);
	}
	// Update Operation
	@PutMapping("/Student/{id}")
	public ResponseEntity<?> update(@RequestBody Student student ,@PathVariable long id)
	{
		try {
			Student existstudent = service.get(id);
			service.save(student);
			return new ResponseEntity<Student>(student,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	//Delete operation
	@DeleteMapping("/Student/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
}
