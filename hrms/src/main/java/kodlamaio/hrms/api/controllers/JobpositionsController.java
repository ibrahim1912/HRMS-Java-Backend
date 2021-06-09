package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.JobpositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobposition;


@RestController
@RequestMapping("/api/job-positions")

public class JobpositionsController {

	private JobpositionService jobpositionService;

	@Autowired
	public JobpositionsController(JobpositionService jobpositionService) {
		super();
		this.jobpositionService = jobpositionService;
	}

	@GetMapping("/getall")
	public DataResult<List<Jobposition>> getAll() {
		return this.jobpositionService.getAll();
		
	}

	@PostMapping("/add")
	public Result add(@RequestBody Jobposition jobPosition) {
		return this.jobpositionService.add(jobPosition);
	}

	@GetMapping("/findbypositionname")
	public DataResult<List<Jobposition>> findOneByPositionName(String positionName) {
		return this.jobpositionService.findOneByPositionName(positionName);
	}
}
