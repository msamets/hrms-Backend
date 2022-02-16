package hrms.lecture63.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")

public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JsonIgnore
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "employer_id")
	@NotBlank
	@NotNull
	private Employer employer;
	
	@JsonIgnore
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_position_id")
	@NotBlank
	@NotNull
	private JobPosition jobPosition;
	
	@Column(name = "job_detail")
	@NotBlank
	@NotNull
	private String jobDetail;
	/*
	@Column(name = "city")
	private String city;
	*/
	@Column(name = "min_salary")
	private int minSalary;//opsiyonel
	
	@Column(name =	"max_salary")
	private int maxSalary;//opsiyonel
	
	@Column(name = "open_position")
	@NotBlank
	@NotEmpty
	private int openPosition;
	
	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name = "active")
	private boolean active;
	
	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@JsonIgnore
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id")
	@NotBlank
	@NotNull
	private City city;

}
