package hrms.lecture63.business.concretes;

import java.util.List;

import hrms.lecture63.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.lecture63.business.abstracts.CityService;
import hrms.lecture63.dataAcces.abstracts.CityDao;
import hrms.lecture63.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	
	
	

	@Override
	public Result add(City city) {
		if(cityDao.existsByName(city.getName()))
			return new ErrorResult("Şehir zaten mevcut.");
		this.cityDao.save(city);
		return new SuccessResult("Şehir eklendi");
	}

	@Override
	public DataResult<List<City>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Şehirler Listelendi");
	}

}
