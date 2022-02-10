package hrms.lecture63.business.abstracts;

import java.util.List;


import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	//bunlar çağrılırken aktifliğine default olarak bakılmalı
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllSortedByDate();
	DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);
	Result turnDeactive(int id);

}
