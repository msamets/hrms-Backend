package hrms.lecture63.dataAcces.abstracts;

import hrms.lecture63.entities.concretes.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoDao extends JpaRepository<Photo, Integer> {
    Photo getByPublicId(String publicId);
    void deleteByPublicId(String publicId);

    List<Photo> getByUserId(int userId);
}
