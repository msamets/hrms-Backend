package hrms.lecture63.business.concretes;

import hrms.lecture63.business.abstracts.CvService;
import hrms.lecture63.core.utilities.JobSeekerJobQuitDateComparator;
import hrms.lecture63.core.utilities.results.*;
import hrms.lecture63.dataAcces.abstracts.*;
import hrms.lecture63.entities.concretes.Cv;
import hrms.lecture63.entities.concretes.JobSeekerJobExperience;
import hrms.lecture63.entities.concretes.JobSeekerSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CvManager implements CvService {

    @Autowired
    private CvDao cvDao;
    @Autowired
    private JobSeekerSchoolDao jobSeekerSchoolDao;
    @Autowired
    private JobSeekerLanguageDao jobSeekerLanguageDao;
    @Autowired
    private JobSeekerJobExperienceDao jobSeekerJobExperienceDao;

    @Autowired
    private PhotoDao photoDao;

    @Autowired
    private JobSeekerDao jobSeekerDao;

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),"Cv'ler listelendi");
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv başarıyla eklendi");
    }

    @Override
    public Result addSchoolToCv(int cvId, int jobSeekerSchoolId) {
        if (!cvDao.existsById(cvId))
            return new ErrorResult("Böyle bir cv mevcut değil.");

        else if(!jobSeekerSchoolDao.existsById(jobSeekerSchoolId))
            return new ErrorResult("Böyle bir okul bilgisi mevcut değil.");


        else if(cvDao.existsCvIdInCvSchool(cvId) && cvDao.existsJobSeekerSchoolIdInCvSchool(jobSeekerSchoolId))
            return new ErrorResult("Girmiş olduğunuz okul bilgisi zaten cv de mevcut.");

        this.cvDao.addSchoolToCv(cvId, jobSeekerSchoolId);
        return new SuccessResult("Okul bilgisi cv'ye başarıyla eklendi.");
    }

    @Override
    public Result addLanguageToCv(int cvId, int jobSeekerLanguageId) {
        if (!cvDao.existsById(cvId))// aslında bu if bloğu method olarak tanımlanabilir ama sadece bu 5-6 method da kullandığım
            return new ErrorResult("Böyle bir cv mevcut değil.");// için method haline getirmiyorum. hemde bunu genelleyemem
        //sadece cv için olanını yazabilirim.

        else if(!jobSeekerLanguageDao.existsById(jobSeekerLanguageId))
            return new ErrorResult("Böyle bir dil bilgisi mevcut değil.");

        else if (cvDao.existsCvIdInCvSchool(cvId) && cvDao.existsJobSeekerLanguageIdInCvLanguage(jobSeekerLanguageId))
            return new ErrorResult("Girmiş olduğunuz dil bilgisi zaten cv de mevcut.");

        this.cvDao.addLanguageToCv(cvId,jobSeekerLanguageId);
        return new SuccessResult("Dil bilgisi cv'ye başarıyla eklendi.");
    }

    @Override
    public Result addJobExperienceToCv(int cvId, int jobSeekerJobExperienceId) {
        if (!cvDao.existsById(cvId))
            return new ErrorResult("Böyle bir cv mevcut değil.");

        else if (!jobSeekerJobExperienceDao.existsById(jobSeekerJobExperienceId))
            return new ErrorResult("Böyle bir iş tecrübesi  mevcut değil.");

        else if(cvDao.existsCvIdInCvSchool(cvId) && cvDao.existsJobSeekerJobExperienceIdInCvJobExperience(jobSeekerJobExperienceId))
            return new ErrorResult("Girmiş olduğunuz iş tecrübesi zaten cv de mevcut.");

        this.cvDao.addJobExperienceToCv(cvId, jobSeekerJobExperienceId);
        return new SuccessResult("İş tecrübe cv'ye başarıyla eklendi.");
    }

    @Override
    public Result addGithubProfileToCv(int cvId, String githubProfile) {
        if (!cvDao.existsById(cvId))
            return new ErrorResult("Böyle bir cv mevcut değil.");



        cvDao.addGithubProfileToCv(cvId, githubProfile);
        return new SuccessResult("Github profili cv'ye başarıyla eklendi.");
    }

    @Override
    public Result addLinkedinProfileToCv(int cvId, String linkedinProfile) {
        if (!cvDao.existsById(cvId))
            return new ErrorResult("Böyle bir cv mevcut değil.");

        cvDao.addLinkedinProfileToCv(cvId, linkedinProfile);
        return new SuccessResult("Linkedin profili cv'ye başarıyla eklendi.");
    }

    @Override
    public Result addCoverLetterToCv(int cvId, String coverLetter) {
        if (!cvDao.existsById(cvId))
            return new ErrorResult("Böyle bir cv mevcut değil.");

        cvDao.addCoverLetterToCv(cvId, coverLetter);
        return new SuccessResult("Ön yazı cv'ye başarıyla eklendi.");
    }

    @Override
    public Result addSkillToCv(int cvId, String skill) {
        if (!cvDao.existsById(cvId))
            return new ErrorResult("Böyle bir cv mevcut değil.");

        cvDao.addSkillToCv(cvId, skill);
        return new SuccessResult("Yetenekler cv'ye başarıyla eklendi.");
    }

    @Override
    public DataResult<List<JobSeekerJobExperience>> findJobSeekerJobExperienceOrderByQuitJobDateDesc(int cvId) {

        if(!cvDao.existsById(cvId))
            return new ErrorDataResult<>("Böyle bir cv mevcut değil.");

        //cvDao.getById(cvId).getJobSeekerJobExperiences()

        //Burda veritabanından bir veri getirmiyor veritabanından getirdiğimiz veriden id ye erişip o idnin classından jobSeeker
        //JobExperience listine erişiyoruz o yüzden listi sort etmek için comparator kullanacağız

        //Desc sıralamada kaldım.
        //Comparator classı kullandım comparator da custom null comparator girdim
        //sonra normal asc sorting i -1 ile çarparak reverseledim otomatik olarak desc yaptım.
        //custom null comparator düzeltme kısmında hangisi null ise onu öne(yukarı) olarak sırala dedim ve oldu.
        List<JobSeekerJobExperience> jobSeekerJobExperiences = cvDao.getById(cvId).getJobSeekerJobExperiences();

        List<JobSeekerJobExperience> sortedJobSeekerJobExperiencesOrderByDescNullFirst = jobSeekerJobExperiences.stream()
                .sorted(Comparator.nullsFirst(new JobSeekerJobQuitDateComparator())).collect(Collectors.toList());


        //null ise devam ediyor olarak göster koşulu basit olduğundan onu frontend e bırakıyorum
        //bilmiyorum burda yapılacaksa da normalde burda foreach ile dönülüp kontrol edilip null ise devam ediyor olarak
        //değiştirilebilir.

        return new SuccessDataResult<List<JobSeekerJobExperience>>
                (sortedJobSeekerJobExperiencesOrderByDescNullFirst,
                        "İş tecrübeleri yıla göre tersten sıralandı.");


    }

    @Override
    public DataResult<List<JobSeekerSchool>> findJobSeekerSchoolOrderByGraduationDateDesc(int cvId) {

        if(!cvDao.existsById(cvId))
            return new ErrorDataResult<>("Böyle bir cv mevcut değil.");


        List<JobSeekerSchool> jobSeekerSchools = cvDao.getById(cvId).getJobSeekerSchools();

        List<JobSeekerSchool> sortedJobSeekerSchoolOrderByDescNullFirst = jobSeekerSchools.stream().sorted(
                Comparator.nullsFirst(new JobSeekerSchoolGraduationDateComparator())).collect(Collectors.toList());


        //null ise devam ediyor olarak göster koşulu basit olduğundan onu frontend e bırakıyorum
        //bilmiyorum burda yapılacaksa da normalde burda foreach ile dönülüp kontrol edilip null ise devam ediyor olarak
        //değiştirilebilir.

        return new SuccessDataResult<List<JobSeekerSchool>>(sortedJobSeekerSchoolOrderByDescNullFirst, "Okullar yıla göre tersten sıralandı.");
    }

    @Override
    public Result addPhotoToCv(int cvId, int photoId) {
        if(!cvDao.existsById(cvId))
            return new ErrorResult("Böyle bir cv bulunamadı.");
        else if(!photoDao.existsById(photoId))
            return new ErrorResult("Böyle bir fotoğraf bulunamadı.");


        cvDao.addPhotoToCv(cvId, photoId);
        return new SuccessResult("Fotoğraf  başarıyla eklendi");
    }

    @Override
    public DataResult<List<Cv>> getByJobSeekerId(int jobSeekerId) {
        if(!jobSeekerDao.existsById(jobSeekerId))
            return new ErrorDataResult<>("Böyle bir iş arayan bulunamadı.");

        return new SuccessDataResult<>(cvDao.getCvsByJobSeekerId(jobSeekerId),"İş arayana ait cv'ler başarıyla getirildi.");
    }


}
