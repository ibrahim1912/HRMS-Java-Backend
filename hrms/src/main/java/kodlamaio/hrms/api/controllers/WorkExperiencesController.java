package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/jobExperiences")
@CrossOrigin
public class WorkExperiencesController {

	
	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody WorkExperience workExperience) {
		return ResponseEntity.ok( this.workExperienceService.add(workExperience));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok( this.workExperienceService.getAll());
	}

	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public ResponseEntity<?> getAllByJobseekerIdOrderByDateOfEndDesc(int id) {
		return ResponseEntity.ok( this.workExperienceService.getAllByJobSeekerIdOrderByDateOfEndDesc(id));
	}
	
	@GetMapping("/getAllByJobseekerId")
	public ResponseEntity<?> getAllByJobSeekerId(int id) {
		return ResponseEntity.ok( this.workExperienceService.getAllByJobSeekerId(id));
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)   
	@ResponseStatus(HttpStatus.BAD_REQUEST)                         
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();   
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) { 
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors                                            
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;                                                            
	}
}



