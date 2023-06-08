package com.imgglobalinfotech.fees.management.payload;

import org.springframework.stereotype.Component;

import com.imgglobalinfotech.fees.management.entity.Batch;

@Component
public class UpdateBatch {

	public Batch getUpdate(Batch bth, Batch ob) {
		
		if(bth.getBatchName()!=null)
		{
			ob.setBatchName(bth.getBatchName());
		}
		else if(bth.getBatchStartDate()==null)
		{
			ob.setBatchStartDate(bth.getBatchStartDate());
		}
//		else if(bth.getCoursename()!=null)
//		{
//			ob.setCoursename(bth.getCoursename());
//		}
		else if(bth.getDuration()!=0)
		{
			ob.setDuration(bth.getDuration());
		}
		else if(bth.getFees()!=0)
		{
			ob.setFees(bth.getFees());
		}
//		else if(bth.getRenewalDate()!=null)
//		{
//			ob.setRenewalDate(bth.getRenewalDate());
//		}else if(bth.getAdminId()!=0)
//		{
//		ob.setAdminId(bth.getAdminId());
//	}
		return ob;
	}

}
