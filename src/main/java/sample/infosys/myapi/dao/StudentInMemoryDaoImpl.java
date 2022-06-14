package sample.infosys.myapi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import sample.infosys.myapi.entity.Student;
import sample.infosys.myapi.exception.StudentNotFoundException;

@Component("studentDaoInMemory")
public class StudentInMemoryDaoImpl implements StudentDaoInterface{
	private Map<Long, Student> studentIdToStudentMapping = new HashMap<>();
	
	@Override
	public Student getStudent(Long studentId) throws StudentNotFoundException {
		if(studentIdToStudentMapping.containsKey(studentId)) {
			return studentIdToStudentMapping.get(studentId);
		}else {
			throw new StudentNotFoundException("Given StudentId Not Exist");
		}

	}

	@Override
	public Student createStudent(Student student) {
		studentIdToStudentMapping.put(student.getId(), student);
		return student;
	}

}
