package com.imgglobalinfotech.fees.management.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundExceptions extends RuntimeException
{
	String resourceName;
	String FieldName;
	Integer fieldValue;
	public ResourceNotFoundExceptions(String resourceName, String fieldName, Integer Id) 
	{
		super(String.format("%s is not exist with name %s : %s", resourceName, fieldName,Id));
		this.resourceName = resourceName;
		this.FieldName = fieldName;
		this.fieldValue = Id;
		
	}
}
