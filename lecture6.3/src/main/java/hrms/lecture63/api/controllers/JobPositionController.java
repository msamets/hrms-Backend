package hrms.lecture63.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hrms.lecture63.business.abstracts.JobPositionService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.entities.concretes.JobPosition;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/jobPosition")
//dış dünyadan biri istekte bulunursa
//bu kontrol cevap verecek demek
//RequestMapping=birden fazla istek olabileceği için bunu kullandık
@CrossOrigin
public class JobPositionController {

	
	private JobPositionService jobPositionService;
	
	@Autowired
	/*
	 * gidiyor projeyi tarıyor kim jobPositionService i implemente ettiyese
	 * buluyor spring arkaplanda JobPositionService p = new JobPositionManager();
	 * yapıyor buraya yerleştiriyor birden fazla soyut sınıf varsa Autowired patlar ama
	 * engin anlatacak burada solid zafiyeti var ama yapacka bir şey yok
	 * bu kullanım java  communitysinin belirlemiş oldugu genel kullanım
	 */
	public JobPositionController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(@Valid @RequestBody JobPosition jobPosition) {
		return ResponseEntity.ok(this.jobPositionService.add(jobPosition));
	}
	
	
}
