package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;

public interface LinkService {

	Result add(Link link);
	DataResult<List<Link>> getAll();
	DataResult<List<Link>> getByJobSeekerId(int jobSeekerId);
}
