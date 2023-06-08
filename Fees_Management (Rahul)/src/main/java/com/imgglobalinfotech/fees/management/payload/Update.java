package com.imgglobalinfotech.fees.management.payload;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imgglobalinfotech.fees.management.entity.Masteradmin;
//import com.imgglobalinfotech.fees.management.service.CotrollerService;
@Component
public class Update {
	
//	@Autowired
//	private CotrollerService ctrsrv;
	
	
	public Masteradmin UpDate(Masteradmin ma, Masteradmin x) {
		 if(ma.getChoingname()!=null)
		 {
			 System.err.println("1");
			 x.setChoingname(ma.getChoingname());
		 }
		 if(ma.getAddress()!= null)
		 {
			 x.setAddress(ma.getAddress());
		 }
		 if(ma.getContactinfo()!=null)
		 {
			 x.setContactinfo(ma.getContactinfo());
		 }
		 if(ma.getPassword()!= null)
		 {
			x.setPassword(ma.getPassword()); 
		 }
		 if(ma.getUsername()!=null)
		 {
			 x.setUsername(ma.getUsername());
		 }
		 if(ma.getStartdate()!= null)
		 {
			x.setStartdate(ma.getStartdate()); 
		 }
		 if(ma.getRenewaldate()!= null)
		 {
			 x.setRenewaldate(ma.getRenewaldate());
		 }
		 if(ma.getEmail()!= null)
		 {
			 x.setEmail(ma.getEmail());
		 }
		 if(ma.getName()!=null)
		 {
			x.setName(ma.getName()); 
		 }
		 if(ma.getActive_or_inactive()!=false)
		 {
			 x.setActive_or_inactive(ma.getActive_or_inactive());
		 }
//		 if(ma.getActive()!=0)
//		 {
//			 x.setActive(ma.getActive());
//			 if(ma.getActive()==1)
//			 {
//				 x.setActiveOrNot("Actice");
//			 }else
//			 {
//				 x.setActiveOrNot("InActice");
//			 }
//		 }
		 
		 
		return x; 
	}



}
