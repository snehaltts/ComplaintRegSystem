package com.ltts.Project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
//	@RequestMapping("/hi")
//	public String firstMethod() {
//		return "hello Spring";
//	}

//	@RequestMapping("/")
//	public ModelAndView first() {
//		return new ModelAndView("index");
//	}
	
	@RequestMapping("/hello")
	public ModelAndView second() {
		return new ModelAndView("registration");
	}
}
