package com.sbi.yono.JointAccountMS.Dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sbi.yono.JointAccountMS.Controller.StudentController;
import com.sbi.yono.JointAccountMS.Model.Student;
import com.sbi.yono.JointAccountMS.Repository.StudentRepository;

@Component
public class StudentDao {

	private StudentRepository studentRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	public StudentDao(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student getStudentData(Long Id) {
		String methodName = "getStudentData";
		LOGGER.info("Method Started "+methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentRepository.findById(Id).get();
	}

	public Student saveStudentData(Student requestBody) {
		String methodName = "saveStudentData";
		LOGGER.info("Method Started "+methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentRepository.save(requestBody);
	}

	public Optional<List<Student>> getAllData() {
		String methodName = "getAllData";
		LOGGER.info("Method Started "+methodName);
		LOGGER.info("Method Ended " + methodName);
		return Optional.of(studentRepository.findAll());
	}

	public String deleteData(Long Id) {
		String methodName = "deleteData";
		LOGGER.info("Method Started "+methodName);
		if (studentRepository.existsById(Id)) {
			LOGGER.info("ID Present");
			try {
				LOGGER.info("Enter Try Block");
				studentRepository.deleteById(Id);
				LOGGER.info("Method Ended " + methodName);
				return "Data Deleted Successfully";
			} catch (Exception e) {
				LOGGER.error("Exceptiooon Occur");
				LOGGER.info("Method Ended " + methodName);
				return "Unable to delete Please try again later";
			}
		} else {
			LOGGER.error("ID Not Present");
			LOGGER.info("Method Ended " + methodName);
			return "No record found !!";
		}
	}
}
