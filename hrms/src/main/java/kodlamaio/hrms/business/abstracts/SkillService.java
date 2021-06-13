package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Skill;

public interface SkillService {

	Result add(Skill skill);
	//DataResult<ProgrammingSkillForCV> getById(int id);	
	DataResult<List<Skill>> getAll();
	DataResult<List<Skill>> getByJobSeekerId(int jobSeekerId);
}
