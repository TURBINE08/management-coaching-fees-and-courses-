package com.imgglobalinfotech.fees.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.imgglobalinfotech.fees.management.entity.Batch;

@Component
public interface BatchService {

	Batch save(Batch bch);

	List<Batch> viewAll();

	Optional<Batch> viewById(int id);

	Batch update(Batch bth);

	void delete(int id);

	List<Batch> viewByCohingId(int id);

	List<Batch> getByIdAndCourse(Integer adminid, String coursename);



}
