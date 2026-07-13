package com.sbi.yono.JointAccountMS.Dao;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sbi.yono.JointAccountMS.Model.Student;
import com.sbi.yono.JointAccountMS.Repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentDaoTest {
	
	@Mock
	StudentRepository studentRepository;
	
	@InjectMocks 
	StudentDao studentDao;
	
	@Test
    void getStudentDataTest() {
        Long id = 1L;
        when(studentRepository.findById(id)).thenReturn(Optional.of(new Student()));
        studentDao.getStudentData(id);
    }
	
	@Test
	void saveStudentDataTest() {
		Student req = new Student();
		studentDao.saveStudentData(req);
	}
	
	@Test
	void getAllDataTest() {
		studentDao.getAllData();
	}

	@Test
	void deleteDataTestExist() {
		Long id = 1L;
		when(studentRepository.existsById(id)).thenReturn(true);
		studentDao.deleteData(id);
	}
	
	@Test
	void deleteDataTestNotExist() {
		Long id = 1L;
		studentDao.deleteData(id);
	}
	
	@Test
	void deleteDataTestThrow() {
		Long id = 1L;
		when(studentRepository.existsById(id)).thenReturn(true);
		doThrow(new RuntimeException()).when(studentRepository).deleteById(id);;
		studentDao.deleteData(id);
	}

}
