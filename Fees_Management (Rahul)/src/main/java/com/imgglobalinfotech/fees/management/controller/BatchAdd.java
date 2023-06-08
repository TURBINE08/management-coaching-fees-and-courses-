package com.imgglobalinfotech.fees.management.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imgglobalinfotech.fees.management.entity.Batch;
import com.imgglobalinfotech.fees.management.service.BatchService;
import com.imgglobalinfotech.fees.management.service.CourseService;

@RestController
public class BatchAdd {

	@Autowired
	private BatchService bs;

	@Autowired
	private CourseService cs;

	@PostMapping("/batch/save")
	public ResponseEntity<?> savebatch(@Valid @RequestBody Batch bch) {

		Boolean x = cs.checkCourseName(bch.getCoursename(), bch.getAdminid());
		if (x) {
			Batch rtn = bs.save(bch);
			return new ResponseEntity<>(rtn, HttpStatus.CREATED);
		} else {
			String str = "invalid input data";
			return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/batch/viewAll")
	public ResponseEntity<?> viewall() {
		List<Batch> rtn = bs.viewAll();
		return new ResponseEntity<>(rtn, HttpStatus.FOUND);
	}

	@GetMapping("/batch/viewById/{id}")
	public ResponseEntity<?> viewById(@PathVariable int id) {
		Optional<Batch> rtn = bs.viewById(id);
		Batch rtn1 = rtn.get();
		return new ResponseEntity<>(rtn, HttpStatus.FOUND);
	}

	@PutMapping("/update/batch")
	public ResponseEntity<?> update(@Valid @RequestBody Batch bth) {
		Optional<Batch> rtn1 = bs.viewById(bth.getId());
		Batch obj = rtn1.get();
		if (obj != null) {
			Batch rtn = bs.update(bth);
			return new ResponseEntity<>(rtn, HttpStatus.CREATED);
		} else {
			String str = "invalid coaching id";
			return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/batch/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		bs.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/batch/viewByCohingId/{id}")
	public ResponseEntity<?> viewByCohingId(@PathVariable int id) {
		List<Batch> rtn = bs.viewByCohingId(id);
		Batch rtn1 = rtn.get(id);
		return new ResponseEntity<>(rtn, HttpStatus.FOUND);
	}

}
