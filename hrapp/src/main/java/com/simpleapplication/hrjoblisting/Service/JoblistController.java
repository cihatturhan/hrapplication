package com.simpleapplication.hrjoblisting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simpleapplication.hrjoblisting.Business.IJobListService;
import com.simpleapplication.hrjoblisting.Entities.Joblist;

@RestController

public class JoblistController {
	
	private IJobListService joblistService;

	@Autowired
	public JoblistController(IJobListService joblistService) {
		super();
		this.joblistService = joblistService;
	}
	@GetMapping("/joblist")
	public String joblist (Model model){
		List<Joblist> joblists=joblistService.getAll();
		model.addAttribute("resources", joblists);
		return "joblist";
	
	}
	@GetMapping("/joblists")
	public List<Joblist> getTehm(){
		
		
		return joblistService.getAll();
	}
	@PostMapping("/add")
	public void add(@RequestBody Joblist joblist) {
		System.out.println("added"+joblist.getJobDescription());
		joblistService.add(joblist);
	}
	
	
	

}
