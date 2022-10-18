package hrms.lecture63.api.controllers;

import hrms.lecture63.business.abstracts.JobExperienceService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobExperience")
@CrossOrigin
public class JobExperienceController {

    @Autowired
    private JobExperienceService jobExperienceService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody JobExperience jobExperience){
        return ResponseEntity.ok(this.jobExperienceService.add(jobExperience));
    }

    @GetMapping("/getAll")
    public DataResult getAll(){
        return new SuccessDataResult(this.jobExperienceService.getAll());
    }
}
