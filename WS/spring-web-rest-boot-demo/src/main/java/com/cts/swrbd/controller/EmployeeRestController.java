package com.cts.swrbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.swrbd.entity.Employee;
import com.cts.swrbd.repo.EmployeeRepo;

@RestController
@RequestMapping("/emps")
public class EmployeeRestController {

	@Autowired
	private EmployeeRepo empRepo;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(empRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/{empId}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Employee> getById(@PathVariable("empId")Long empId){
		ResponseEntity<Employee> result=null;
		
		if(empRepo.existsById(empId))
			result = new ResponseEntity<Employee>(empRepo.findById(empId).get(), HttpStatus.OK);
		else
			result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return result;
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteById(@PathVariable("empId")Long empId){
		ResponseEntity<Void> result=null;
		
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			result = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else
			result = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return result;
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		emp = empRepo.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		emp = empRepo.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
	}
}
