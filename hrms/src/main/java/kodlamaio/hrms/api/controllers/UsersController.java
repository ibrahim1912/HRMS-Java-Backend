package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	@GetMapping(value = "/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.userService.getAll());
	}
	
	@GetMapping(value = "/getbyemail")
	public ResponseEntity<?> findByEmail(String email){
		return ResponseEntity.ok(this.userService.findByEmail(email));
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

