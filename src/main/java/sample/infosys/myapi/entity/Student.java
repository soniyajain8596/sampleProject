package sample.infosys.myapi.entity;

public class Student {
	private String firstName;
	private String lastName ;
    private Long id;
	
	public Student(String firstName, String lastName, Long id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Long getId() {
		return id;
	}

}
