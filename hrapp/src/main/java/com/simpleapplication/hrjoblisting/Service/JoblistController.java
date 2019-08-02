package com.simpleapplication.hrjoblisting.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.simpleapplication.hrjoblisting.Business.IJobListService;
import com.simpleapplication.hrjoblisting.Entities.Joblist;

@Controller

public class JoblistController {
	
	private IJobListService joblistService;

	@Autowired
	public JoblistController(IJobListService joblistService) {
		super();
		this.joblistService = joblistService;
	}
	/// gets joblists from DB and lists them to apply
	@GetMapping("/joblist")
	public String joblist (Model model){
		List<Joblist> joblists=joblistService.getAll();
		model.addAttribute("joblists", joblists);
		return "joblist";
	
	}
	
	/// get joblists from DB and lists them with detailed inforation
	@GetMapping("/listing")
	public String lisitng (Model model){
		List<Joblist> joblists=joblistService.getAll();
		model.addAttribute("joblists", joblists);
		return "listing";
	
	}
	
	//// gets joblists from DB and list them to see applicants
	@GetMapping("/applicationlist")
	public String applicationlist (Model model){
		List<Joblist> joblists=joblistService.getAll();
		model.addAttribute("joblists", joblists);
		return "applicationlist";
	
	}

	// add new joblists
	@PostMapping("/add")
	public String add(@ModelAttribute Joblist joblist) {
		
		
		joblistService.add(joblist);
		return "redirect:joblist";
	}
	
	/// update joblist
	@PostMapping("/update")
	public String update(@ModelAttribute Joblist joblist) {
	joblistService.update(joblist);
	return "redirect:listing";
	}
	 // delete joblist
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
	joblistService.delete(id);
		return "redirect:/listing";
	}
	
	//// shows joblist editing page
	@GetMapping("/listing/{id}")
	public String edit(@PathVariable int id,Model model){
		Joblist joblist=joblistService.getById(id);
		model.addAttribute("joblist",joblist );
		return "editjoblist";
		
	}
	
	// shows joblist apply page
	@GetMapping("/joblist/{id}")
	public String Apply(@PathVariable int id,Model model) {
		Joblist joblist=joblistService.getById(id);
		model.addAttribute("joblist",joblist);
        return "jobapplication";
	}



	

}
