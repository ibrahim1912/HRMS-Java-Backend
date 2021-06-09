package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertiseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertiseDao;
import kodlamaio.hrms.entities.concretes.JobAdvertise;


@Service
public class JobAdvertiseManager implements JobAdvertiseService {

	private JobAdvertiseDao jobAdvertiseDao;

	@Autowired
	public JobAdvertiseManager(JobAdvertiseDao jobAdvertisetDao) {
		super();
		this.jobAdvertiseDao = jobAdvertisetDao;
	}

	@Override
	public Result add(JobAdvertise jobAdvertise) {
		jobAdvertise.setReleaseDate(LocalDateTime.now());
		this.jobAdvertiseDao.save(jobAdvertise);
		return new SuccessResult("Data eklendi");
	}

	@Override
	public DataResult<List<JobAdvertise>> getAll() {
	return new SuccessDataResult<List<JobAdvertise>>(this.jobAdvertiseDao.findAll(),"Data listendi");	
	}

	@Override
	public DataResult<List<JobAdvertise>> getAllActiveJobAdvertiseByEmployer(int id) {
		return new SuccessDataResult<List<JobAdvertise>>(this.jobAdvertiseDao.getAllActiveJobAdvertiseByEmployer(id));
	}

	
	@Override
	public DataResult<List<JobAdvertise>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertise>>(this.jobAdvertiseDao.getByIsActiveTrue(),"Data aktif");
	}
//	
//	@Override
//	public DataResult<List<JobAdvertise>> getByEmployerId(int id) {
//		return new SuccessDataResult<List<JobAdvertise>>(this.jobAdvertiseDao.getByEmployerId(id),"Okay");
//	}


	@Override
	public DataResult<JobAdvertise> changeStatus(int employerId, int jobAdvertiseId, boolean status) {
		List<JobAdvertise> jobAdvertises = this.jobAdvertiseDao.getByEmployerId(employerId);
		
		for (JobAdvertise jobAdvertise : jobAdvertises) {
			if (jobAdvertiseId == jobAdvertise.getId()) {
				jobAdvertise.setActive(status);
				this.jobAdvertiseDao.save(jobAdvertise);
				return new SuccessDataResult<JobAdvertise>(this.jobAdvertiseDao.getById(jobAdvertiseId));
			}
		}
		
		return new ErrorDataResult<JobAdvertise>();	
	}

	@Override
	public DataResult<List<JobAdvertise>> getAllByOrderByReleaseDate() {
		return new SuccessDataResult<List<JobAdvertise>>(this.jobAdvertiseDao.getAllByOrderByReleaseDateDesc());
	}
	
	@Override
	public DataResult<List<JobAdvertise>> getAllByOrderByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertise>>(this.jobAdvertiseDao.getAllByOrderByApplicationDeadlineDesc());
	}

	
}
