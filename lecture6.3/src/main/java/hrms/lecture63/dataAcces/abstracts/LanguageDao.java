package hrms.lecture63.dataAcces.abstracts;

import hrms.lecture63.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
