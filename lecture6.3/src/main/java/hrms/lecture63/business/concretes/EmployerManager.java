package hrms.lecture63.business.concretes;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.lecture63.business.abstracts.EmployerService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.ErrorResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.core.utilities.results.SuccessResult;
import hrms.lecture63.core.verifications.abstracts.EmailVerificationService;
import hrms.lecture63.core.verifications.abstracts.HrmsVerificationService;
import hrms.lecture63.dataAcces.abstracts.EmployerDao;
import hrms.lecture63.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService {
	
	private HrmsVerificationService hrmsVerificationService;
	private EmailVerificationService emailVerificationService;
	private EmployerDao employerDao;
	
	
	
	@Autowired
	public EmployerManager(HrmsVerificationService hrmsVerificationService, EmailVerificationService emailVerificationService, EmployerDao employerDao) {
		this.emailVerificationService = emailVerificationService;
		this.employerDao = employerDao;
		this.hrmsVerificationService = hrmsVerificationService;
		
	}
	
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll()
				, "İş verenler listelendi.");
	}
	

	
	
	
	



	@Override
	public Result add(Employer employer) {
		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
		Pattern pattern =	Pattern.compile(passwordRegex,Pattern.UNICODE_CHARACTER_CLASS);
		

			

		
		
		if(employerDao.existsEmployerByEmail(employer.getEmail())) {
			return new ErrorResult("Girmiş olduğunuz email daha önce kullanılmış.");
		}
		
		else if(!pattern.matches(passwordRegex, employer.getPassword())) {
			return new ErrorResult("Girmiş olduğunuz şifre geçerli değil."
					+ "Şifre en az 8 karakterden ve bir küçük bir büyük harf ve"
					+ "rakam içermek zorundadır."
					+ "Lütfen geçerli bir şifre giriniz.");
		}
		
		
		
		employer.setEmailVerification(true);
		employer.setVerificationFromSystemEmployee(true);
		
		this.employerDao.save(employer);
		return new SuccessResult("İş veren başarıyla eklendi");
	}
	
}
