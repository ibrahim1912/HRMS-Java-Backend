package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_positions")

public class JobPosition {
	@Id//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//otomatik artan
	@Column(name = "id")
	private int id;
	
	@Column(name = "position_name")
	private String positionName;
	
}
