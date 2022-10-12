package hrms.lecture63.api.controllers;

import java.util.List;

import hrms.lecture63.dataAcces.abstracts.JobSeekerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hrms.lecture63.business.abstracts.EmployerService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.Employer;

import javax.validation.Valid;

@RequestMapping("/api/employer")
@RestController
@CrossOrigin
public class EmployerController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployerController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return employerService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.add(employer));
		}

}
