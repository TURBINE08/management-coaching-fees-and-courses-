package com.imgglobalinfotech.fees.management.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.imgglobalinfotech.fees.management.entity.CourseName;


public interface CourseRepo extends JpaRepository<CourseName, Integer>{

	Boolean existsByCoursenameAndAdminid(String str, int AdminId);

	
	@Query(value = "select * from coaching_admin u where u.admin_id=:adminid", nativeQuery=true)
	List<CourseName> getByAdminId(@Param("adminid") int adminid);


	@Query(value = "select * from coaching_admin u where u.courses_name=:sub", nativeQuery=true)
	List<CourseName> getBySubject(@Param("sub") String sub);


	@Query(value="delete from coaching_admin u where u.admin_id=:id", nativeQuery=true)
	@Modifying
	@Transactional
	int deleteeById(@Param("id") int id);

	@Query(value="delete from coaching_admin u where u.courses_name=:sub", nativeQuery=true)
	@Modifying
	@Transactional
	int deleteeBySub(@Param("sub")String sub);


	Boolean existsByCoursename(String coursename);
	

	
	

}
