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
@Table(name = "work_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeeker"})
public class WorkExperience {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "workplace_name", nullable = true)
	@NotNull
	@NotBlank
	private String workplaceName;

	@Column(name = "position", nullable = true)
	@NotNull
	@NotBlank
	private String position;

	@Column(name = "date_of_start", nullable = true)
	@NotNull
	private LocalDate dateOfStart;

	@Column(name = "date_of_end")
	private LocalDate dateOfEnd;

	// @JsonIgnoreProperties({ "birthYear", "identityNumber", "email","password" })
	@ManyToOne()
	@JoinColumn(name = "jobSeeker_id", nullable = true)
	private JobSeeker jobSeeker;
}
