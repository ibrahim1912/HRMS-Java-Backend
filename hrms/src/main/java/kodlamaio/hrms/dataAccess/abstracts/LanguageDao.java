package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	
	Language getById(int id);
	List<Language> getByJobSeekerId(int jobSeekerId);
}
