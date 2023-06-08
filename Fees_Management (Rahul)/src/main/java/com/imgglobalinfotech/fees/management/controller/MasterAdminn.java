package com.imgglobalinfotech.fees.management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imgglobalinfotech.fees.management.entity.Masteradmin;
import com.imgglobalinfotech.fees.management.healper.JwtUtil;
import com.imgglobalinfotech.fees.management.model.JwtResponse;
import com.imgglobalinfotech.fees.management.payload.Update;
import com.imgglobalinfotech.fees.management.service.CotrollerService;
import com.imgglobalinfotech.fees.management.service.CustomUserDetailsService;

@RestController
public class MasterAdminn {

	@Autowired
	private CotrollerService ctrsrv;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/welcome")
	public String welcome() {
		String text = "this is private page";
		return text;
	}

	@PostMapping("/loginn")
	public ResponseEntity<?> loginForToken(@RequestBody Masteradmin ma) throws Exception {

		System.err.println("*********");

		Boolean b = ctrsrv.existsByUsernameAndPassword(ma);
		if (b) {
			try {
				System.err.println("*********");
				this.authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(ma.getUsername(), ma.getPassword()));
			} catch (UsernameNotFoundException e) {
				e.printStackTrace();
				throw new Exception("Bad Credential");
			} catch (BadCredentialsException e) {
				e.printStackTrace();
				throw new Exception("Bad Credential");
			}

			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(ma.getUsername());

			String token = this.jwtUtil.generateToken(userDetails);
			System.err.println(token);

			return ResponseEntity.ok(new JwtResponse(token));// it convert json
		} else { 
			String str = "invalid email id";
			return new ResponseEntity<>(str, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping("/post")
	public ResponseEntity<?> post(@Valid @RequestBody Masteradmin ma) {
		Masteradmin rtn = ctrsrv.saveDetails(ma);
		if(rtn!=null) {
		return new ResponseEntity<>(rtn, HttpStatus.CREATED);
		}else{
			System.err.println("null");
			return new ResponseEntity<>(rtn, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping("/check/active/{id}")
	public ResponseEntity<?> activeorinactive(@PathVariable int id)
	{
		String str;
		Masteradmin rtn = ctrsrv.viewById(id);
		if(rtn.getActive_or_inactive()==true)
		{
			str = "Active";
		}else 
		{
			str = "In-Active";
		}
		return new ResponseEntity<>(str, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> viewAll() {
		System.err.println("YES");
		List<Masteradmin> rtn = ctrsrv.viewAllDetails();
		if(rtn == null) {
		System.out.println("yesss");}else {System.out.println("no");}
		return new ResponseEntity<>(rtn, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<?> viewById(@PathVariable int id) {
		Masteradmin rtn = ctrsrv.viewById(id);
		return new ResponseEntity<>(rtn, HttpStatus.OK);
	}

	@PutMapping("/UpDate") 
	public ResponseEntity<?> upDate(@Valid @RequestBody Masteradmin ma) {
		Masteradmin rtn = ctrsrv.UpDate(ma);
		return new ResponseEntity<>(rtn, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id) {
		ctrsrv.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getByChoingName/{name}") 
	public ResponseEntity<?> getByChoingName(@PathVariable String name) {
		Masteradmin rtn = ctrsrv.getByChoingName(name);
		return new ResponseEntity<>(rtn, HttpStatus.OK);
	}
	

}
