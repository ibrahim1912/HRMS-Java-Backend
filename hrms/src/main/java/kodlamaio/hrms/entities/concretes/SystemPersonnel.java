package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import kodlamaio.hrms.core.entities.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "system_personnels")

public class SystemPersonnel extends User {

	@Column(name="first_name",length = 25,nullable = false)
	@NotBlank
	private String firstName;
	
	@Column(name="last_name",length = 25,nullable = false)
	@NotBlank

	private String lastName;
	
	

	public SystemPersonnel(String email,String password,String firstName, String lastName) {
		super(email,password);
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
}
