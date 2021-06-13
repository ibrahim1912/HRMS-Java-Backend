package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	@Pattern(regexp = "[0-9]{11}", message = "length must be 11")
	private String identityNumber;

	@Column(name = "birth_year", length = 4, nullable = false)
	@NotBlank
	@Pattern(regexp = "[0-9]{4}", message = "length must be 4")
	private String birthYear;

	public JobSeeker(String email, String password, String firstName, String lastName, String identityNumber,
			String birthYear) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthYear = birthYear;
	}

	@OneToMany(mappedBy = "jobSeeker")
	//@JsonIgnore()
	private List<WorkExperience> workExperiences;

	@OneToMany(mappedBy = "jobSeeker")
	//@JsonIgnore()
	private List<Education> educations;

	@OneToMany(mappedBy = "jobSeeker")
	//@JsonIgnore()
	private List<Language> languages;

	@OneToMany(mappedBy = "jobSeeker")
	//@JsonIgnore()
	private List<Skill> skills;

	@OneToMany(mappedBy = "jobSeeker")
	//@JsonIgnore()
	private List<Link> links;
	
	@OneToMany(mappedBy = "jobSeeker")
	//@JsonIgnore()
	private List<CoverLetter> coverLetters;
	
	@OneToMany(mappedBy = "jobSeeker")
	//@JsonIgnore()
	private List<Image> images;

}