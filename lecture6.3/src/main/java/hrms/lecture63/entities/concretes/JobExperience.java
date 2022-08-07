package hrms.lecture63.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class JobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "work_place_name", nullable = false)
    @NotNull
    private String workPlaceName;

    @JoinColumn(name = "job_position_id",referencedColumnName = "id",nullable = false)
    @NotNull
    @ManyToOne
    private JobPosition jobPosition;

    @JsonIgnore
    @OneToMany(mappedBy = "jobExperience")
    //@JsonIgnoreProperties(value = {"jobExperience"})
    private List<JobSeekerJobExperience> jobSeekerJobExperiences;


    //workPlaceName, jobPosition
}
