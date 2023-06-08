package com.imgglobalinfotech.fees.management.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data

//@Table(name = "Master_Admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Masteradmin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AdminId")
	private int id;
	
	@NotEmpty(message = "Name is not valid")
	@Column(name = "Full_Name")
	private String name;
	
	@NotEmpty(message = "username must not empty")
	@Column(name = "Username")
	private String username;
	
	@Size(min = 4, message = "minimum size must be 4")
	@Column(name = "Password")
	private String password;
	
	@NotEmpty(message = "Choching Name must not empty")
	@Column(name = "Coaching_Name")
	private String choingname;
	
	@NotEmpty(message = "Address must not empty")
	@Column(name = "Address")
	private String address;
	
	@Email(message = "Email address is not valid")
	@Column(name = "Email")
	private String email;
	
	@Size(min = 10, message = "contact number must not less than 10 number")
	@Column(name = "Contact_Information")
	private String contactinfo;
	
	@NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@Column(name = "Start_Date ")
	private String startdate;
	
//	private String ActiveOrNot;
	
	@NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@Column(name = " Renewal_Date")
	private String renewaldate;
	
//	@AssertTrue
//	@NotNull(message = "active or inactive must not empty")
//	@Pattern(regexp = "^(true|false)$")
//	message = "restartable field allowed input: true or false"
	@Column(name = "active_inactive")
	private Boolean active_or_inactive;

	//--------------------------------------------------------------------------
	
	 
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name = "Courses_Name",
//	joinColumns = @JoinColumn(name = "AdminId"))
//	@Column(name = "Courses_Name")
//	private List<String> coursesname;

	
	//---------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	

}
