package hrms.lecture63.dataAcces.abstracts;

import hrms.lecture63.entities.concretes.JobSeekerSchool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerSchoolDao extends JpaRepository<JobSeekerSchool, Integer> {
}
