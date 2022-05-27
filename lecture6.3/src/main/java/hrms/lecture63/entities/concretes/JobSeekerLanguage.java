package hrms.lecture63.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_languages")
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class JobSeekerLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "language_id",referencedColumnName = "id",nullable = false)
    @JsonIgnoreProperties(value = {"jobSeekerLanguage"})
    private Language language;

    @Max(5)
    @Min(0)
    @NotNull
    @Column(name = "language_level", nullable = false)
    private int languageLevel;

    @ManyToOne
    @JoinColumn(name = "job_seeker_user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
    @JsonIgnoreProperties(value = {"jobSeekerLanguage"})
    private JobSeeker jobSeeker;

    @ManyToMany(mappedBy = "jobSeekerLanguages")
    @JsonIgnore
    private List<Cv> cvs;








}
