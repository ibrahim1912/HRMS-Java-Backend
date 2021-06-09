package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_advertises")
public class JobAdvertise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
	@Column(name = "min_salary")
	private int minSalary;

	
	@Column(name = "max_salary")
	private int maxSalary;

	@NotBlank
	@Column(name = "job_description")
	private String jobDescription;

	
	//@Pattern(regexp = "[0-9]", message = "Please write a number")
	@Column(name = "number_of_open_position")
	private int numberOfOpenPosition;

    
	@Column(name = "is_active")
	private boolean isActive;
  

	
	@Column(name = "application_deadline")  //"2021-04-14"
	private LocalDate applicationDeadline;

	
    @Column(name = "release_date")
  	private LocalDateTime releaseDate;
    

	@JsonIgnoreProperties({ "website", "phoneNumber", "email",
	"password" })
	@ManyToOne() 
	@JoinColumn(name = "employer_id")
	private Employer employer;

	//@JsonIgnoreProperties({ "id" })
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	//@JsonIgnoreProperties({ "id" })
	@ManyToOne()
	@JoinColumn(name = "jobposition_id")
	private Jobposition jobposition;
}