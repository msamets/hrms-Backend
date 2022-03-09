package hrms.lecture63.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.lecture63.business.abstracts.JobAdvertisementService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.core.utilities.results.SuccessResult;
import hrms.lecture63.dataAcces.abstracts.JobAdvertisementDao;
import hrms.lecture63.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
	}
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActive(true), "İş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByDate() {
		Sort sort = Sort.by(Sort.Direction.ASC, "createdDate");
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActive(true, sort),"İş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByEmployer_IdAndActive(employerId, true), "İş ilanları listelendi.");
	}

	@Override
	public Result turnDeactive(int id) {
		this.jobAdvertisementDao.getById(id).setActive(false);
		return new SuccessResult("İlan pasif olarak ayarlandı.");
	}
}
