package com.imgglobalinfotech.fees.management.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class ApiResponse 
{
	private String umessage;
	private String message;
	private boolean success;

}
