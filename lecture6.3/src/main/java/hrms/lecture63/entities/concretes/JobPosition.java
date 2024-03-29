package hrms.lecture63.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_positions")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"HibernateLazyInitializer","handler"})
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_position_names",nullable = false, unique = true)
	@NotNull
	@NotBlank
	private String jobPositionName;

	@JsonIgnore
	@OneToMany(mappedBy = "jobPosition")
	//@JsonIgnoreProperties(value = {"jobPosition"})
	private List<JobAdvertisement> jobAdvertisements;

	@JsonIgnore
	@OneToMany(mappedBy = "jobPosition")
	//@JsonIgnoreProperties(value = {"jobPosition"})
	private List<JobExperience> jobExperiences;

}
