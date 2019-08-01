package com.simpleapplication.hrjoblisting.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import com.simpleapplication.hrjoblisting.Business.IApplicationService;

import com.simpleapplication.hrjoblisting.Entities.Application;


@Controller
public class ApplicationController {
	
	@Autowired
	private IApplicationService applicatntService;


	
	
	@PostMapping("/addapplication")
	public String update(@ModelAttribute Application application) {
		applicatntService.add(application);
			
	return "redirect:joblist";
	}
	
	

	

	

	



	
	

}
