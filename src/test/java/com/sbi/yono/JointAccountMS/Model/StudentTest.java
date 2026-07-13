package com.sbi.yono.JointAccountMS.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {

	@Test
	public void studentTest() {
		Student student = new Student();
		student.setId(1L);
		student.setName("Prasad Apte");
		student.setTestScore("92");
		
		assertEquals(1L,student.getId());
		assertEquals("Prasad Apte", student.getName());
		assertEquals("92", student.getTestScore());
		
	}
	
}
