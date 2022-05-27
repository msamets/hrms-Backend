package hrms.lecture63.business.abstracts;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.entities.concretes.JobSeekerLanguage;
import org.springframework.http.ResponseEntity;

public interface JobSeekerLanguageService {

    ResponseEntity add(JobSeekerLanguage jobSeekerLanguage);
    DataResult getAll();
}
