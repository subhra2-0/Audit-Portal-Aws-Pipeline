package com.cognizant.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.client.AuditCheckListClient;
import com.cognizant.client.AuditSeverityClient;
import com.cognizant.client.AuthClient;
import com.cognizant.model.AuditDetails;
import com.cognizant.model.AuditRequest;
import com.cognizant.model.AuditResponse;
import com.cognizant.model.AuditType;
import com.cognizant.model.QuestionsEntity;
import com.cognizant.model.UserCredentials;
import com.cognizant.repository.RequestRepository;
import com.cognizant.repository.ResponseRepository;
import com.cognizant.entity.AuditDetailModel;
import com.cognizant.entity.AuditRequestModel;
import com.cognizant.entity.AuditResponseModel;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@Slf4j
public class AuditController {
	
	@Autowired
	private AuthClient authClient;
	@Autowired
	private AuditCheckListClient auditCheckList;
	@Autowired
	private AuditSeverityClient auditSeverity;
	@Autowired
	private RequestRepository rep;
	@Autowired
	private ResponseRepository responseRepository;
	/*
	 * getting the token from the authclient and sending it to the ui
	 */
	@PostMapping("/login")
	public Map<String,String> getToken(@RequestBody UserCredentials userCredentials)
	{
		log.info("login starts");
		Map<String,String> token=new HashMap<>();
		token=authClient.getToken(userCredentials);
		log.debug("",token);
		token.put("user",userCredentials.getUserId());
		log.info("login ends");
		return token;
		
	}
	/*
	 * getting the questions list
	 * 
	 */
	@PostMapping("/AuditCheckListQuestions")
	public ResponseEntity<List<QuestionsEntity>> getCheckList(@RequestHeader(name="Authorization",required=true) String token,@RequestBody AuditType auditType )
	{
		log.info("AuditCheckListQuestions");
		return auditCheckList.getCheckList(token, auditType);
	}
	/*
	 * getting the reponse corresponding the questions and sending it to the ui
	 */
	@PostMapping("/ProjectReponseStatus")
	public  AuditResponse getProjectStatus(@RequestHeader(name="Authorization",required=true) String token, @RequestBody AuditRequest auditRequest)
	{
		log.info("ProjectReponseStatus");
		AuditRequestModel requestModel = new AuditRequestModel();
		AuditDetailModel auditDetailModel = new AuditDetailModel(auditRequest.getAuditDetails().getAuditType());
		requestModel.setAuditDetail(auditDetailModel);
		requestModel.setProjectName(auditRequest.getProjectName());
		requestModel.setManagerName(auditRequest.getProjectManagerName());
		requestModel.setOwnerName(auditRequest.getApplicationOwnerName());
		 rep.save(requestModel);
		 AuditResponseModel rm=new AuditResponseModel();
		 AuditResponse re=auditSeverity.auditSeverity(token, auditRequest).getBody();
		 rm.setExecutionStatus(re.getProjectExecutionStatus());
		 rm.setActionDuration(re.getRemedialActionDuration());
		 responseRepository.save(rm);
		return auditSeverity.auditSeverity(token, auditRequest).getBody();
	}
	
	
	

}
