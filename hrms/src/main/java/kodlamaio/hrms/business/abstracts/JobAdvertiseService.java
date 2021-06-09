package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertise;

public interface JobAdvertiseService {

	Result add(JobAdvertise jobAdvertise);
	DataResult<List<JobAdvertise>> getAll();
	DataResult<List<JobAdvertise>> getByIsActiveTrue();
	//DataResult<List<JobAdvertise>> getByEmployerId(int id);
	DataResult<JobAdvertise> changeStatus(int employerId,int advertiseId, boolean status);
	
	DataResult<List<JobAdvertise>> getAllActiveJobAdvertiseByEmployer(int id);
	
	DataResult<List<JobAdvertise>> getAllByOrderByReleaseDate();
	
	DataResult<List<JobAdvertise>> getAllByOrderByApplicationDeadline();
	
	
	
}
