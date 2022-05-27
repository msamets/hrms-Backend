package hrms.lecture63.business.abstracts;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.Language;

public interface LanguageService {

    Result add(Language language);
    DataResult getAll();
}
