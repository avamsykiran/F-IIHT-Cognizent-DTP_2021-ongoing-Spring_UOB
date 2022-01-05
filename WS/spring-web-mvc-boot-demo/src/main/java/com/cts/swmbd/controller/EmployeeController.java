package com.cts.swmbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmbd.entity.Employee;
import com.cts.swmbd.repo.EmployeeRepo;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepo empRepo;
	
	//@RequestMapping(value="/empList",method=RequestMethod.GET)
	@GetMapping("/empList")
	public ModelAndView empListAction() {
		return new ModelAndView("emp-list-page", "emps", empRepo.findAll());
	}
	
	@GetMapping("/details")
	public ModelAndView empDetailsAction(@RequestParam("eid") Long empId) {
		return new ModelAndView("emp-details-page","emp",empRepo.findById(empId).orElse(null));
	}
	
	@GetMapping("/addEmp")
	public String addEmpAction() {
		return "emp-form-page";
	}
	
	@PostMapping("/addEmp")
	public ModelAndView doAddEmpAction(@ModelAttribute Employee emp) {
		empRepo.save(emp);
		return new ModelAndView("emp-list-page", "emps", empRepo.findAll());
	}
}
