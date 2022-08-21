package com.cognizant.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.AuditType;
import com.cognizant.model.QuestionsEntity;

 

@FeignClient(url = "${CHECKLIST_MICROSERVICE_URI:http://localhost:9120/api/checklist/}",name="audit-checklist")
public interface AuditCheckListClient {
	
	@PostMapping("/getChecklist")
	public ResponseEntity<List<QuestionsEntity>> getCheckList(@RequestHeader(name="Authorization",required=true) String token,@RequestBody AuditType auditType );
	
	@PostMapping("/saveResponses")
	public ResponseEntity<List<QuestionsEntity>> saveResponses(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody List<QuestionsEntity> questionsResponse);
	
	
}
