package hrms.lecture63.business.abstracts;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.entities.concretes.JobSeekerJobExperience;
import org.springframework.http.ResponseEntity;

public interface JobSeekerJobExperienceService {
    ResponseEntity add(JobSeekerJobExperience jobSeekerJobExperience);
    DataResult getAll();
}
