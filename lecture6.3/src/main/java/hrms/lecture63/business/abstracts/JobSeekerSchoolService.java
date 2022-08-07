package hrms.lecture63.business.abstracts;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.entities.concretes.JobSeekerSchool;
import org.springframework.http.ResponseEntity;

public interface JobSeekerSchoolService {

    ResponseEntity add(JobSeekerSchool jobSeekerSchool);

    DataResult getAll();
}
