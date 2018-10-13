package com.Montreal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class MontrealApplication {
	
	/** LOG constante. */
	private static final Log LOG = LogFactory.getLog(MontrealApplication.class);
	
	public static void main(String[] args) {
		LOG.info("Call: main()" );
		System.out.println("Main ....................");
		SpringApplication.run(MontrealApplication.class, args);
	}	
}
