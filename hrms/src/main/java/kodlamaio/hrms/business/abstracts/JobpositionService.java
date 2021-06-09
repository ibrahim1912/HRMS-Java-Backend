package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobposition;


public interface JobpositionService {

	Result add(Jobposition jobposition);

	DataResult<List<Jobposition>> getAll();

	DataResult<List<Jobposition>> findOneByPositionName(String positionName);
}
