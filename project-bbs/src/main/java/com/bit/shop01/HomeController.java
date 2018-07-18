package com.bit.shop01;

import java.sql.SQLException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomeController {
	Logger log = Logger.getLogger(this.getClass());

	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "home";
		
	}


	
//	
//	@RequestMapping(value = "/outer/", method = RequestMethod.GET)
//	public String outer(Model model) {
//		
//		return "outDetail";
//	
//	}
//
//	@RequestMapping(value = "/top/", method = RequestMethod.GET)
//	public String top(Locale locale, Model model) {
//		
//		return "topDetail";
//	
//	}
//
//	@RequestMapping(value = "/bottom/", method = RequestMethod.GET)
//	public String bottom(Locale locale, Model model) {
//		
//		return "botDetail";
//	
//	}
//
//	@RequestMapping(value = "/dress/", method = RequestMethod.GET)
//	public String dress(Locale locale, Model model) {
//		
//		return "dreDetail";
//	
//	}
//
//	@RequestMapping(value = "/shoeacc/", method = RequestMethod.GET)
//	public String shoeacc(Locale locale, Model model) {
//		
//		return "sho&accDetail";
//	
//	}	
//
//	@RequestMapping(value = "/sale/", method = RequestMethod.GET)
//	public String sale(Locale locale, Model model) {
//		
//		return "saleDetail";
//	
//	
//	}
//	

	
	
	}
	

