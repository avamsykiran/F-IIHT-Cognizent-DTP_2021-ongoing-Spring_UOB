package com.cts.swmbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
