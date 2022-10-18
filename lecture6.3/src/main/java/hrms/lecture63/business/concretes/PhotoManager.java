package hrms.lecture63.business.concretes;

import hrms.lecture63.business.abstracts.PhotoService;
import hrms.lecture63.core.adapters.abstracts.CloudinaryService;
import hrms.lecture63.core.utilities.results.*;
import hrms.lecture63.dataAcces.abstracts.PhotoDao;
import hrms.lecture63.dataAcces.abstracts.UserDao;
import hrms.lecture63.entities.concretes.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class PhotoManager implements PhotoService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PhotoDao photoDao;
    @Autowired
    private CloudinaryService cloudinaryService;





    @Override
    public DataResult<Photo> getById(int photoId) {
        if(!photoDao.existsById(photoId))
            return new ErrorDataResult<>("Böyle bir fotoğraf bulunamadı.");
        return new SuccessDataResult<>(photoDao.getById(photoId));
    }

    @Override
    public DataResult<Photo> getByPublicId(String publicId) {
        if(!photoDao.existsByPublicId(publicId))
            return new ErrorDataResult<>("Böyle bir fotoğraf bulunamadı.");
        return new SuccessDataResult<>(photoDao.getByPublicId(publicId));
    }

    @Override
    public Result upload(MultipartFile multipartFile, int userId) throws IOException {

        //Burda multipartfile boş dönünce hata geliyor console a ama
        //hata buraya daha gelmeden önce request olarak hata veriyor
        //o yüzden multipartfile ın boş dönmemesini front-end kısmında
        //handle etmem gerek
        if(!userDao.existsById(userId))
            return new ErrorResult("Böyle bir kullanıcı yok.");



        if(multipartFile == null || multipartFile.isEmpty() )
            return new ErrorResult("Yüklenecek fotoğraf uygun değil" +
                    "lütfen başka bir fotoğraf seçiniz.");


        int width;
        int height;

        BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
        if(bufferedImage == null)
            return new ErrorResult("Fotoğraf uygun değil lütfen" +
                    "başka bir fotoğraf seçiniz");

        width = bufferedImage.getWidth();
        height = bufferedImage.getHeight();

        Map<?, ?> uploadRes = cloudinaryService.upload(multipartFile);
        if(uploadRes == null)
            return new ErrorResult("Yükleme hatası, fotoğraf uygun değil.");

        Photo photo = new Photo(0,(String) uploadRes.get("public_id"),
                (String) uploadRes.get("original_filename"),
                userDao.getById(userId),
                (String) uploadRes.get("url"),
                (short) width ,
                (short) height);

        Photo savedPhoto = photoDao.save(photo);


        return new SuccessDataResult<>(savedPhoto, "Fotoğraf başarıyla " +
                "kaydedildi.");

    }

    @Override
    public Result deleteById(int photoId) throws IOException {

        if(!photoDao.existsById(photoId))
            return new ErrorResult("Fotoğraf mevcut değil.");

        Photo photo = photoDao.getById(photoId);

        Map<?, ?> uploadRes = cloudinaryService.delete(photo.getPublicId());
        if(uploadRes == null)
            return new ErrorResult("Silinirken hata oluştu");

        photoDao.deleteById(photoId);

        return new SuccessResult("Fotoğraf başarıyla silindi.");
    }

    @Override
    public Result deleteByPublicId(String publicId) throws IOException {

        Map<?, ?> uploadRes = cloudinaryService.delete(publicId);
        if(uploadRes == null)
            return new ErrorResult("Fotoğraf mevcut değil.");

        photoDao.deleteByPublicId(publicId);

        return new SuccessResult("Fotoğraf başarıyla silindi.");
    }

    @Override
    public DataResult<List<Photo>> getByUserId(int userId) {
        if(!userDao.existsById(userId))
            return new ErrorDataResult<>("Böyle bir kullanıcı yok.");

        return new SuccessDataResult<>(photoDao.getByUserId(userId),"Kullanıcıya ait fotoğraflar başarıyla listelendi.");
    }
}
