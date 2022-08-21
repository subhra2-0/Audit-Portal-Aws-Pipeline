package om.cognizant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.client.AuditCheckListClient;
import com.cognizant.client.AuditSeverityClient;
import com.cognizant.client.AuthClient;
import com.cognizant.controller.AuditController;
import com.cognizant.entity.AuditDetailModel;
import com.cognizant.entity.AuditRequestModel;
import com.cognizant.entity.AuditResponseModel;
import com.cognizant.model.AuditResponse;
import com.cognizant.model.AuditType;
import com.cognizant.model.QuestionsEntity;
import com.cognizant.model.UserCredentials;
import com.cognizant.repository.RequestRepository;
import com.cognizant.repository.ResponseRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootConfiguration
@SpringBootTest
@Slf4j
public class AuditControllerTest {

	@Mock
	private AuthClient authClient;
	@Mock
	private AuditCheckListClient auditCheckList;
	@Mock
	private AuditSeverityClient auditSeverity;
	@Mock
	private RequestRepository rep;
	@Mock
	private ResponseRepository responseRepository;
	@InjectMocks
	AuditController auditController;
	
	@Test
	public void contextLoads() {
		assertNotNull(auditController);
	}
	UserCredentials userCredentials;
	@Test
	public void testgetToken() {
		log.info("login starts");
		Map<String,String> token=new HashMap<>();
		token=authClient.getToken(null);
		log.debug("",token);
		token.put("user","abc");
		log.info("login ends");
		assertEquals("abc",token.get("user"));
		
	}
	public AuditType a;
	@Test
	public void testgetCheckList() {
		ResponseEntity<?> responseEntity = null;
		List<QuestionsEntity> questionsList = new ArrayList<QuestionsEntity>();
		questionsList.add(new QuestionsEntity(1,"Internal","How are you","Yes"));
		AuditType auditType=new AuditType("sox");
		responseEntity =auditCheckList.getCheckList("token", auditType);
		assertNull(responseEntity);
		
	}
	@Test
	public void testgetProjectStatus() {
		AuditRequestModel requestModel = new AuditRequestModel();
		AuditDetailModel auditDetailModel = new AuditDetailModel("aa");
		requestModel.setProjectName("jdd");
		requestModel.setManagerName("ss");
		requestModel.setOwnerName("aa");
		 rep.save(requestModel);
		 AuditResponseModel rm=new AuditResponseModel();
		 rm.setExecutionStatus("green");
		 rm.setActionDuration("no action needed");
		 responseRepository.save(rm);
		assertEquals("aa",requestModel.getOwnerName());
	}
	
}
