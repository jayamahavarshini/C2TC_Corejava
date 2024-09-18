package com.tnsif.pm.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class Studentservice {

	
	@Autowired
	private StudentRepository repo;
	
	public List<Student>listAll(){
		
		return repo.findAll();
	}
	public Student get(Long id) {
		
		return repo.findById(id).get();
	}
	public void save(Student student) {
		
		repo.save(student);
	}
	public void delete(Long id) {
		
		repo.deleteById(id);
		
	}
}
