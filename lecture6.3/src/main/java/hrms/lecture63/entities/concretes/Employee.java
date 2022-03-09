package hrms.lecture63.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity

@EqualsAndHashCode(callSuper = false)
@Table(name = "employees")
//@DiscriminatorValue("Employee")            it is for hibernate inheritance one table strategy
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee extends User {
	
	@Column(name = "first_name", nullable = false)
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name = "last_name" ,nullable = false)
	@NotNull
	@NotBlank
	private String lastName;

}
