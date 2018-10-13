package com.Montreal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Montreal.MontrealApplication;
import com.Montreal.entity.Usuario;

@Controller("/Index")
public class Index {
	
	private static final Log LOG = LogFactory.getLog(Index.class);
	
	@RequestMapping("/")
	public String resolver() {		
		LOG.info("Call: resolver() -- from " + this.getClass());		
		Usuario u = new Usuario();
		u.findById("1");
		return "/Login";
	}
	
}
