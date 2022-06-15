package sample.infosys.myapi.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import sample.infosys.myapi.dao.StudentDaoInterface;
import sample.infosys.myapi.entity.Student;
import sample.infosys.myapi.entity.StudentInfoInput;
import sample.infosys.myapi.exception.StudentNotFoundException;

@Service
public class StudentServiceImpl implements StudentServiceInterface{

	@Autowired
	@Qualifier("studentDaoInMemory")
	private StudentDaoInterface studentDao;
	
	@Value("${student.numberOfStudent}")
	private int STUDENT_ID_LENGTH = 1;
	
	@Override
	public Student getStudent(Long studentId) throws StudentNotFoundException {
		return studentDao.getStudent(studentId);
	}

	@Override
	public Student createStudent(StudentInfoInput input) {
		Long studentId = getStudentId();
		Student student = new Student(input.getFirstName(), input.getLastName(), studentId);
		return studentDao.createStudent(student);
	}

	private Long getStudentId() {
		boolean studentIdNotFound = true;
		Long studentId = -1L;
		
		while(studentIdNotFound) {
			Random studentIdRandom = new Random();
			studentId = studentIdRandom.nextLong(STUDENT_ID_LENGTH);
			
			try{
				Student student = studentDao.getStudent(studentId);
			}catch (StudentNotFoundException e) {
				studentIdNotFound = false;
			}
		}
		
		return studentId;
	}

}
