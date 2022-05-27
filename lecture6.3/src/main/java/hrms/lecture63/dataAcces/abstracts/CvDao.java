package hrms.lecture63.dataAcces.abstracts;

import hrms.lecture63.entities.concretes.Cv;
import hrms.lecture63.entities.concretes.JobSeekerJobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CvDao  extends JpaRepository<Cv,Integer> {
    //boolean existsCvById(); Zaten default olarak mevcut yazmama gerek yok.

    @Query(
            value = "SELECT CASE WHEN COUNT(c)> 0 THEN true ELSE false END FROM cv_school c WHERE cv_id = :cvId",
            nativeQuery = true
    )
    boolean existsCvIdInCvSchool(@Param("cvId") int cvId);

    @Query(
            value = "SELECT CASE WHEN COUNT(c)> 0 THEN true ELSE false END " +
                    "FROM cv_school c WHERE job_seeker_school_id = :jobSeekerSchoolId",
            nativeQuery = true
    )
    boolean existsJobSeekerSchoolIdInCvSchool(@Param("jobSeekerSchoolId") int jobSeekerSchoolId);

    @Modifying//EĞER SELECT DIŞINDA BİR SORGU YAPACAKSAK VERİ TABANINDAKİ BİLGİYİ MODİFY EDECEK BUNU KULLANMALIYIZ
    @Query(
            value = "INSERT INTO cv_school(cv_id, job_seeker_school_id)" +
                    "VALUES(:cvId, :jobSeekerSchoolId)",nativeQuery = true
    )
    void addSchoolToCv(@Param("cvId") int cvId,@Param("jobSeekerSchoolId") int jobSeekerSchoolId);

    @Modifying//EĞER SELECT DIŞINDA BİR SORGU YAPACAKSAK VERİ TABANINDAKİ BİLGİYİ MODİFY EDECEK BUNU KULLANMALIYIZ
    @Query(
            value = "INSERT INTO cv_language(cv_id, job_seeker_language_id)" +
                    "VALUES(:cvId, :jobSeekerLanguageId)", nativeQuery = true
    )
    void addLanguageToCv(@Param("cvId") int cvId,@Param("jobSeekerLanguageId") int jobSeekerLanguageId);

    @Query(
            value = "SELECT CASE WHEN COUNT(c)>0 THEN true ELSE false END " +
                    "FROM cv_language c WHERE job_seeker_language_id = :jobSeekerLanguageId",
            nativeQuery = true
    )
    boolean existsJobSeekerLanguageIdInCvLanguage(@Param("jobSeekerLanguageId") int jobSeekerLanguageId);

    @Modifying//EĞER SELECT DIŞINDA BİR SORGU YAPACAKSAK VERİ TABANINDAKİ BİLGİYİ MODİFY EDECEK BUNU KULLANMALIYIZ
    @Query(
            value = "INSERT INTO cv_job_experience(cv_id, job_seeker_job_experience_id)" +
                    "VALUES(:cvId, :jobSeekerJobExperienceId)", nativeQuery = true
    )
    void addJobExperienceToCv(@Param("cvId") int cvId,@Param("jobSeekerJobExperienceId") int jobSeekerJobExperienceId);

    @Query(
            value = "SELECT CASE WHEN COUNT(c)>0 THEN true else false END " +
                    "FROM cv_job_experience c WHERE job_seeker_job_experience_id = :jobSeekerJobExperienceId",
            nativeQuery = true
    )
    boolean existsJobSeekerJobExperienceIdInCvJobExperience(@Param("jobSeekerJobExperienceId") int jobSeekerJobExperienceId);

    @Modifying//EĞER SELECT DIŞINDA BİR SORGU YAPACAKSAK VERİ TABANINDAKİ BİLGİYİ MODİFY EDECEK BUNU KULLANMALIYIZ
    @Query(
            value = "UPDATE Cv cv SET cv.githubProfile = :githubProfile WHERE cv.id = :cvId"
    )
    void addGithubProfileToCv(@Param("cvId") int cvId,@Param("githubProfile") String githubProfile);

    @Modifying
    @Query(
            value = "UPDATE Cv cv SET cv.linkedinProfile = :linkedinProfile WHERE cv.id = :cvId"
    )
    void addLinkedinProfileToCv(@Param("cvId") int cvId,@Param("linkedinProfile") String linkedinProfile);

    @Modifying
    @Query(
            value = "UPDATE Cv cv SET cv.coverLetter = :coverLetter WHERE cv.id = :cvId"
    )
    void addCoverLetterToCv(@Param("cvId") int cvId,@Param("coverLetter") String coverLetter);

    @Modifying
    @Query(
            value = "UPDATE Cv cv SET cv.skill = :skill WHERE cv.id = :cvId"
    )
    void addSkillToCv(@Param("cvId") int cvId,@Param("skill") String skill);







    //okulu desc sırala mezun değilse en üstte Devam ediyor yazılmalı
    //bu tecrübeleri yıllara göre sırala
    //işten ayrılma sebebi boş geçilmeli eğer hala çalışıyorsaen üstte devam ediyor yazmalı
    //photo will be out-service integration
}
