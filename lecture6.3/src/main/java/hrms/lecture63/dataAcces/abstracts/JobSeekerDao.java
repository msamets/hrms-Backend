package hrms.lecture63.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.lecture63.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	//JobSeeker için e posta ve tc
	JobSeeker getJobSeekerByTcNo(String tcNo);
	JobSeeker getJobSeekerByEmail(String email);
	
	boolean existsJobSeekerByEmail(String email);

	boolean existsJobSeekerByNationalIdNumber(String tcNo);
}
