package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertiseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertise;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@CrossOrigin
@RestController
@RequestMapping("/api/job-advertises")
public class JobAdvertisesController {

	private JobAdvertiseService jobAdvertiseService;

	@Autowired
	public JobAdvertisesController(JobAdvertiseService jobAdvertiseService) {
		super();
		this.jobAdvertiseService = jobAdvertiseService;
	}

	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertise jobAdvertise) {
		return ResponseEntity.ok(this.jobAdvertiseService.add(jobAdvertise));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobAdvertiseService.getAll());
	}
	
	@GetMapping("/get-all-active-job-advertise-by-employer")
	public ResponseEntity<?>getAllActiveJobAdvertiseByEmployer(@RequestParam int id){
		return ResponseEntity.ok(this.jobAdvertiseService.getAllActiveJobAdvertiseByEmployer(id));
	}

	@GetMapping("/getByActive")
	public ResponseEntity<?> getByIsActiveTrue() {
		return ResponseEntity.ok(this.jobAdvertiseService.getByIsActiveTrue());
	}



	@GetMapping("/changeStatus")
	public ResponseEntity<?> changeStatus(@RequestParam int employerId, @RequestParam int announcementId,
			@RequestParam boolean status) {
		return ResponseEntity.ok(this.jobAdvertiseService.changeStatus(employerId, announcementId, status));
	}
	
	@GetMapping("/getAllByOrderByReleaseDate")
	public ResponseEntity<?> getAllByOrderByReleaseDate() {
		return ResponseEntity.ok(this.jobAdvertiseService.getAllByOrderByReleaseDate());
	}
	
	@GetMapping("/getAllByOrderByApplicationDeadline")
	public ResponseEntity<?> getAllByOrderByApplicationDeadline() {
		return ResponseEntity.ok(this.jobAdvertiseService.getAllByOrderByApplicationDeadline());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)

	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {

			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
	}
	
}
