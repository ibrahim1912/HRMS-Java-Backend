package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;



import kodlamaio.hrms.entities.concretes.Jobposition;

public interface JobpositionDao extends JpaRepository<Jobposition, Integer> {

	List<Jobposition> findOneByPositionName(String positionName);
}
