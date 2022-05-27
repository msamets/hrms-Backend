package hrms.lecture63.business.concretes;

import hrms.lecture63.business.abstracts.JobSeekerLanguageService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.dataAcces.abstracts.JobSeekerLanguageDao;
import hrms.lecture63.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    @Autowired
    private JobSeekerLanguageDao jobSeekerLanguageDao;

    @Override
    public ResponseEntity add(@RequestBody @Valid JobSeekerLanguage jobSeekerLanguage) {
        return ResponseEntity.ok(this.jobSeekerLanguageDao.save(jobSeekerLanguage));
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.jobSeekerLanguageDao.findAll(),"İş arayanın dil bilgileri listelendi.");
    }
}
