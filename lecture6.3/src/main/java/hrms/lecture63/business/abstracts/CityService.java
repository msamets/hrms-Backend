package hrms.lecture63.business.abstracts;

import java.util.List;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.City;

public interface CityService {
	Result add(City city);
	DataResult<List<City>> getAll();
}
