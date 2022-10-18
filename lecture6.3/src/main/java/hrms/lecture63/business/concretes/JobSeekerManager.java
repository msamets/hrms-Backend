package hrms.lecture63.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.lecture63.business.abstracts.JobSeekerService;
import hrms.lecture63.core.adapters.abstracts.MernisCheckService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.ErrorResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.core.utilities.results.SuccessResult;
import hrms.lecture63.core.verifications.abstracts.EmailVerificationService;
import hrms.lecture63.dataAcces.abstracts.JobSeekerDao;
import hrms.lecture63.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobSeekerService{
	
	private EmailVerificationService emailVerificationService;
	private JobSeekerDao jobSeekerDao;
	private MernisCheckService mernisCheckService;
	
	@Autowired
	public JobSeekerManager(MernisCheckService mernisCheckService, JobSeekerDao jobSeekerDao, EmailVerificationService emailVerificationService) {
		this.jobSeekerDao = jobSeekerDao;
		this.emailVerificationService = emailVerificationService;
		this.mernisCheckService = mernisCheckService;
	}
	
	
	
	
	
	
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll()
				,"İş arayanlar listelendi.");
	}

	
	


	public Result isValidPerson(JobSeeker jobSeeker) throws Exception {
		if(!mernisCheckService.checkIfRealPerson(jobSeeker).isSuccess()) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}




	@Override
	public Result add(JobSeeker jobSeeker) throws Exception {

		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
		Pattern pattern =	Pattern.compile(passwordRegex,Pattern.UNICODE_CHARACTER_CLASS);
		

		

		
		if(jobSeekerDao.existsJobSeekerByEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Girmiş olduğunuz email daha önce kullanılmıştır.");
		}
		
		else if(jobSeekerDao.existsJobSeekerByNationalIdNumber(jobSeeker.getNationalIdNumber())) {
			return new ErrorResult("Girmiş olduğunuz Tc numarası daha önce kullanımıştır.");
		}
		
		else if(!pattern.matches(passwordRegex, jobSeeker.getPassword())) {
			return new ErrorResult("Girmiş olduğunuz şifre geçerli değil."
					+ "Şifre en az 8 karakterden ve bir küçük bir büyük harf ve"
					+ "rakam içermek zorundadır."
					+ "Lütfen geçerli bir şifre giriniz.");
		}
		
		jobSeeker.setEmailVerification(true);
		
		if(!isValidPerson(jobSeeker).isSuccess()) {
			return new ErrorResult("Böyle biri yok lütfen bilgilerinizi kontrol ediniz.");
		}
		
		
		
		
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan başarıyla eklendi");
	}

}
