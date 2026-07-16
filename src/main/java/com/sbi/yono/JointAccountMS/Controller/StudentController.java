package com.sbi.yono.JointAccountMS.Controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.yono.JointAccountMS.Model.Student;
import com.sbi.yono.JointAccountMS.Service.StudentService;

@RestController
public class StudentController {

	private StudentService studentService;
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/getdata")
	public Map<String, Object> getStudentData(@RequestBody Map<String, Long> requestBody) {
		String methodName = "getStudentData";
		LOGGER.info("Method Started " + methodName);
		Map<String, Object> res = new HashMap<String, Object>();
		if (!requestBody.containsKey("id") || null == requestBody.get("id")) {
			LOGGER.error("ID Not Present");
			res.put("Error", "ID Can't be null");
		} else {
			LOGGER.info("ID Present");
			res.put("Response", studentService.getStudentData(requestBody.get("id")));
		}
		LOGGER.info("Method Ended " + methodName);
		return res;
	}

	@PostMapping("/savedata")
	public Map<String, Object> saveStudentData(@RequestBody Student requestBody) {
		String methodName = "saveStudentData";
		LOGGER.info("Method Started " + methodName);
		Map<String, Object> res = new HashMap<String, Object>();
		if (null == requestBody.getName() || requestBody.getName().isBlank()) {
			LOGGER.error("Name Not Present");
			res.put("Error", "Name cannot be null");
		} else if (null == requestBody.getTestScore() || requestBody.getTestScore().isBlank()) {
			LOGGER.error("TestScore Not Present");
			res.put("Error", "TestScore cannot be null");
		} else {
			LOGGER.info("Student Data Present");
			res.put("Response", studentService.saveStudentData(requestBody));
		}
		LOGGER.info("Method Ended " + methodName);
		return res;
	}

	@PostMapping("/getalldata")
	public Map<String, Object> getAllData() {
		String methodName = "getAllData";
		LOGGER.info("Method Started " + methodName);
		
		Map<String, Object> res = new HashMap<String, Object>();
		res.put("Response", studentService.getAllData());
		
		LOGGER.info("Method Ended " + methodName);
		return res;
	}

	@PostMapping("/deletedata")
	public Map<String, Object> deleteData(@RequestBody Map<String, Long> requestBody) {
		String methodName = "deleteData";
		LOGGER.info("Method Started " + methodName);
		
		Map<String, Object> res = new HashMap<String, Object>();
		if (null == requestBody.get("id")) {
			LOGGER.error("ID Not Present");
			res.put("Error", "Id cannot be null");
		} else {
			LOGGER.info("ID Present");
			res.put("Response", studentService.deleteData(requestBody.get("id")));
		}
		LOGGER.info("Method Ended " + methodName);
		return res;
	}
}
