package hrms.lecture63.dataAcces.abstracts;

import hrms.lecture63.entities.concretes.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoDao extends JpaRepository<Photo, Integer> {
    Photo getByPublicId(String publicId);
    void deleteByPublicId(String publicId);
}
