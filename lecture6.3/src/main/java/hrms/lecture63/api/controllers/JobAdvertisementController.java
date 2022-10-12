package hrms.lecture63.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hrms.lecture63.business.abstracts.JobAdvertisementService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.JobAdvertisement;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobAdvertisement")
@CrossOrigin
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllSortedByDateAsc")
	public DataResult<List<JobAdvertisement>> getAllSortedByDate(){
		return this.jobAdvertisementService.getAllSortedByDate();
	}
	
	@GetMapping("/getAllByEmployerId")
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(@RequestParam int employerId){
		return this.jobAdvertisementService.getAllByEmployerId(employerId);
	}
	
	@PutMapping("/getTurnDeactive")
	public Result turnDeactive(@RequestParam int id) {
		return this.jobAdvertisementService.turnDeactive(id);
	}

}
