package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobDao jobDao;

	@Autowired
	public JobPositionManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(this.jobDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		this.jobDao.save(jobPosition);
		return new SuccessResult("Data eklendi");

	}

	@Override
	public DataResult<List<JobPosition>> findOneByPositionName(String positionName) {
		return new SuccessDataResult<List<JobPosition>>(this.jobDao.findOneByPositionName(positionName));
	}

}
