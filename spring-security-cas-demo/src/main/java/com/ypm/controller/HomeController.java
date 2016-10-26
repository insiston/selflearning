package com.ypm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ypm.config.DataInit;

@Controller
public class HomeController {

	@Autowired
	DataInit dataInit;
	 @RequestMapping(value = {"", "/home"}, method=RequestMethod.GET)
	    public String home(){
		 dataInit.dataInit();
	        return "home";
	    }
	    
	    @RequestMapping(value = "/helloadmin", method=RequestMethod.GET)
//	    @PreAuthorize("hasRole('admin')")
       @PreAuthorize("hasAuthority('admin')")
	    public String helloAdmin(){
	        return "helloAdmin";
	    }
	    
	    @RequestMapping(value = "/hellouser", method=RequestMethod.GET)
//	    @PreAuthorize("hasAnyRole('admin', 'user')")
	    @PreAuthorize("hasAnyAuthority('admin', 'user')")
	    public String helloUser(){
	        return "helloUser";
	    }
	    
	    @RequestMapping(value = "/login", method=RequestMethod.GET)
	    public String login(){
	        return "login";
	    }
	    @RequestMapping("/403")
	    public String forbidden(){
	        return "403";
	    }
}
