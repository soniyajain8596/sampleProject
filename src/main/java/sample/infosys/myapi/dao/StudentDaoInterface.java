package sample.infosys.myapi.dao;

import sample.infosys.myapi.entity.Student;
import sample.infosys.myapi.exception.StudentNotFoundException;

public interface StudentDaoInterface {

	public Student getStudent(Long studentId) throws StudentNotFoundException;
	public Student createStudent(Student student);
}
