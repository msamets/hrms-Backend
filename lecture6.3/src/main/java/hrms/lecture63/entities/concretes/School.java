package hrms.lecture63.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
@JsonIgnoreProperties({"HibernateLazyInitializer","handler"})
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    @NotNull
    @NotBlank
    private String name;
// set a  list of department for school department choice in Cv class
    //@JsonIgnoreProperties(value = {"school"})
    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<JobSeekerSchool> jobSeekerSchool;
}
//School Language JobExperience classlarını tamamen bitirdim
//şimdi JobSeekerJobExperience vesaire classlarında kaldım daha hiç başlamadım bunlara