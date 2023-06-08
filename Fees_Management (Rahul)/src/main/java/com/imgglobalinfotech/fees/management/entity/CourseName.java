package com.imgglobalinfotech.fees.management.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "Coaching_Admin")
public class CourseName{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Coching_Id")
	private int id;
	
	@NotNull(message = "Admin id must not be empty")
	@Column(name = "AdminId")
	private Integer adminid;
	
	@NotEmpty(message = "CourseName is not valid")
	@Column(name = "Courses_Name")
	private String coursename;
	
	
	
	

}
