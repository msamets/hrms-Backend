package hrms.lecture63.dataAcces.abstracts;

import hrms.lecture63.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {
}
