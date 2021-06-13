package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
//import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Education;
//import org.springframework.stereotype.Repository;

//@Repository
public interface EducationDao extends JpaRepository<Education, Integer> {
	
	Education getById(int id);
	List<Education> getAllByJobSeekerIdOrderByGraduationDateDesc(int id);
	List<Education> getAllByJobSeekerId(int id);
	//List<Education> getByJobSeekerId(Sort sort, int jobSeekerId);
}
