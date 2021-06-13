package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeeker"})

public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "school_name")
	@NotNull
	@NotBlank
	private String schoolName;

	@Column(name = "department")
	@NotNull
	@NotBlank
	private String department;

	@Column(name = "start_date")
	@NotNull
	private LocalDate startDate;

	@Column(name = "graduation_date")
	private LocalDate graduationDate;

	//@JsonIgnoreProperties({ "birthYear", "identityNumber", "email","password" })
	@ManyToOne()
	@JoinColumn(name = "jobSeeker_id")
	private JobSeeker jobSeeker;

}
