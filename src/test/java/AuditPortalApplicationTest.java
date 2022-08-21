
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditPortalApplication;


@ContextConfiguration
public class AuditPortalApplicationTest {

	@Mock
	AuditPortalApplication auditPortalApplication;
	@Test
	void main() {}
//	void contextLoads() {
//		
//		assert (auditPortalApplication) != null;
//	}
	
}
