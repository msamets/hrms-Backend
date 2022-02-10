package hrms.lecture63.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//lombok
@Entity//bu class ın bir entity classı olduğunu belirtiyoruz
@Table(name="users")//veritabanında hangi tabloya denk geldiğini belirtiyoruz
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class User {
	
	@Id//bu class ın idsinin bu olduğunu belirtiyoruz
	@GeneratedValue(strategy = GenerationType.IDENTITY)//idnin nasıl belirlendiği
	@Column(name = "id")//hangi kolona denk geldiği
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	

	@Column(name = "email_verification")
	private boolean emailVerification;

	
	
}
