package com.imgglobalinfotech.fees.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.imgglobalinfotech.fees.management.entity.Masteradmin;
//@EnableJpaRepositories 
public interface Repo extends JpaRepository<Masteradmin, Integer>
{

//	List<Masteradmin> findAll();
	
	Boolean existsByUsernameAndPassword(String username, String password);

	Boolean existsByUsername(String username);

	Masteradmin findByUsername(String username);

	Masteradmin findByChoingname(String name);



}
 