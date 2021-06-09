package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.JobAdvertise;

public interface JobAdvertiseDao extends JpaRepository<JobAdvertise, Integer> {


	List<JobAdvertise> getByIsActiveTrue();
	List<JobAdvertise> getByEmployerId(int id);

	
	@Query("From JobAdvertise where isActive = true and employer_id =:id")
	@JsonIgnoreProperties({ "id", "website", "phoneNumber", "email",
	 "password" })
	List<JobAdvertise> getAllActiveJobAdvertiseByEmployer(int id);
	
	@Query("From JobAdvertise where isActive = true Order By releaseDate Desc")
	List<JobAdvertise> getAllByOrderByReleaseDateDesc();
	
	
	@Query("From JobAdvertise where isActive = true Order By applicationDeadline Asc")
	List<JobAdvertise> getAllByOrderByApplicationDeadlineDesc();
}
