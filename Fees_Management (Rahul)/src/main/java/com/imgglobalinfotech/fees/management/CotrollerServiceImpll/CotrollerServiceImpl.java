package com.imgglobalinfotech.fees.management.CotrollerServiceImpll;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imgglobalinfotech.fees.management.entity.Masteradmin;
import com.imgglobalinfotech.fees.management.exception.ResourceNotFoundExceptions;
import com.imgglobalinfotech.fees.management.payload.Update;
import com.imgglobalinfotech.fees.management.repository.Repo;
import com.imgglobalinfotech.fees.management.service.CotrollerService;

@Service
public class CotrollerServiceImpl implements CotrollerService {

	@Autowired
	private Repo repo;

	@Autowired
	private Update update;

//	@Autowired
//	private CotrollerService ctrsrv;

	@Override
	public Masteradmin saveDetails(Masteradmin ma) {
		Masteradmin rtn = repo.save(ma);
		return rtn;
		
//		Boolean b = ctrsrv.existsByUsername(ma.getUsername());
//		if (b == false) {
//			Masteradmin rtn = repo.save(ma);
//			System.err.println("yes");
//			return rtn;
//			
//		}
//		System.err.println("NO");
//		return null;
	} 

	@Override
	public List<Masteradmin> viewAllDetails() {
		System.err.println("YES 1");
//		List<Masteradmin> rtn = repo.findAll();
		List<Masteradmin> rtn= repo.findAll();
		System.err.println("YES");
		
		return rtn;
//		return null;
	}

	@Override
	public Masteradmin viewById(int id) {
		Masteradmin rtn = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceptions("Category", "category id", id));
		return rtn;
	}

	@Override
	public Masteradmin UpDate(Masteradmin ma) {
		Masteradmin x = this.viewById(ma.getId());
		if (x != null) {
//			System.err.println(ma.getActive()+"********");
			Masteradmin rtn = update.UpDate(ma, x);
//			System.err.println(x.getActive()+"********");
			Masteradmin rtnn = this.saveDetails(rtn);
			return rtnn;
		} else {
			System.err.println("wrong id please check again");
			return null;
		}

	}

	@Override
	public void deleteById(int id) {

		Masteradmin x = this.viewById(id);
		if (x != null) {
			repo.deleteById(id);
		}

	}

	@Override
	public Boolean existsByUsernameAndPassword(@Valid Masteradmin ma) {
		return repo.existsByUsernameAndPassword(ma.getUsername(), ma.getPassword());
	}

	@Override
	public Boolean existsByUsername(String username) {
		return repo.existsByUsername(username);
//		return null;
	}

	@Override
	public Masteradmin findByUsername(String username) {
		return repo.findByUsername(username);
//		return null;
	}

	@Override
	public Masteradmin getByChoingName(String name) {
		Masteradmin rtn = repo.findByChoingname(name);
		return rtn;
	}

}
