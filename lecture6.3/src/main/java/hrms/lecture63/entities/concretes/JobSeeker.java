package hrms.lecture63.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"HibernateLazyInitializer", "handler"})
public class JobSeeker extends User {
	
	@Column(name = "ad")
	@NotNull
	@NotBlank
	private String ad;
	
	@Column(name = "soyad")
	@NotNull
	@NotBlank
	private String soyad;
	
	@Column(name = "tc_no")
	@NotNull
	@NotBlank
	private String tcNo;
	
	@Column(name = "birth_year")
	@NotEmpty
	@NotBlank
	private int birthYear;

	@JsonIgnoreProperties(value = {"jobSeeker"})
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerSchool> jobSeekerSchools;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnoreProperties(value = {"jobSeeker"})
	private List<JobSeekerLanguage> jobSeekerLanguages;

	@OneToMany(mappedBy = "jobSeeker")
	@JsonIgnoreProperties(value = {"jobSeeker"})
	private List<JobSeekerJobExperience> jobSeekerJobExperiences;


}
