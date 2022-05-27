package hrms.lecture63.dataAcces.abstracts;

import hrms.lecture63.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
}
