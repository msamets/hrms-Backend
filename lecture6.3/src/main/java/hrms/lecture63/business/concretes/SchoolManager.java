package hrms.lecture63.business.concretes;

import hrms.lecture63.business.abstracts.SchoolService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.core.utilities.results.SuccessResult;
import hrms.lecture63.dataAcces.abstracts.SchoolDao;
import hrms.lecture63.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolManager implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Override
    public Result add(School school) {

        this.schoolDao.save(school);
        return new SuccessResult("Okul eklendi.");
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.schoolDao.findAll(), "Okullar listelendi");
    }
}
