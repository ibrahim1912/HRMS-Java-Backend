package kodlamaio.hrms.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kodlamaio.hrms.core.validations.ValidPassword;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "id")
	private int id;
	
	

	@Column(name = "email",nullable = true,unique = true)
	@Email
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name = "password", nullable = true)
	@NotBlank
	@NotNull
	@ValidPassword
	private String password;
	
	public User(  String email, String password) {
		
		this.email = email;
		this.password = password;
	}
	
}
