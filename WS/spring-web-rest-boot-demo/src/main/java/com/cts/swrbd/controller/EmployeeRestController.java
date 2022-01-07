package com.cts.swrbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.swrbd.entity.Employee;
import com.cts.swrbd.repo.EmployeeRepo;

@RestController
@RequestMapping("/emps")
public class EmployeeRestController {

	@Autowired
	private EmployeeRepo empRepo;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(empRepo.findAll(), HttpStatus.OK);
	}
}
