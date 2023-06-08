package com.imgglobalinfotech.fees.management.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService
{

	@Autowired
	private CotrollerService ctrsrv;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		if(userName.equals("Durgesh"))
		{
			return new User("Durgesh","Durgesh@123",new ArrayList<>());
		}else
		{
			throw new UsernameNotFoundException("user not found");
		}
	}
	
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////		public void 
//		
//		Masteradmin ma = ctrsrv.findByUsername(username);
//		
//		if(username.equals(ma.getUsername()))
//		{
//			return new User(ma.getUsername(),ma.getPassword(),new ArrayList<>());
//		}else
//		{
//			throw new UsernameNotFoundException("user not found");
//		}
//	}

	
	
	
	
	
	

}
