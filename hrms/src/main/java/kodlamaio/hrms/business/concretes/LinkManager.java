package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkDao;
import kodlamaio.hrms.entities.concretes.Link;
import net.bytebuddy.asm.Advice.This;

@Service
public class LinkManager implements LinkService{

	private LinkDao linkDao;
	
	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Data eklendi");
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAll());
	}

	@Override
	public DataResult<List<Link>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getByJobSeekerId(jobSeekerId));
	}

}
