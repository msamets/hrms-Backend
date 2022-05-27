package hrms.lecture63.api.controllers;

import hrms.lecture63.business.abstracts.JobSeekerSchoolService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.entities.concretes.JobSeekerSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobSeekerSchool")
public class JobSeekerSchoolController {

    @Autowired
    private JobSeekerSchoolService jobSeekerSchoolService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody @Valid JobSeekerSchool jobSeekerSchool){
        return ResponseEntity.ok(this.jobSeekerSchoolService.add(jobSeekerSchool));
    }

    @GetMapping("/getAll")
    public DataResult getAll(){
        return this.jobSeekerSchoolService.getAll();
    }
}
