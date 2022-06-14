package sample.infosys.myapi.service;

import sample.infosys.myapi.entity.Student;
import sample.infosys.myapi.entity.StudentInfoInput;
import sample.infosys.myapi.exception.StudentNotFoundException;

public interface StudentServiceInterface {
	
	public Student getStudent(Long studentId) throws StudentNotFoundException;
	public Student createStudent(StudentInfoInput student);
}
