package com.cognizant.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a POJO class used to store details entered by Project Manager/User
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditDetails {
	
	private String auditType;
	
	 @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date auditDate;
	
	private List<QuestionsEntity> auditQuestions;
	

}
