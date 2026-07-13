package com.sbi.yono.JointAccountMS.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sbi.yono.JointAccountMS.Dao.StudentDao;
import com.sbi.yono.JointAccountMS.Model.Student;

@Service
public class StudentService {

	private StudentDao studentDao;
	
	public StudentService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student getStudentData(Long Id) {
		return studentDao.getStudentData(Id);
	}
	
	public Student saveStudentData(Student requestBody) {
		return studentDao.saveStudentData(requestBody);
	}
	
	public Optional<List<Student>> getAllData(){
		return studentDao.getAllData();
	}
	
	public String deleteData(Long Id) {
		return studentDao.deleteData(Id);
	}
}
