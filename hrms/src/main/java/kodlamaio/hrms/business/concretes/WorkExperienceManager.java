package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService {

	private WorkExperienceDao workExperienceDao;

	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public Result add(WorkExperience workExperience) {
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("Data eklendi");
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(), "Data listelendi");
	}

	@Override
	public DataResult<List<WorkExperience>> getAllByJobSeekerIdOrderByDateOfEndDesc(int id) {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.getAllByJobSeekerIdOrderByDateOfEndDesc(id));
	}

	@Override
	public DataResult<List<WorkExperience>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.getAllByJobSeekerId(id));
	}

}
