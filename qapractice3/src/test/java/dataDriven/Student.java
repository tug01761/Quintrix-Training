package dataDriven;

public class Student {
	
	private String f_name;
	private String l_name;
	private String email;
	private String gender;
	private String mobile_number;
	private String dob;
	private String subject;
	private String hobbies;
	private String address;
	private String state;
	private String city;
	
	public Student(String f_name, String l_name, String email, String gender, String mobile_number, String dob, String subject, String hobbies, String address, String state, String city)
	{
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
		this.gender = gender;
		this.mobile_number = mobile_number;
		this.dob = dob;
		this.subject = subject;
		this.hobbies = hobbies;
		this.address = address;
		this.state = state;
		this.city = city;
	}
	
	public String getFirstName() {
		return f_name;
	}
	
	public String getLastName() {
		return l_name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getGender() {
		return gender;
	}

	public String getMobileNumber() {
		return mobile_number;
	}
	
	public String getDOB() {
		return dob;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getHobbies() {
		return hobbies;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getState() {
		return state;
	}
	
	public String getCity() {
		return city;
	}

}
