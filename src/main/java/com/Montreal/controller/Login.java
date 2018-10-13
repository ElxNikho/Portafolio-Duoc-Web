package com.Montreal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/Login")
@RequestMapping("/Login")
public class Login {
	
	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("test", "test data");
		return mav;
	}
	@RequestMapping("/Student")
	public ModelAndView loginStudent() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("test", "test data");
		return mav;
	}
	@RequestMapping("/CEL")
	public ModelAndView loginCEL() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("test", "test data");
		return mav;
	}
	@RequestMapping("/Family")
	public ModelAndView loginFamily() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("test", "test data");
		return mav;
	}
}
