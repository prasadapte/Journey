package com.sbi.yono.JointAccountMS.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

	@Cacheable(value = "studentCache", key = "#Id")
	public Student getStudentData(Long Id) {
		String methodName = "getStudentData";
		LOGGER.info("Method Started " + methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.getStudentData(Id);
	}

	@Caching(
			put = {
					@CachePut(value = "studentCache", key = "#result.id")
			}, 
			evict = {
					@CacheEvict(value = "allStudents", allEntries = true) 
			}
	)
	public Student saveStudentData(Student requestBody) {
		String methodName = "saveStudentData";
		LOGGER.info("Method Started " + methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.saveStudentData(requestBody);
	}

	@Cacheable(value = "allStudents")
	public Optional<List<Student>> getAllData() {
		String methodName = "getAllData";
		LOGGER.info("Method Started " + methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.getAllData();
	}

	@Caching(
			evict = {
					@CacheEvict(value = "studentCache", key = "#Id"),
					@CacheEvict(value = "allStudents", allEntries = true)
			}
	)			
	public String deleteData(Long Id) {
		String methodName = "deleteData";
		LOGGER.info("Method Started " + methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.deleteData(Id);
	}
}
