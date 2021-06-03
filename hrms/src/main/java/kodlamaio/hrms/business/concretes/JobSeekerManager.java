package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.adapters.UserValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserValidationService validationService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserValidationService validationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.validationService = validationService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if (this.validationService.fakeValidation(jobSeeker)) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Kayıt oluşturuldu");
		}
		return new ErrorResult("Islem basarisiz");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Data listelendi");
	}

}
