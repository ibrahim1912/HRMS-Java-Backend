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

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/links")
@CrossOrigin
public class LinksController {

	private LinkService linkService;

	@Autowired
	public LinksController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody Link link) {
		return ResponseEntity.ok(this.linkService.add(link));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.linkService.getAll());
	}

	@GetMapping("/getByJobSeeker")
	public ResponseEntity<?> getByJobSeekerId(int jobSeekerId) {
		return ResponseEntity.ok(this.linkService.getByJobSeekerId(jobSeekerId));
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
