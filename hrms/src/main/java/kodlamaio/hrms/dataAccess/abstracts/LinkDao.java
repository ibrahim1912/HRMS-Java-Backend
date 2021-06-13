package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Link;



public interface LinkDao extends JpaRepository<Link, Integer>{
	
	Link getById(int id);
	List<Link> getByJobSeekerId(int jobSeekerId);
	
}
