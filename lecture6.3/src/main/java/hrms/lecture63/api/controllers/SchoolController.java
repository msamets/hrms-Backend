package hrms.lecture63.api.controllers;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.dataAcces.abstracts.SchoolDao;
import hrms.lecture63.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/school")
@CrossOrigin
public class SchoolController {

    @Autowired
    private SchoolDao schoolDao;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody School school){
        return ResponseEntity.ok(this.schoolDao.save(school));
    }

    @GetMapping("/getAll")
    public DataResult getAll(){
        return new SuccessDataResult(this.schoolDao.findAll(),"Okullar listelendi");
    }
}
