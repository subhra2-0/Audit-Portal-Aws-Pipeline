package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuestionsTest {

	
	Questions questions = new Questions();
	@Test
	public void testQuestionsEntityParameterizedConstructor() {
		QuestionsEntity parameterizedQuestions = new QuestionsEntity(1,"Internal","Is data deleted with permission of user?","Yes");
		assertEquals("Internal",parameterizedQuestions.getAuditType());
	}
		
	@Test
	public void testToString()
	{
		String str=questions.toString();
		assertEquals(str,questions.toString());
	}
	
	
	
	
}
