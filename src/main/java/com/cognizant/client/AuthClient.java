package com.cognizant.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.model.ProjectManager;
import com.cognizant.model.UserCredentials;


/*
 * This feign client is used to call methods of  Authentication microservice
 */


@FeignClient(url = "${AUTHORIZATION_MICROSERVICE_URI:http://localhost:8090/api/audit/}", name = "audit-auth")
public interface AuthClient {
	
	@PostMapping(value = "/login")
	public ResponseEntity<ProjectManager> login(@RequestBody UserCredentials userlogincredentials);

	@PostMapping(value="/authenticate")
	public Map<String,String> getToken(@RequestBody UserCredentials userLoginCredentials);
	
	@GetMapping(value = "/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) ;


}

	
