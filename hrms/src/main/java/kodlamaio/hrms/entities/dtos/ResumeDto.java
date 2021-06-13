package kodlamaio.hrms.entities.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResumeDto {
	
	@JsonIgnore()
	private JobSeeker jobSeeker;
	private List<Education> educations;
	private List<Language> languages;
	private List<WorkExperience> workExperiences;
	private List<Skill> skills;
	private List<Link> links;
	private List<CoverLetter> coverLetters;
	
}
