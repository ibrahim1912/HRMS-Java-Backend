package kodlamaio.hrms.entities.concretes;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "denemes")

public class Deneme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "name", nullable = false)
	@NotBlank
	private String name;

//	@JsonIgnoreProperties({ "user_id", "website", "phone_number", "email", "password" })
//	@ManyToOne()
//	@JoinColumn(name = "employer_id")
//	private Employer employer;

//	@JsonIgnoreProperties({ "id" })
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	//@JsonIgnoreProperties({ "id" })
	@ManyToOne()
	@JoinColumn(name = "jobposition_id")
	private Jobposition jobposition;
}
