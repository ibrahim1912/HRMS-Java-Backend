package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.ResumeDto;

public interface JobSeekerService {

	Result add(JobSeeker jobSeeker);
	
	DataResult<List<JobSeeker>> getAll();
	
	DataResult<ResumeDto> getResumeByJobSeekerId(int jobSeekerId);
	
	DataResult<JobSeeker> getById(int id);
}
