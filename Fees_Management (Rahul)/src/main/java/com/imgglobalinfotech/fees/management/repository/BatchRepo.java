package com.imgglobalinfotech.fees.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.imgglobalinfotech.fees.management.entity.Batch;
import com.imgglobalinfotech.fees.management.entity.CourseName;

public interface BatchRepo extends JpaRepository<Batch, Integer>{

	
	
	@Query(value = "select * from add_batch u where u.coaching_id=:sub", nativeQuery=true)
	List<Batch> viewByCohingId(@Param("sub")int sub);
	
	

	@Query(value = "select * from add_batch u where u.coaching_id=:adminid and course_name=:coursename", nativeQuery=true)
	List<Batch> getByIdAndCourse(@Param("adminid")Integer adminid, @Param("coursename")String coursename);
	
	
	

}
