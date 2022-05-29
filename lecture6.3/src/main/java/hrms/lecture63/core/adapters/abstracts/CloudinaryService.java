package hrms.lecture63.core.adapters.abstracts;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {

    Map<?, ?> upload(MultipartFile multipartFile) throws IOException;

    Map<?, ?> delete(String publicId) throws IOException;

    File convert(MultipartFile multipartFile) throws IOException;
}
