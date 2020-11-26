package dataDriven;

import org.testng.annotations.Test;

import framework.TestBase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ParameterDriven extends TestBase {

	//https://demoqa.com/automation-practice-form
	
	@DataProvider(name = "student-list")
	public Student[] dataProviderMethod() {
		Student[] studentObject = new Student[3];
		studentObject[0] = new Student("Mike", "Lauw", "mlauw@gmail.com", "Male", "2654333111", "05/01/1996", "Computer Science", "Reading", "2210 South Street", "NCR", "Noida");
		studentObject[1] = new Student("Bob", "Troy", "btroy@gmail.com", "Male", "1234567890", "10/12/2000", "Computer Science", "Reading", "110 North Street", "NCR", "Noida");
		studentObject[2] = new Student("Kathy", "White", "kwhite@gmail.com", "Female", "5234954032", "12/25/2003", "Computer Science", "Reading", "200 Wolf Street", "NCR", "Noida");
		
		
        return studentObject;
    }

	@Test(dataProvider = "student-list")
	public void registerStudents(Student student) {
		String expectedFirstName = student.getFirstName();
		
		//String submittedFirstName = new DemoFormPage(driver, baseUrl);
				
		
		
		
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
