package hrms.lecture63.business.abstracts;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.JobExperience;

public interface JobExperienceService {

    Result add(JobExperience jobExperience);
    DataResult getAll();
}
