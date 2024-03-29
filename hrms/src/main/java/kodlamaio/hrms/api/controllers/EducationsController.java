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

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {

	
	private EducationService educationService;

	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Education education) {
		return ResponseEntity.ok( this.educationService.add(education));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok( this.educationService.getAll());
	}

	
	@GetMapping("/getAllByJobseekerIdOrderByGraduationDateDesc")
	public ResponseEntity<?> getAllByJobseekerIdOrderByGraduationDateDesc(int jobSeekerId) {
		return ResponseEntity.ok( this.educationService.getAllByJobSeekerIdOrderByGraduationDateDesc(jobSeekerId));
	}
	
	@GetMapping("/getAllByJobseekerId")
	public ResponseEntity<?> getAllByJobseekerId(int id) {
		return ResponseEntity.ok( this.educationService.getAllByJobSeekerId(id));
	}
	
//	@GetMapping("/getDESCOrderByGraduationDate")
//	public ResponseEntity<?> getDESCOrderByGraduationDate(int jobSeekerId){
//		return ResponseEntity.ok(this.educationService.getByJobSeekerIdOrderByGraduationDateDESC(jobSeekerId));
//	}
//	
	
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
