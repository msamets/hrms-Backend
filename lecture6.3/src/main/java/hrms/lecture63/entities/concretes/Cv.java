package hrms.lecture63.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cvs")
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class Cv {
    //school job experience language gibi kısımları bir genel classlarını oluşturup genel school özelliklerini girip
    //bir de JobSeekerSchool gibi yapıp başlangıç ve mezun tarihlerini bunda verirsek daha temiz olur.Buna bir bak
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cv_name")
    private String cvName;

    @ManyToOne
    @JoinColumn(name = "job_seeker_user_id",referencedColumnName = "user_id",nullable = false)
    @NotNull
    @JsonIgnoreProperties(value = {"cv"})
    private JobSeeker jobSeeker;

    //BUNLAR MANY TO MANY OLACAK AYARLA BURASI- ARA CLASS JOBSEEKERSCHOOL-SCHOOL      3ÜDE
    //4.1. Modeling Relationship Attributes in https://www.baeldung.com/jpa-many-to-many#1-modeling-relationship-attributes-1
    //zaten bu linkteki mantıkla yapmıştım doğru yapmışım sadece relationshipler yanlış olmuş onları revize etmem lazım

    @ManyToMany
    @JoinTable(
            name = "cv_school",
            joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_seeker_school_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties(value = {"cv"})
    private List<JobSeekerSchool> jobSeekerSchools;


    @ManyToMany
    @JoinTable(
            name = "cv_job_experience",
            joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_seeker_job_experience_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties(value = {"cv"})
    private List<JobSeekerJobExperience> jobSeekerJobExperiences;


    @ManyToMany
    @JoinTable(
            name = "cv_language",
            joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_seeker_language_id", referencedColumnName = "id")
    )
    @JsonIgnoreProperties(value = {"cv"})
    private List<JobSeekerLanguage> jobSeekerLanguages;


    //pictureFromUser//if i have to set sql relationship, it will be
    //cv just 1 photo for each cv but photo can be inside a lot of cv.
    @ManyToOne
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"cv"})
    private Photo photo;

    @Column(name = "github_profile")
    private String githubProfile;
    @Column(name = "linkedin_profile")
    private String linkedinProfile;

    @Column(name = "skill")
    private String skill;

    @Column(name = "cover_letter")
    private String coverLetter;






}
