package com.imgglobalinfotech.fees.management.CotrollerServiceImpll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imgglobalinfotech.fees.management.entity.Batch;
import com.imgglobalinfotech.fees.management.payload.UpdateBatch;
import com.imgglobalinfotech.fees.management.repository.BatchRepo;
import com.imgglobalinfotech.fees.management.service.BatchService;

@Service
public class BatchServiceImpl implements BatchService{

	@Autowired
	private BatchRepo brepo;
	
	@Autowired
	private UpdateBatch updatebatch;
	
	@Override
	public Batch save(Batch bch) { 
		
		Batch rtn = brepo.save(bch);
		return rtn; 
	}
 
	@Override
	public List<Batch> viewAll() {
		List<Batch> rtn = brepo.findAll();
		return rtn;
	}

	@Override
	public Optional<Batch> viewById(int id) {
		Optional<Batch> rtn = brepo.findById(id);
		return rtn;
	}

	@Override
	public Batch update(Batch bth) {
		Optional<Batch> b1 = brepo.findById(bth.getId());
		Batch ob = b1.get();
		Batch updated = updatebatch.getUpdate(bth, ob);
		Batch rtn = brepo.save(updated);
		return rtn;
	}

	@Override
	public void delete(int id) {
		brepo.deleteById(id);
	}

	@Override
	public List<Batch> viewByCohingId(int id) {
		List<Batch> rtn = brepo.viewByCohingId(id);
		return null;
	}

	@Override
	public List<Batch> getByIdAndCourse(Integer adminid, String coursename) {
		List<Batch> rtn = brepo.getByIdAndCourse(adminid, coursename);
		return rtn;
	}

	

}
