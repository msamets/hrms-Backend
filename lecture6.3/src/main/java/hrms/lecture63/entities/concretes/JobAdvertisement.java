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
	

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "employer_user_id", referencedColumnName = "user_id",nullable = false)
	@NotNull
	private Employer employer;
	

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_position_id",referencedColumnName = "id",nullable = false)
	@NotNull
	private JobPosition jobPosition;
	
	@Column(name = "job_detail", nullable = false)
	@NotBlank
	@NotNull
	private String jobDetail;

	@Column(name = "min_salary")
	private int minSalary;//opsiyonel
	
	@Column(name =	"max_salary")
	private int maxSalary;//opsiyonel
	
	@Column(name = "open_position", nullable = false)
	@NotNull
	private int openPosition;
	
	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name = "active")
	private boolean active;
	
	@CreatedDate
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id",referencedColumnName = "id",nullable = false)
	@NotNull
	private City city;

}
