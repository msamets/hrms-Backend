package hrms.lecture63.api.controllers;

import hrms.lecture63.business.abstracts.CvService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.Cv;
import hrms.lecture63.entities.concretes.JobSeekerJobExperience;
import hrms.lecture63.entities.concretes.JobSeekerSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/cv")
@RestController
public class CvController {

    @Autowired
    private CvService cvService;

    @GetMapping("/getAll")
    private DataResult<List<Cv>> getAll(){
        return this.cvService.getAll();
    }

    @PostMapping("/add")
    private ResponseEntity<Object> add(@Valid @RequestBody Cv cv){
        return ResponseEntity.ok(this.cvService.add(cv));
    }

    @PutMapping("/addToSchoolToCv")
    private ResponseEntity<Object> addSchoolToCv(@Valid @RequestParam int cvId,@Valid @RequestParam int jobSeekerSchoolId){
        return ResponseEntity.ok(this.cvService.addSchoolToCv(cvId,jobSeekerSchoolId));
    }

    @PutMapping("/addLanguageToCv")
    private ResponseEntity<Object> addLanguageToCv(@Valid @RequestParam int cvId,@Valid @RequestParam int jobSeekerLanguageId){
        return ResponseEntity.ok(this.cvService.addLanguageToCv(cvId, jobSeekerLanguageId));
    }

    @PutMapping("/addJobExperienceToCv")
    private ResponseEntity<Object> addJobExperienceToCv(@Valid @RequestParam int cvId,@Valid @RequestParam int jobSeekerJobExperienceId){
        return ResponseEntity.ok(this.cvService.addJobExperienceToCv(cvId, jobSeekerJobExperienceId));
    }

    @PutMapping("/addGithubProfileToCv")
    private ResponseEntity<Object> addGithubProfileToCv(@Valid @RequestParam int cvId,@Valid @RequestParam String githubProfile){
        return ResponseEntity.ok(this.cvService.addGithubProfileToCv(cvId, githubProfile));
    }

    @PutMapping("/addLinkedinProfileToCv")
    private ResponseEntity<Object> addLinkedinProfileToCv(@Valid @RequestParam int cvId,@Valid @RequestParam String linkedinProfile){
        return ResponseEntity.ok(this.cvService.addLinkedinProfileToCv(cvId, linkedinProfile));
    }

    @PutMapping("/addCoverLetterToCv")
    private ResponseEntity<Object> addCoverLetterToCv(@Valid @RequestParam int cvId,@Valid @RequestParam String coverLetter){
        return ResponseEntity.ok(this.cvService.addCoverLetterToCv(cvId, coverLetter));
    }

    @PutMapping("/addSkillToCv")
    private ResponseEntity<Object> addSkillToCv(@Valid @RequestParam int cvId,@Valid @RequestParam String skill){
        return ResponseEntity.ok(this.cvService.addSkillToCv(cvId, skill));
    }

    @GetMapping("/findJobSeekerJobExperienceOrderByQuitJobDateDesc")
    private DataResult<List<JobSeekerJobExperience>> findJobSeekerJobExperienceOrderByQuitJobDateDesc(int cvId){

        return this.cvService.findJobSeekerJobExperienceOrderByQuitJobDateDesc(cvId);
    }

    @GetMapping("/findJobSeekerSchoolOrderByGraduationDateDesc")
    private DataResult<List<JobSeekerSchool>> findJobSeekerSchoolOrderByGraduationDateDesc(int cvId){
        return this.cvService.findJobSeekerSchoolOrderByGraduationDateDesc(cvId);
    }
}
