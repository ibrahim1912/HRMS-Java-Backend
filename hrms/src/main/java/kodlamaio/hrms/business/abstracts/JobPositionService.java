package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;


public interface JobPositionService {

	Result add(JobPosition jobPosition);

	DataResult<List<JobPosition>> getAll();

	DataResult<List<JobPosition>> findOneByPositionName(String positionName);
}
