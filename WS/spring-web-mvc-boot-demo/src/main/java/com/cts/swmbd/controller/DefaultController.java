package com.cts.swmbd.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

//	@RequestMapping(value = {"","/","/home"},method = RequestMethod.GET)
//	public String homeAction() {
//		return "home-page";
//	}

	@RequestMapping(value = { "", "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView homeAction() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("home-page");
		mv.addObject("credits", new String[] { "Vamsy", "Suseela", "Indhikaa", "Srinu" });

		return mv;
	}
	
	@RequestMapping("/header")
	public ModelAndView headerAction() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("header-segment");

		mv.addObject("webTitle", "First Spring MVC App");
		mv.addObject("currentTime", LocalDateTime.now());

		return mv;		
	}
}
