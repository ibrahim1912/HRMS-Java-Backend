package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import kodlamaio.hrms.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "job_seekers")

public class JobSeeker extends User {

	@Column(name = "first_name", length = 25, nullable = false)
	@NotBlank

	private String firstName;

	@Column(name = "last_name", length = 25, nullable = false)
	@NotBlank

	private String lastName;

	@Column(name = "identity_number", length = 11, unique = true, nullable = false)
	@NotBlank

	@Pattern(regexp="[0-9]{11}",message="length must be 11")
	private String identityNumber;

	@Column(name = "birth_year", length = 4, nullable = false)
	@NotBlank
	@Pattern(regexp = "[0-9]{4}",message="length must be 4")
	private String birthYear;

	public JobSeeker(String email, String password,  String firstName,
			String lastName,  String identityNumber,
			 String birthYear) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthYear = birthYear;
	}

	

}