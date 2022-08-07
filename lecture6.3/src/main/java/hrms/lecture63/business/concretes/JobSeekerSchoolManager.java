package hrms.lecture63.business.concretes;

import hrms.lecture63.business.abstracts.JobSeekerSchoolService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.dataAcces.abstracts.JobSeekerSchoolDao;
import hrms.lecture63.entities.concretes.JobSeekerSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class JobSeekerSchoolManager  implements JobSeekerSchoolService {

    @Autowired
    private JobSeekerSchoolDao jobSeekerSchoolDao;


    @Override
    public ResponseEntity add(@RequestBody @Valid JobSeekerSchool jobSeekerSchool) {
        return ResponseEntity.ok(this.jobSeekerSchoolDao.save(jobSeekerSchool));
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.jobSeekerSchoolDao.findAll(),"İş arayanın okul bilgileri getirildi.");
    }
}
