package com.imgglobalinfotech.fees.management.CotrollerServiceImpll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imgglobalinfotech.fees.management.entity.CourseName;
import com.imgglobalinfotech.fees.management.repository.CourseRepo;
import com.imgglobalinfotech.fees.management.service.CourseService;

@Service
public class CourseserviceImpl implements CourseService {

	@Autowired
	private CourseRepo cr;

	@Override
	public CourseName saveall(CourseName cn) {
		CourseName rtn = cr.save(cn);
		return rtn;
	}

	@Override
	public List<CourseName> viewall() {
		List<CourseName> rtn = cr.findAll();
		return rtn;
	}

	@Override
	public void deletebyId(int id) {
//		Optional<CourseName> obj = cr.findById(id);
//		CourseName ob = obj.get();
//		int adminId = ob.getAdminid();
		cr.deleteById(id);
	}

	@Override
	public CourseName update(CourseName cn) {
		Optional<CourseName> obj = cr.findById(cn.getId());
		CourseName ob = obj.get();
		if (ob != null) {
			ob.setAdminid(cn.getAdminid());
			ob.setCoursename(cn.getCoursename());
			CourseName rtn = cr.save(ob);
			return rtn;
		} else {
			return null;
		}

	}

	@Override
	public Boolean checkCourseName(String str, int adminId) {
		Boolean rtn = cr.existsByCoursenameAndAdminid(str, adminId);
		return rtn;
	}

	@Override
	public List<CourseName> getByAdminId(int id) {
		
		List<CourseName> rtn = cr.getByAdminId(id);
		return rtn;
	}

	@Override
	public List<CourseName> getBySubject(String sub) {
		List<CourseName> rtn = cr.getBySubject(sub);
		return rtn;
	}

	@Override
	public int deleteById(int id) {
		int x =  cr.deleteeById(id);
		return x;
	}

	@Override
	public int deleteBySub(String sub) {
		int x =  cr.deleteeBySub(sub);
		return x;
	}

	@Override
	public Boolean checkCourseName(String coursename) {
		Boolean rtn = cr.existsByCoursename(coursename);
		return rtn;
	}
}
