package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobpositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobpositionDao;
import kodlamaio.hrms.entities.concretes.Jobposition;

@Service
public class JobpositionManager implements JobpositionService {

	private JobpositionDao jobpositionDao;

	@Autowired
	public JobpositionManager(JobpositionDao jobpositionDao) {
		super();
		this.jobpositionDao = jobpositionDao;
	}

	@Override
	public DataResult<List<Jobposition>> getAll() {

		return new SuccessDataResult<List<Jobposition>>(this.jobpositionDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Jobposition jobposition) {
		this.jobpositionDao.save(jobposition);
		return new SuccessResult("Data eklendi");

	}

	@Override
	public DataResult<List<Jobposition>> findOneByPositionName(String positionName) {
		return new SuccessDataResult<List<Jobposition>>(this.jobpositionDao.findOneByPositionName(positionName));
	}

}
