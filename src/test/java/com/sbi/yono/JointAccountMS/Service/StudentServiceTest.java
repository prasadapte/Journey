package com.sbi.yono.JointAccountMS.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sbi.yono.JointAccountMS.Dao.StudentDao;
import com.sbi.yono.JointAccountMS.Model.Student;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

	@Mock
	StudentDao studentDao;

	@InjectMocks
	StudentService studentService;

	@Test
	void getStudentData() {
		Long id = 1L;
		studentService.getStudentData(id);
	}

	@Test
	void saveStudentDataTest() {
		Student req = new Student();
		req.setName("Prasad");
		req.setTestScore("89");
		studentService.saveStudentData(req);
	}

	@Test
	void getAllDataTest() {
		studentService.getAllData();
	}

	@Test
	void deleteDataTest() {
		Long id = 1L;
		studentService.deleteData(id);
	}

}
