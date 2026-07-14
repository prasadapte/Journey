package com.sbi.yono.JointAccountMS.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.yono.JointAccountMS.Model.Student;
import com.sbi.yono.JointAccountMS.Service.StudentService;

@RestController
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/getdata")
	public Map<String, Object> getStudentData(@RequestBody Map<String, Long> requestBody) {
		Map<String, Object> res = new HashMap<String, Object>();
		if (!requestBody.containsKey("id") || null == requestBody.get("id"))
			res.put("Error", "ID Can't be null");
		else
			res.put("Response", studentService.getStudentData(requestBody.get("id")));
		return res;
	}

	@PostMapping("/savedata")
	public Map<String, Object> saveStudentData(@RequestBody Student requestBody) {
		Map<String, Object> res = new HashMap<String, Object>();
		if (null == requestBody.getName() || requestBody.getName().isBlank())
			res.put("Error", "Name cannot be null");
		else if (null == requestBody.getTestScore() || requestBody.getTestScore().isBlank())
			res.put("Error", "TestScore cannot be null");
		else
			res.put("Response", studentService.saveStudentData(requestBody));
		return res;
	}

	@PostMapping("/getalldata")
	public Map<String,Object> getAllData(){
		Map<String,Object> res = new HashMap<String, Object>();
		res.put("Response", studentService.getAllData());
		return res;
	}

	@PostMapping("/deletedata")
	public Map<String,Object> deleteData(@RequestBody Map<String,Long> requestBody){
		Map<String, Object> res = new HashMap<String, Object>();
		if(null == requestBody.get("id")) 
			res.put("Error","Id cannot be null");
		else
			res.put("Response", studentService.deleteData(requestBody.get("id")));
		return res;
	}	
}
