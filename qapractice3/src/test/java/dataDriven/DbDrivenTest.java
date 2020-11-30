package dataDriven;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mysql.MySQLAccess;

public class DbDrivenTest extends DataDrivenTestBase{

	MySQLAccess database = new MySQLAccess();

	@Test
	public void ReadDataFromDB() {

		//Not Passing, I believe its because in the database one of the student has a State of Delhi, 
		//which is not an option. 

		try {
			List<Student> studentList = new ArrayList<Student>();

			studentList = database.convertDbToStudent();


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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void beforeTest() {
		try {
			super.beforeTest();
			database.connectToDB("world_x");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest() {

		try {
			super.afterTest();
			database.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
