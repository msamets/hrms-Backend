package hrms.lecture63.dataAcces.abstracts;

import hrms.lecture63.entities.concretes.JobSeekerJobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerJobExperienceDao extends JpaRepository<JobSeekerJobExperience, Integer> {
    List<JobSeekerJobExperience> findByJobSeekerOrderByQuitJobDateDesc(int userId);
}
