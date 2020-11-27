package dataDriven;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CsvDrivenTest extends DataDrivenTestBase {

	@Test
	public void ReadDataFromCSV() {

		CsvDriven csvFile = new CsvDriven();
		List<Student> studentList = new ArrayList<Student>();
		studentList = csvFile.convertCSVtoStudent("src/test/resources/Students.csv");

		for(int i = 0; i < studentList.size(); i++)
		{
			Student confirmationStudent = new DemoFormPage(driver, baseUrl)
					.navigate()
					.setFirstName(studentList.get(i).getFirstName())
					.setLastName(studentList.get(i).getLastName())
					.setEmail(studentList.get(i).getEmail())
					.setGender(studentList.get(i).getGender())
					.setMobileNumber(studentList.get(i).getMobileNumber())
					.setDOBWrongFormat(studentList.get(i).getDOB())
					.setSubjects(studentList.get(i).getSubjects())
					.setHobbies(studentList.get(i).getHobbies())
					.setAddress(studentList.get(i).getAddress())
					.setState(studentList.get(i).getState())
					.setCity(studentList.get(i).getCity())
					.submit()
					.getConfirmation();

			Assert.assertEquals(confirmationStudent.toString(), studentList.get(i).toString());
		}

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
