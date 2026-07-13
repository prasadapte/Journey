package com.sbi.yono.JointAccountMS.Controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sbi.yono.JointAccountMS.Model.Student;
import com.sbi.yono.JointAccountMS.Service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

	@Mock
	private StudentService studentService;

	@InjectMocks
	private StudentController studentController;

	@Test
	public void getStudentDataTestIdNotNull() {
		Student student = new Student();
		student.setId(1L);
		student.setName("Prasad");
		student.setTestScore("92");
		Map<String, Object> dbData = new HashMap<String, Object>();
		dbData.put("Response", student);
		Map<String, Long> requestBody = new HashMap<String, Long>();
		requestBody.put("id", 1L);
		studentController.getStudentData(requestBody);
	}

	@Test
	void getStudentDataIdNull() {
		Map<String, Long> request = new HashMap<>();
		request.put("id", null);
		studentController.getStudentData(request);
	}

	@Test
	void getStudentDataIdNotPresent() {
		Map<String, Long> request = new HashMap<>();
		studentController.getStudentData(request);
	}

	@Test
	void saveStudentDataNameNull() {
		Student request = new Student();
		request.setName(null);
		studentController.saveStudentData(request);
	}

	@Test
	void saveStudentDataNameIsBlank() {
		Student request = new Student();
		request.setName(" ");
		studentController.saveStudentData(request);
	}

	@Test
	void saveStudentDataTestScoreIsBlank() {
		Student request = new Student();
		request.setName("Prasad");
		request.setTestScore(" ");
		studentController.saveStudentData(request);
	}

	@Test
	void saveStudentDatTestScoreNull() {
		Student request = new Student();
		request.setName("Prasad");
		request.setTestScore(null);
		studentController.saveStudentData(request);
	}

	@Test
	void saveStudentDataIsPresent() {
		Student request = new Student();
		request.setId(1L);
		request.setName("Prasad");
		request.setTestScore("92");
		studentController.saveStudentData(request);
	}
	
	
	@Test
	void getAllData() {
		studentController.getAllData();
	}
	
	@Test
	void deleteDataIdIsNull() {
		Map<String,Long> requestBody = new HashMap<String, Long>();
		requestBody.put("id", null);
		studentController.deleteData(requestBody);
		
	}
	
	@Test
	void deleteDataIdIsNotNull() {
		Map<String,Long> requestBody = new HashMap<String, Long>();
		requestBody.put("id", 1L);
		studentController.deleteData(requestBody);
		
	}
}
