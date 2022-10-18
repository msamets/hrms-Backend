package hrms.lecture63.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hrms.lecture63.business.abstracts.JobSeekerService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.JobSeeker;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/jobSeeker")
@CrossOrigin
public class JobSeekerController {
	
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(@Valid @RequestBody JobSeeker jobSeeker) throws Exception {
		return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker));
	}

}
