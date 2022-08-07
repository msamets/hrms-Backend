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
@Table(name = "job_seeker_schools")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobSeekerSchool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonIgnoreProperties(value = {"jobSeekerSchool"})
    @ManyToOne
    @NotNull
    @JoinColumn(name = "school_id",referencedColumnName = "id", nullable = false)
    private School school;

    @Column(name = "school_department", nullable = false)
    @NotNull
    private String schoolDepartment;

    @JsonIgnoreProperties(value = {"jobSeekerSchool"})
    @ManyToOne
    @NotNull
    @JoinColumn(name = "job_seeker_user_id",referencedColumnName = "user_id",nullable = false)
    private JobSeeker jobSeeker;


    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy"
    )
    @NotNull
    @Column(name = "start_school_date", nullable = false)
    private LocalDate startSchoolDate;


    @JsonFormat(
            shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy"
    )
    @Column(name = "graduation_school_date")
    private LocalDate graduationSchoolDate;


    @ManyToMany(mappedBy = "jobSeekerSchools")
    @JsonIgnore
    private List<Cv> cvs;


}
