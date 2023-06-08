package com.imgglobalinfotech.fees.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imgglobalinfotech.fees.management.healper.JwtUtil;
import com.imgglobalinfotech.fees.management.model.JwtRequest;
import com.imgglobalinfotech.fees.management.model.JwtResponse;
import com.imgglobalinfotech.fees.management.service.CustomUserDetailsService;

@RestController
public class JwtController 
{
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private  CustomUserDetailsService customUserDetailsService;
//	@RequestMapping(value = "/token", method = RequestMethod.POST)

	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		System.err.println("*********");
		System.out.println(jwtRequest);
		try
		{
			System.err.println("*********");
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		}
		catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credential");
		}
		catch(BadCredentialsException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Credential");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		String token = this.jwtUtil.generateToken(userDetails);
		System.err.println( token );
		
		return ResponseEntity.ok(new JwtResponse(token));// it convert json
	
	}
}
