package com.imgglobalinfotech.fees.management.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.imgglobalinfotech.fees.management.entity.CourseName;

@Component
public interface CourseService {
	
	public CourseName saveall(CourseName cn);
 
	public List<CourseName> viewall();

	public void deletebyId(int id);

	public CourseName update(CourseName cn);

	public Boolean checkCourseName(String str, int adminId);

	public List<CourseName> getByAdminId(int id);

	public List<CourseName> getBySubject(String sub);

	public int deleteById(int id);

	public int deleteBySub(String sub);

	public Boolean checkCourseName(String coursename);

}
