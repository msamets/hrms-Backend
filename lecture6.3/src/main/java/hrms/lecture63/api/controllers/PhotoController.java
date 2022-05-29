package hrms.lecture63.api.controllers;

import hrms.lecture63.business.abstracts.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;


@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/getById")
    public ResponseEntity<Object> getById(@RequestParam int photoId){
        return ResponseEntity.ok(photoService.getById(photoId));
    }

    @GetMapping("/getByPublicId")
    public ResponseEntity<Object> getByPublicId(@RequestParam String publicId){
        return ResponseEntity.ok(photoService.getByPublicId(publicId));
    }

    @PostMapping("/upload")
    public ResponseEntity<Object> upload(@RequestPart @Valid MultipartFile multipartFile,@RequestParam @Valid int userId) throws IOException {
        return ResponseEntity.ok(photoService.upload(multipartFile, userId));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Object> deleteById(@RequestParam int photoId) throws IOException {
        return ResponseEntity.ok(photoService.deleteById(photoId));
    }

    @DeleteMapping("/deleteByPublicId")
    public ResponseEntity<Object> deleteByPublicId(@RequestParam String publicId) throws IOException {
        return ResponseEntity.ok(photoService.deleteByPublicId(publicId));
    }



}
