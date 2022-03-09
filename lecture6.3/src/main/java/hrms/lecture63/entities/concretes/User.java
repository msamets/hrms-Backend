package hrms.lecture63.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//lombok
@Entity//bu class ın bir entity classı olduğunu belirtiyoruz
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")//veritabanında hangi tabloya denk geldiğini belirtiyoruz
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
	
	@Id//bu class ın idsinin bu olduğunu belirtiyoruz
	@GeneratedValue(strategy = GenerationType.IDENTITY)//idnin nasıl belirlendiği
	@Column(name = "id")//hangi kolona denk geldiği
	private int id;
	
	@Column(name = "email", unique = true, nullable = false)
	@NotBlank
	@NotNull
	@Email
	private String email;
	
	@Column(name = "password", nullable = false)
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name = "email_verification")
	@NotNull
	private boolean emailVerification;
	
	
}
