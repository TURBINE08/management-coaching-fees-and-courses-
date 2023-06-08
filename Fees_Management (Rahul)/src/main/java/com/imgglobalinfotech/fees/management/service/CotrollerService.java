package com.imgglobalinfotech.fees.management.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import com.imgglobalinfotech.fees.management.entity.Masteradmin;
@Component
public interface CotrollerService 
{
	public Masteradmin saveDetails(Masteradmin ma);

	public List<Masteradmin> viewAllDetails();

	public Masteradmin viewById(int id);

	public Masteradmin UpDate(Masteradmin ma);

	public void deleteById(int id);

	public Boolean existsByUsernameAndPassword(@Valid Masteradmin ma);

	public Boolean existsByUsername(String username);

	public Masteradmin findByUsername(String username);

	public Masteradmin getByChoingName(String name);


}


 