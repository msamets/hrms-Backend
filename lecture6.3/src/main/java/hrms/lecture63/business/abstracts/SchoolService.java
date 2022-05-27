package hrms.lecture63.business.abstracts;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.School;
import net.bytebuddy.asm.Advice;

public interface SchoolService {
    Result add(School school);
    DataResult getAll();
}
