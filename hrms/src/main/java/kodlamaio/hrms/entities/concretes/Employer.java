package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import kodlamaio.hrms.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employers")

public class Employer extends User {

	@Column(name = "company_name",length = 25,nullable = false)
	@NotBlank
	private String companyName;
	
	@Column(name = "website",length = 25,nullable = false)
	@NotBlank()
	private String website;
	
	@Column(name = "phone_number",length = 10, nullable = false)
	@NotBlank
	@NotEmpty
	@Pattern(regexp = "[0-9\\\\s]{10}",message="length must be 10")
	private String phoneNumber;
	
	public Employer(String email,String password, String companyName, String website, String phoneNumber) {
		super(email,password);
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}
}
