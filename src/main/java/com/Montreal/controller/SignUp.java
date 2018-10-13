package com.Montreal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("/SignUp")
@RequestMapping("/SignUp")
public class SignUp {
	
	private static final Log LOG = LogFactory.getLog(SignUp.class);
	
	@RequestMapping("/")
	public ModelAndView register(@RequestParam(value = "profile", required = false) String profile ) {
		LOG.info("Call: register() -- from " + this.getClass());
		
		ModelAndView mav = new ModelAndView("signUp");
		mav.addObject("profile", profile);
		return mav;
	}
	
	@RequestMapping("/Family")
	public ModelAndView familyRegistration(@RequestParam(value = "profile", required = false) String profile ) {
		LOG.info("Call: register() -- from " + this.getClass());
		
		ModelAndView mav = new ModelAndView("signUp");
		mav.addObject("profile", profile);
		return mav;
	}
	@RequestMapping("/CEL")
	public ModelAndView CELRegistration(@RequestParam(value = "profile", required = false) String profile ) {
		LOG.info("Call: register() -- from " + this.getClass());
		
		ModelAndView mav = new ModelAndView("signUp");
		mav.addObject("profile", profile);
		return mav;
	}
	@RequestMapping("/Student")
	public ModelAndView StudentRegistration(@RequestParam(value = "profile", required = false) String profile ) {
		LOG.info("Call: register() -- from " + this.getClass());
		
		ModelAndView mav = new ModelAndView("signUp");
		mav.addObject("profile", profile);
		return mav;
	}
	
	
}
