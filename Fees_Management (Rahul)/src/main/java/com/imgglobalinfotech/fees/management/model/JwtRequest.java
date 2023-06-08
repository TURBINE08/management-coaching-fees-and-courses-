package com.imgglobalinfotech.fees.management.model;

public class JwtRequest 
{
 String username;
 String password;
 
 
 public JwtRequest()
 {
	 
 }
 
 public JwtRequest(String username, String password)
 {
	 this.username = username;
	 this.password = password;
 }

public String getUsername() {
	
	System.err.println("*****1******");
	return username;
}

public void setUsername(String username) {
	System.err.println("*****2******");
	this.username = username;
}

public String getPassword() {
	System.err.println("*****3******");
	return password;
}

public void setPassword(String password) {
	System.err.println("*****4******");
	this.password = password;
}
 
 @Override
public String toString()
{
return "JwtRequest{" +
			"username'=" + username+'\''+
			",password='"+password+'\''+
			'}';
}

}
