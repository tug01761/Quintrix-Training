package dataDriven;

import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ParameterDriven extends DataDrivenTestBase {

	//https://demoqa.com/automation-practice-form

	@DataProvider(name = "student-list")
	public Student[] dataProviderMethod() {
		Student[] studentObject = new Student[3];
		studentObject[0] = new Student("Mike", "Lauw", "mlauw@gmail.com", "Male", "2654333111", "05/01/1996", "Accounting, Arts", "Reading", "2210 South Street", "NCR", "Delhi");
		studentObject[1] = new Student("Bob", "Troy", "btroy@gmail.com", "Other", "1234567890", "10/12/2000", "Maths, English", "Sports, Reading", "110 North Street", "Haryana", "Panipat");
		studentObject[2] = new Student("Kathy", "White", "kwhite@gmail.com", "Female", "5234954032", "12/25/2003", "Computer Science", "Music", "200 Wolf Street", "Uttar Pradesh", "Agra");


		return studentObject;
	}

	@Test(dataProvider = "student-list")
	public void registerStudents(Student student) {
		//String expectedFirstName = student.getFirstName();

		Student confirmationStudent = new DemoFormPage(driver, baseUrl)
				.navigate()
				.setFirstName(student.getFirstName())
				.setLastName(student.getLastName())
				.setEmail(student.getEmail())
				.setGender(student.getGender())
				.setMobileNumber(student.getMobileNumber())
				.setDOBWrongFormat(student.getDOB())
				.setSubjects(student.getSubjects())
				.setHobbies(student.getHobbies())
				.setAddress(student.getAddress())
				.setState(student.getState())
				.setCity(student.getCity())
				.submit()
				.getConfirmation();

		Assert.assertEquals(confirmationStudent.toString(), student.toString());

	}

	@BeforeTest
	public void beforeTest() {
		super.beforeTest();
	}

	@AfterTest
	public void afterTest() {
		super.afterTest();
	}

}
