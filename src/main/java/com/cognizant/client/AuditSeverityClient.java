package com.cognizant.client;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.AuditRequest;
import com.cognizant.model.AuditResponse;
import com.cognizant.model.AuditDetails;


@FeignClient(url = "${SEVERITY_MICROSERVICE_URI:http://localhost:9092/api/severity/}",name="audit-severity")
public interface AuditSeverityClient {
	
	@PostMapping("/ProjectExecutionStatus")
	public ResponseEntity<AuditResponse> auditSeverity(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditRequest request);
	
}
