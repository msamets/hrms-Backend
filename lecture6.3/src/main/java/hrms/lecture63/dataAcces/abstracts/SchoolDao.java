package hrms.lecture63.dataAcces.abstracts;

import hrms.lecture63.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School, Integer> {
}
