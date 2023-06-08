package com.imgglobalinfotech.fees.management.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.imgglobalinfotech.fees.management.entity.CourseName;
import com.imgglobalinfotech.fees.management.entity.Masteradmin;
import com.imgglobalinfotech.fees.management.service.CotrollerService;
import com.imgglobalinfotech.fees.management.service.CourseService;

@RestController
public class CochingAdmin {
	@Autowired
	private CourseService cs;

	@Autowired
	private CotrollerService ctrsrv;

	@PostMapping("/save/course")
	public ResponseEntity<?> save(@Valid @RequestBody CourseName cn) {
		int x = cn.getAdminid();
		Masteradmin ob = ctrsrv.viewById(x);
		if (ob != null) {
			System.err.println("****not null******");
			CourseName rtn = cs.saveall(cn);
			return new ResponseEntity<>(rtn, HttpStatus.CREATED);
		} else {
			System.err.println("****null******");
			String str = "envalid masteradmin Id";
			return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllDetails")
	public ResponseEntity<?> viewall() {
		List<CourseName> rtn = cs.viewall();

		return new ResponseEntity<>(rtn, HttpStatus.FOUND);

	}

	@DeleteMapping("/deleteeById/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		cs.deletebyId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update/course")
	public ResponseEntity<?> update(@Valid @RequestBody CourseName cn) {
		int x = cn.getAdminid();
		Masteradmin ob = ctrsrv.viewById(x);
		if (ob.getId() != 0) {
			CourseName rtn = cs.update(cn);
			return new ResponseEntity<>(rtn, HttpStatus.ACCEPTED);
		} else {
			String str = "envalid masteradmin Id";
			return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getByAdminId/{id}")
	public ResponseEntity<?> getByAdminId(@PathVariable int id) {

		List<CourseName> rtn = cs.getByAdminId(id);
		CourseName rtn1 = rtn.get(id);
		return new ResponseEntity<>(rtn, HttpStatus.FOUND);
	}

	@GetMapping("/getBySubject/{sub}")
	public ResponseEntity<?> getBySubject(@PathVariable String sub) {
		List<CourseName> rtn = cs.getBySubject(sub);
		return new ResponseEntity<>(rtn, HttpStatus.FOUND);
	}

	@DeleteMapping("/deleteByAdminId/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		String Str;
		int x = 0;
		x = cs.deleteById(id);
		if (x > 0) {
			Str = x + " record deleted sucessfully";
		} else {
			Str = "no record found";
		}

		return new ResponseEntity<>(Str, HttpStatus.OK);
	}

	@DeleteMapping("/deleteByCourses/{sub}")
	public ResponseEntity<?> deleteBySub(@PathVariable String sub) {
		String Str;
		int x = 0;
		x = cs.deleteBySub(sub);
		if (x > 0) {
			Str = x + " record deleted sucessfully";
		} else {
			Str = "no record found";
		}

		return new ResponseEntity<>(Str, HttpStatus.OK);
	}

}
