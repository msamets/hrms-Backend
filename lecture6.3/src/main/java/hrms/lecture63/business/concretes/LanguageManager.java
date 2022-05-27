package hrms.lecture63.business.concretes;

import hrms.lecture63.business.abstracts.LanguageService;
import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.core.utilities.results.SuccessDataResult;
import hrms.lecture63.core.utilities.results.SuccessResult;
import hrms.lecture63.dataAcces.abstracts.LanguageDao;
import hrms.lecture63.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {

    @Autowired
    private LanguageDao languageDao;

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Dil eklendi.");
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.languageDao.findAll(),"Diller listelendi.");
    }
}
