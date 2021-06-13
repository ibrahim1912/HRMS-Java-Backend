package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer>{

	WorkExperience getById(int id);
	List<WorkExperience> getAllByJobSeekerIdOrderByDateOfEndDesc(int id);
	List<WorkExperience> getAllByJobSeekerId(int id);
}
