package hrms.lecture63.api.controllers;

import hrms.lecture63.business.abstracts.JobSeekerLanguageService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobSeekerLanguage")
public class JobSeekerLanguageController {

    @Autowired
    private JobSeekerLanguageService jobSeekerLanguageService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody @Valid JobSeekerLanguage jobSeekerLanguage){
        return ResponseEntity.ok(this.jobSeekerLanguageService.add(jobSeekerLanguage));
    }

    @GetMapping("/getAll")
    public DataResult getAll(){
        return this.jobSeekerLanguageService.getAll();
    }

}
