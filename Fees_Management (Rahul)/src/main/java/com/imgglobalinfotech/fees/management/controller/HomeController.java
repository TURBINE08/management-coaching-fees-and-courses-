package com.imgglobalinfotech.fees.management.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imgglobalinfotech.fees.management.entity.Batch;
import com.imgglobalinfotech.fees.management.entity.CourseName;
import com.imgglobalinfotech.fees.management.entity.Masteradmin;
import com.imgglobalinfotech.fees.management.service.BatchService;
import com.imgglobalinfotech.fees.management.service.CotrollerService;
import com.imgglobalinfotech.fees.management.service.CourseService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private CotrollerService ctrsrv;

	@Autowired
	private CourseService cs;

	@Autowired
	private BatchService bs;

	@GetMapping("getDetailByChochingName/{name}")
	public ResponseEntity<?> getAllDetailsByCochingName(@PathVariable String name) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Masteradmin obj1 = ctrsrv.getByChoingName(name);
		map.put("MasterAdmin", obj1);
		List<CourseName> obj2 = cs.getByAdminId(obj1.getId());
		map.put("CourseName", obj2);
		int num = obj2.size();
		for (int i = 0; i < num; i++) {
			CourseName ob = obj2.get(i);
			List<Batch> Bob =  bs.getByIdAndCourse(ob.getAdminid(), ob.getCoursename());
			int num1 = Bob.size();
			System.out.println(num1+"   Batch");
			for (int j = 0; j < num1; j++) {
				Batch obj = Bob.get(j);
				map.put(obj.getCoursename(), Bob);
			}
		}
		return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getDetailByChochingid/{id}")
	public ResponseEntity<?> getAllDetailsByCochingId(@PathVariable int id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Masteradmin obj1 = ctrsrv.viewById(id);
		map.put("MasterAdmin", obj1);
		List<CourseName> obj2 = cs.getByAdminId(obj1.getId());
		CourseName rtn = obj2.get(obj1.getId());
		map.put(rtn.getCoursename(), obj2);
//		map.put("CourseName", obj2);
		int num = obj2.size();
		for (int i = 0; i < num; i++) {
			CourseName ob = obj2.get(i);
			List<Batch> Bob =  bs.getByIdAndCourse(ob.getAdminid(), ob.getCoursename());
			int num1 = Bob.size();
			System.out.println(num1+"   Batch");
			for (int j = 0; j < num1; j++) {
				Batch obj = Bob.get(j);
				map.put(obj.getCoursename(), Bob);
			}
		}
		return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
	}

}
