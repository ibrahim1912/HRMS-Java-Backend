package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.adapters.UserValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.ResumeDto;
import net.bytebuddy.asm.Advice.This;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserValidationService validationService;
	// private ImageService imageService;
	private LanguageService languageService;
	private LinkService linkService;
	private SkillService skillService;
	private EducationService educationService;
	private WorkExperienceService workExperienceService;
	private CoverLetterService coverLetterService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserValidationService validationService,
			LanguageService languageService, LinkService linkService, SkillService skillService,
			EducationService educationService, WorkExperienceService workExperienceService,
			CoverLetterService coverLetterService

	) {
		super();
		this.validationService = validationService;
		this.jobSeekerDao = jobSeekerDao;
		this.languageService = languageService;
		this.linkService = linkService;
		this.skillService = skillService;
		this.educationService = educationService;
		this.workExperienceService = workExperienceService;
		this.coverLetterService = coverLetterService;
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

	@Override
	public DataResult<ResumeDto> getResumeByJobSeekerId(int jobSeekerId) {
		ResumeDto resume = new ResumeDto();
		resume.setJobSeeker(this.getById(jobSeekerId).getData());
		resume.setLanguages(this.languageService.getByJobSeekerId(jobSeekerId).getData());
		resume.setLinks(this.linkService.getByJobSeekerId(jobSeekerId).getData());
		resume.setSkills(this.skillService.getByJobSeekerId(jobSeekerId).getData());
		resume.setEducations(this.educationService.getAllByJobSeekerIdOrderByGraduationDateDesc(jobSeekerId).getData());
		resume.setWorkExperiences(this.workExperienceService.getAllByJobSeekerIdOrderByDateOfEndDesc(jobSeekerId).getData());
		resume.setCoverLetters(this.coverLetterService.getByJobSeekerId(jobSeekerId).getData());
		return new SuccessDataResult<>(resume, "Data listelendi.");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id));
	}

}
