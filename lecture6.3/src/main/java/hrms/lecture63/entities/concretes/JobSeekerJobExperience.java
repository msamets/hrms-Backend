package hrms.lecture63.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_job_experiences")
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class JobSeekerJobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_experience_id", referencedColumnName = "id" ,nullable = false)
    @JsonIgnoreProperties(value = {"jobSeekerJobExperience"})
    private JobExperience jobExperience;

    @ManyToOne
    @JoinColumn(name = "job_seeker_user_id",referencedColumnName = "user_id",nullable = false)
    @NotNull
    @JsonIgnoreProperties(value = {"jobSeekerJobExperience"})
    private JobSeeker jobSeeker;

    @Column(name = "start_job_date", nullable = false)
    @NotNull
    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy"
    )
    private LocalDate startJobDate;

    @Column(name = "quit_job_date")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy"
    )
    private LocalDate quitJobDate;

    @Column(name = "job_quit_reason")
    private String jobQuitReason;

    @ManyToMany(mappedBy = "jobSeekerJobExperiences")
    @JsonIgnore
    private List<Cv> cvs;


}
