package hrms.lecture63.business.concretes;

import hrms.lecture63.business.abstracts.JobExperienceService;
import hrms.lecture63.core.utilities.results.*;
import hrms.lecture63.dataAcces.abstracts.JobExperienceDao;
import hrms.lecture63.dataAcces.abstracts.JobPositionDao;
import hrms.lecture63.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobExperienceManager implements JobExperienceService {

    @Autowired
    private JobExperienceDao jobExperienceDao;
    @Autowired
    private JobPositionDao jobPositionDao;

    @Override
    public Result add(JobExperience jobExperience) {
        if(!jobPositionDao.existsById(jobExperience.getJobPosition().getId()))
            return new ErrorResult("Böyle bir iş alanı yok.");

        if(jobExperience.getJobPosition() == null || jobExperience.getWorkPlaceName().equals(null))
            return new ErrorResult("Değerler boş bırakılamaz.");
        else if(jobExperienceDao.existsById(jobExperience.getId()))
            return new ErrorResult("Bu iş tecrübesi zaten mevcut.");

        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("İş geçmişi eklendi");
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.jobExperienceDao.findAll(), "İş geçmişleri listelendi.");
    }
}
