package hrms.lecture63.business.abstracts;

import hrms.lecture63.core.utilities.results.DataResult;
import hrms.lecture63.core.utilities.results.Result;
import hrms.lecture63.entities.concretes.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PhotoService {

    DataResult<Photo> getById(int photoId);

    DataResult<Photo> getByPublicId(String publicId);

    Result upload(MultipartFile multipartFile, int userId) throws IOException;

    Result deleteById(int photoId) throws IOException;

    Result deleteByPublicId(String publicId) throws IOException;

    DataResult<List<Photo>> getByUserId(int userId);
}
