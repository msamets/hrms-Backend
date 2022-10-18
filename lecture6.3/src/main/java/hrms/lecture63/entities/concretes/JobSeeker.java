package hrms.lecture63.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
//@DiscriminatorValue("JobSeeker")            it is for hibernate inheritance one table strategy
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class JobSeeker extends User {
	
	@Column(name = "name", nullable = false)
	@NotNull
	@NotBlank
	private String name;
	
	@Column(name = "surname" ,nullable = false)
	@NotNull
	@NotBlank
	private String surname;
	
	@Column(name = "national_id_number" ,unique = true, nullable = false)
	@NotNull
	@NotBlank
	private String nationalIdNumber;
	
	@Column(name = "birth_year", nullable = false)
	@NotNull
	private int birthYear;

	@JsonIgnore
	//@JsonIgnoreProperties(value = {"jobSeeker"})
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerSchool> jobSeekerSchools;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
	//@JsonIgnoreProperties(value = {"jobSeeker"})
	private List<JobSeekerLanguage> jobSeekerLanguages;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	//@JsonIgnoreProperties(value = {"jobSeeker"})
	private List<JobSeekerJobExperience> jobSeekerJobExperiences;




}
