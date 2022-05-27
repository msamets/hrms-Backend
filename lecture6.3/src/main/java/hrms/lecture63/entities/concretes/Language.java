package hrms.lecture63.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    @NotNull
    @NotBlank
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "language")
    //@JsonIgnoreProperties(value = {"language"})
    private List<JobSeekerLanguage> jobSeekerLanguages;



    //languageName



}
