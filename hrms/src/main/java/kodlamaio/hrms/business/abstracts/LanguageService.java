package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface LanguageService {

	Result add(Language language);
	DataResult<List<Language>> getAll();
	DataResult<List<Language>> getByJobSeekerId(int jobSeekerId);
	//DataResult<Language> getById(int id);	
}
