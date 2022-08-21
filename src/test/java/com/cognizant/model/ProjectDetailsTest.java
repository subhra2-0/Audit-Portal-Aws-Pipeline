package com.cognizant.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProjectDetailsTest {
ProjectDetails projectdetails=new ProjectDetails();



@Test
public void testProjectName()
{
	projectdetails.setProjectName("abc");
	assertEquals( "abc" , projectdetails.getProjectName());
}

@Test
public void testProjectManagerName()
{
	projectdetails.setProjectManagerName("abc");
	assertEquals( "abc" , projectdetails.getProjectManagerName());
}

@Test
public void testApplicationOwnerName()
{
	projectdetails.setApplicationOwnerName("abc");
	assertEquals( "abc" , projectdetails.getApplicationOwnerName());
}



@Test
public void testoString() {
	String string = projectdetails.toString();
	assertEquals(string ,projectdetails.toString());
}
}
