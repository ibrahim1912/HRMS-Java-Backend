package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	
	Result add(CoverLetter coverLetter);
	DataResult<List<CoverLetter>> getAll();
	DataResult<List<CoverLetter>> getByJobSeekerId(int jobSeekerId);
}
