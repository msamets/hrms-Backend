package hrms.lecture63.api.controllers;

import hrms.lecture63.business.abstracts.JobSeekerJobExperienceService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.entities.concretes.JobSeekerJobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/jobSeekerJobExperience")
@RestController
public class JobSeekerJobExperienceController {

    @Autowired
    private JobSeekerJobExperienceService jobSeekerJobExperienceService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody JobSeekerJobExperience jobSeekerJobExperience){
        return ResponseEntity.ok(this.jobSeekerJobExperienceService.add(jobSeekerJobExperience));
    }

    @GetMapping("/getAll")
    public DataResult getAll(){
        return this.jobSeekerJobExperienceService.getAll();
    }
}
