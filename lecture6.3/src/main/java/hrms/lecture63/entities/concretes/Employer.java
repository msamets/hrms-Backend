package hrms.lecture63.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
//@DiscriminatorValue("Employer")            it is for hibernate inheritance one table strategy
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employer extends User {
	

	@Column(name = "sirket_adi", nullable = false, unique = true)
	@NotNull
	@NotBlank
	private String sirketAdi;
	
	@Column(name = "sirket_website", unique = false, nullable = false)
	@NotNull
	@NotBlank
	private String sirketWebsite;
	
	@Column(name = "telefon_no", nullable = false, unique = true)
	@NotNull
	@NotBlank
	private String telefonNo;

	//@JsonIgnoreProperties(value = {"employer"})
	@JsonIgnore
	@OneToMany(mappedBy = "employer" )//, cascade = CascadeType.ALL, orphanRemoval = true
	private List<JobAdvertisement> jobAdvertisements;
	
	
	@Column(name = "verification_from_system_employee")
	private boolean verificationFromSystemEmployee;

	

	

	
	
	

}
