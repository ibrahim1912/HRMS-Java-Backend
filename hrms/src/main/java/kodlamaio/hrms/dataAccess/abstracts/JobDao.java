package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;



import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobDao extends JpaRepository<JobPosition, Integer> {

	List<JobPosition> findOneByPositionName(String positionName);
}
