package kodlamaio.hrms.core.adapters;


import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public interface UserValidationService {

	boolean validation (JobSeeker jobSeeker);
	public boolean fakeValidation(JobSeeker jobSeeker);
}
