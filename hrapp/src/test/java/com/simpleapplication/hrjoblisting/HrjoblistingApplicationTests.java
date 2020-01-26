package com.simpleapplication.hrjoblisting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.simpleapplication.hrjoblisting.Business.JobListManager;

import com.simpleapplication.hrjoblisting.Entities.Joblist;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrjoblistingApplicationTests {
	@Autowired
	private JobListManager joblistService;
	

	@Test
	public void updateTest()  {
		
		Joblist joblist = new Joblist();
		joblist.setId(1);
		joblist.setJobTitle("Software Team Lead");
		joblist.setJobDescription("Leads the software Team which develop great products");
		joblist.setNumberOfPeopleToHire(2);
		String sDate= "09/09/2019";
		Date joblistDate = new Date();
		
	
		try {	
			joblistDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
		}catch (Exception e) {
			System.out.println("--------Exception catched   "+e);
		}
		joblist.setLastApplicationDate(joblistDate);

	
	
	
		joblist.setNumberOfPeopleToHire(3);
		joblistService.update(joblist);


		assertEquals(joblist.getNumberOfPeopleToHire(),joblistService.getById(1).getNumberOfPeopleToHire());
		
		
	
		
		
	}

}
