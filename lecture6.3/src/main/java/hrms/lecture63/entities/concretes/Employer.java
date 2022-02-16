package hrms.lecture63.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
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
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employer extends User {
	

	@Column(name = "sirket_adi")
	@NotNull
	@NotBlank
	private String sirketAdi;
	
	@Column(name = "sirket_website")
	@NotNull
	@NotBlank
	private String sirketWebsite;
	
	@Column(name = "telefon_no")
	@NotNull
	@NotBlank
	private String telefonNo;

	@JsonIgnoreProperties(value = {"employer"})
	@OneToMany(mappedBy = "employer" )//, cascade = CascadeType.ALL, orphanRemoval = true
	private List<JobAdvertisement> jobAdvertisements;
	
	
	@Column(name = "verification_from_system_employee")
	private boolean verificationFromSystemEmployee;

	

	

	
	
	

}
