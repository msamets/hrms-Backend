package hrms.lecture63.dataAcces.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import hrms.lecture63.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	//bunlar çağrılırken aktifliğine default olarak bakılmalı
	List<JobAdvertisement> getByActive(boolean Active, Sort sort);
	
	List<JobAdvertisement> getByActive(boolean isActive);
	
	List<JobAdvertisement> getAllByEmployer_IdAndActive(int employerId, boolean isActive);
	
}
