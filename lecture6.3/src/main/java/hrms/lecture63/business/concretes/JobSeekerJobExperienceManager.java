package hrms.lecture63.business.concretes;

import hrms.lecture63.business.abstracts.JobSeekerJobExperienceService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.dataAcces.abstracts.JobSeekerJobExperienceDao;
import hrms.lecture63.entities.concretes.JobSeekerJobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class JobSeekerJobExperienceManager implements JobSeekerJobExperienceService {

    @Autowired
    private JobSeekerJobExperienceDao jobSeekerJobExperienceDao;

    @Override
    public ResponseEntity add(@RequestBody @Valid JobSeekerJobExperience jobSeekerJobExperience) {
        return ResponseEntity.ok(this.jobSeekerJobExperienceDao.save(jobSeekerJobExperience));
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.jobSeekerJobExperienceDao.findAll(),"İş arayanın iş tecrübeleri listelendi.");
    }
}
