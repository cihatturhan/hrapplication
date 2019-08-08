package com.simpleapplication.hrjoblisting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.simpleapplication.hrjoblisting.Business.IJobApplicationService;
import com.simpleapplication.hrjoblisting.Business.IJobListService;
import com.simpleapplication.hrjoblisting.Entities.JobApplication;
import com.simpleapplication.hrjoblisting.Exception.JobApplicationException;


@Controller
public class JobApplicationController {
	
	@Autowired
	private IJobApplicationService jobApplicationService;
	@Autowired
	private IJobListService joblistService;


	
	/// adds new application and redirects applicant to joblist page
	@PostMapping("/addapplication")
	public String add(@ModelAttribute JobApplication jobApplication,BindingResult binding, Model model) {
		

					try {

						jobApplicationService.add(jobApplication);						
						model.addAttribute("joblisttitle",joblistService.getById(jobApplication.getJoblist().getId()).getJobTitle());
						return "successfullapplication";
						
					} catch (JobApplicationException e) {
						
						model.addAttribute("joblist",jobApplication.getJoblist());
						model.addAttribute("exceptionmessage", e.getMessage());
						return "customerror";
					}
			


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
	public String getByJoblistID(@PathVariable int joblistid,Model model) {
		List<JobApplication> applications=jobApplicationService.getByJoblistId(joblistid);
			model.addAttribute("applicationsbyJobID", applications);
					return "applicationlistbyjoblist";
	}
	
	

	

	

	



	
	

}
