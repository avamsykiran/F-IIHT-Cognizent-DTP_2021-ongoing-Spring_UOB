package com.cts.swmbd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	
//	@GetMapping("/addEmp")
//	public String addEmpAction() {
//		return "emp-form-page";
//	}

	@GetMapping("/addEmp")
	public ModelAndView editEmpAction() {
		return new ModelAndView("emp-form-page","emp",new Employee());
	}
	
	@GetMapping("/editEmp")
	public ModelAndView addEmpAction(@RequestParam("eid") Long empId) throws Exception {
		Employee emp = empRepo.findById(empId).orElse(null);
		
		if(emp==null)
			throw new Exception("No Such Employee Found");
		
		return new ModelAndView("emp-form-page","emp",emp);
	}
	
	@GetMapping("/deleteEmp")
	public ModelAndView delEmpAction(@RequestParam("eid") Long empId) {
		empRepo.deleteById(empId);
		
		return new ModelAndView("emp-list-page", "emps", empRepo.findAll());
	}
	
	@PostMapping({"/addEmp","/editEmp"})
	public ModelAndView saveEmpAction(
			@ModelAttribute("emp") @Valid Employee emp,BindingResult results) {
		
		ModelAndView mv=null;
		
		if(results.hasErrors()) {
			mv=new ModelAndView("emp-form-page","emp",emp);
		}else {
			empRepo.save(emp);
			mv=new ModelAndView("emp-list-page", "emps", empRepo.findAll());
		}
		
		
		return mv;
	}
}
