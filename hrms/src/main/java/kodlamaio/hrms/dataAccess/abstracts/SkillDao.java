package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Skill;



public interface SkillDao extends JpaRepository<Skill,Integer> {
	
	Skill getById(int id);
	List<Skill> getByJobSeekerId(int jobSeekerId);
}
