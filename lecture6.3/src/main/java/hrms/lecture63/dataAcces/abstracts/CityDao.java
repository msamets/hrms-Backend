package hrms.lecture63.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.lecture63.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

    boolean existsByName(String cityName);
}
