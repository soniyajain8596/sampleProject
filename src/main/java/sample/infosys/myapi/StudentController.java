package sample.infosys.myapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.infosys.myapi.entity.Student;
import sample.infosys.myapi.entity.StudentInfoInput;
import sample.infosys.myapi.exception.StudentNotFoundException;
import sample.infosys.myapi.service.StudentServiceInterface;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

	
	@Autowired
	private StudentServiceInterface serviceInterface;
	
	@GetMapping(path="/{studentId}", produces = "application/json")
	public ResponseEntity<Object> getStudent(@PathVariable("studentId") Long studentId) {
		try {
			Student student = serviceInterface.getStudent(studentId);
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			return new ResponseEntity<>("Student Does Not Exist", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(path = "/", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> createStudent(@RequestBody StudentInfoInput studentInfo){
		Student student = serviceInterface.createStudent(studentInfo);
		return new ResponseEntity<>(student, HttpStatus.OK);		
	}

}
