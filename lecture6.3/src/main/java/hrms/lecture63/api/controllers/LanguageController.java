package hrms.lecture63.api.controllers;

import hrms.lecture63.business.abstracts.LanguageService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping("/add")
    public ResponseEntity<Object> add(@Valid @RequestBody Language language){
        return ResponseEntity.ok(this.languageService.add(language));
    }

    @GetMapping("/getAll")
    public DataResult getAll(){
        return new SuccessDataResult(this.languageService.getAll(), "Diller listelendi.");
    }
}
