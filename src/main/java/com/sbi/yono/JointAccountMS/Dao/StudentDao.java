package com.sbi.yono.JointAccountMS.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sbi.yono.JointAccountMS.Model.Student;
import com.sbi.yono.JointAccountMS.Repository.StudentRepository;

@Component
public class StudentDao {

	private StudentRepository studentRepository;

	public StudentDao(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Student getStudentData(Long Id) {
		return studentRepository.findById(Id).get();
	}

	public Student saveStudentData(Student requestBody) {
		return studentRepository.save(requestBody);
	}

	public Optional<List<Student>> getAllData() {
		return Optional.of(studentRepository.findAll());
	}

	public String deleteData(Long Id) {
		if (studentRepository.existsById(Id)) {
			try {
				studentRepository.deleteById(Id);
				return "Data Deleted Successfully";
			} catch (Exception e) {
				return "Unable to delete Please try again later";
			}
		} else 
			return "No record found !!";
	}
}
