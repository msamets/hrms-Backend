package hrms.lecture63.core.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hrms.lecture63.core.adapters.abstracts.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CloudinaryServiceAdapter implements CloudinaryService {

    private Cloudinary cloudinary;

    public CloudinaryServiceAdapter(){
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dpzpdfypb",
                "api_key", "359273894111452",
                "api_secret", "-tcV8ZS7Z6P0zRsTwC1FjRqt1sE"));
    }



    @Override
    public Map<?, ?> upload(MultipartFile multipartFile) throws IOException {
        return cloudinary.uploader().upload(convert(multipartFile), ObjectUtils.emptyMap());
    }

    @Override
    public Map<?, ?> delete(String publicId) throws IOException {
        return cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }

    @Override
    public File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }
}
