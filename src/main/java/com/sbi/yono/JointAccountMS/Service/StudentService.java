package com.sbi.yono.JointAccountMS.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sbi.yono.JointAccountMS.Controller.StudentController;
import com.sbi.yono.JointAccountMS.Dao.StudentDao;
import com.sbi.yono.JointAccountMS.Model.Student;

@Service
public class StudentService {

	private StudentDao studentDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	public StudentService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student getStudentData(Long Id) {
		String methodName = "getStudentData";
		LOGGER.info("Method Started "+methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.getStudentData(Id);
	}
	
	public Student saveStudentData(Student requestBody) {
		String methodName = "saveStudentData";
		LOGGER.info("Method Started "+methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.saveStudentData(requestBody);
	}
	
	public Optional<List<Student>> getAllData(){
		String methodName = "getAllData";
		LOGGER.info("Method Started "+methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.getAllData();
	}
	
	public String deleteData(Long Id) {
		String methodName = "deleteData";
		LOGGER.info("Method Started "+methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.deleteData(Id);
	}
}
