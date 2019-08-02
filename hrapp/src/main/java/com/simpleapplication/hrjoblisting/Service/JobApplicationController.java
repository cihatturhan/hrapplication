package com.simpleapplication.hrjoblisting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.simpleapplication.hrjoblisting.Business.IJobApplicationService;

import com.simpleapplication.hrjoblisting.Entities.JobApplication;


@Controller
public class JobApplicationController {
	
	@Autowired
	private IJobApplicationService jobApplicationService;


	
	/// adds new application and redirects applicant to joblist page
	@PostMapping("/addapplication")
	public String add(@ModelAttribute JobApplication jobApplication) {
		jobApplicationService.add(jobApplication);
			
	return "redirect:joblist";
	}
	// shows aplicant's detailed information
	@GetMapping("/application/{id}")
	public String getByID(@PathVariable int id,Model model) {
		JobApplication application=jobApplicationService.getById(id);
			model.addAttribute("applications", application);
					return "application";
	}
	/// lists applications for selected joblist
	@GetMapping("/applicationlist/{joblistid}")
	public String getByJoblistID(@PathVariable String joblistid,Model model) {
		List<JobApplication> applications=jobApplicationService.getByJoblistId(joblistid);
			model.addAttribute("applicationsbyJobID", applications);
					return "applicationlistbyjoblist";
	}
	
	

	

	

	



	
	

}
