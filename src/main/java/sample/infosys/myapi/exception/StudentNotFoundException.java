package sample.infosys.myapi.exception;

public class StudentNotFoundException extends Exception {

	public StudentNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
