package com.imgglobalinfotech.fees.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Add_Batch")
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Batch_Id")
	private int id;
	
	@NotEmpty(message = "courseName must not empty")
	@Column(name = "Course_Name")
	private String coursename;
	
	@NotEmpty(message = "BatchName must not empty")
	@Column(name = "Batch_Name")
	private String batchName;
	
	@NotEmpty
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@Column(name = "Batch_Start_Date")
	private String batchStartDate;

	
	@NotNull(message = "duration must not empty")
	@Column(name = "Duration")
	private int duration; 
	
	@NotNull(message = "fees must not empty")
	@Column(name = "Fees")
	private double  fees;
	
	@NotNull(message = "coachingId must not empty")
	@Column(name = "Coaching_Id")
	private int adminid;
	 
//	@NotEmpty
//	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
//	@Column(name = " Renewal_Date")
//	private String renewalDate;

}
