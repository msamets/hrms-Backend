package hrms.lecture63.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.lecture63.business.abstracts.JobPositionService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.ErrorResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.core.utilities.results.SuccessResult;
import hrms.lecture63.dataAcces.abstracts.JobPositionDao;
import hrms.lecture63.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	@Autowired
	private JobPositionDao jobPositionDao;
	
	@Autowired//(gidiyor projeyi tarıyor bu projede bu sınıfa denk geleni buluyor)
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
		
	}
	
	
	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(
				this.jobPositionDao.findAll(),"İş pozisyonları listelendi.");
	}
	
	
	@Override
	public Result add(JobPosition jobPosition) {


		
		
		if(jobPositionDao.existsById(jobPosition.getId())) {
			return new ErrorResult("Girmiş olduğunuz pozisyon zaten mevcuttur.");
		}
		else if (jobPosition == null || jobPosition.getJobPositionName().equals(null)) {
			return new ErrorResult("İş pozisyonu boş bırakılamaz.");
		}

		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("İş pozisyonu başarıyla eklendi.");
		
		
	}

}
