package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.adapters.UserValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/job-seekers")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;


	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok( this.jobSeekerService.getAll());
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
		return ResponseEntity.ok( this.jobSeekerService.add(jobSeeker));
	}
	
	@GetMapping("/getresume")
	public ResponseEntity<?> getResume(int id){
		return ResponseEntity.ok( this.jobSeekerService.getResumeByJobSeekerId(id));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)   //sistemde şu türden bir hata olursa MethodArgumentNotValidException
	@ResponseStatus(HttpStatus.BAD_REQUEST)                          //bad request olarak sarmalla
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();   // hash map yani dictionary oluştur
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {  //bütün hataları gez o dictionary i ekle 
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors                                            //errordataresult ın içine koy
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;                                                            //ve bu hataları döndür
	}
}
