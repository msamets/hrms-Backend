package hrms.lecture63.business.concretes;

import hrms.lecture63.business.abstracts.JobExperienceService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.core.utilities.results.SuccessResult;
import hrms.lecture63.dataAcces.abstracts.JobExperienceDao;
import hrms.lecture63.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobExperienceManager implements JobExperienceService {

    @Autowired
    private JobExperienceDao jobExperienceDao;

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("İş geçmişi eklendi");
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.jobExperienceDao.findAll(), "İş geçmişleri listelendi.");
    }
}
