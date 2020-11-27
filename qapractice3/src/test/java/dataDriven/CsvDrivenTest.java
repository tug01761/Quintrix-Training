package dataDriven;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import org.testng.annotations.BeforeTest;

import java.io.FileReader;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CsvDrivenTest extends DataDrivenTestBase {

	@Test
	public void ReadDataFromCSV() {
		/*
		CsvDriven csvFile = new CsvDriven();
		Student student;
		student = csvFile.convertCSVtoStudent("src/test/resources/Students.csv");
		*/
		
		Student student;

		try
		{
			CSVReader reader = new CSVReader(new FileReader("src/test/resources/Students.csv"));
			reader.skip(1);
			String [] nextLine;  
			//reads one line at a time  
			while ((nextLine = reader.readNext()) != null)  
			{  		

				String split1[] = nextLine[0].split(",", 0);
				String firstName = split1[1];
				String lastName = split1[0];

				
				String split2[] = nextLine[1].split("/", 0);
				String dayBefore = split2[0];
				String monthBefore = split2[1];
				String year = split2[2];
				
				String dayAfter = dayBefore;
				String monthAfter = monthBefore;
				
				if(Integer.parseInt(dayBefore)< 10)
				{
					dayAfter = "0" + dayBefore;
				}
				
				if(Integer.parseInt(monthBefore)< 10)
				{
					monthAfter = "0" + monthBefore;
				}
				
				String dob = dayAfter + "/" + monthAfter + "/" + year;

				

				String email = nextLine[2];

				String address = nextLine[3] + " " + nextLine[4] + " " + nextLine[7];

				String state = nextLine[5];

				String city = nextLine[6];

				String mobileNumberWithDashLine = nextLine[8];
				String mobileNumber = mobileNumberWithDashLine.replaceAll("-", "");

				String genderAbbrv = nextLine[9];
				String gender;
				
				if(genderAbbrv.equals("M"))
				{
					gender = "Male";
				}
				else if(genderAbbrv.equals("F"))
				{
					gender = "Female";
				}
				else 
				{
					gender = "Other";
				}

				String subjects = "";
				String hobbies = "";

				if(nextLine.length == 11)
				{
					String subjectsOrHobbies = nextLine[10];

					if(subjectsOrHobbies.contains("Sports") || subjectsOrHobbies.contains("Reading") || subjectsOrHobbies.contains("Music") )
					{
						String hobbiesWithSeparation = nextLine[10];
						hobbies = hobbiesWithSeparation.replaceAll(";", ", ");
					}
					else
					{
						String subjectsWithSeparation = nextLine[10];
						subjects = subjectsWithSeparation.replaceAll(";", ", ");
					}

				}
				else if(nextLine.length == 12)
				{
					String subjectsWithSeparation = nextLine[10];
					subjects = subjectsWithSeparation.replaceAll(";", ", ");

					String hobbiesWithSeparation = nextLine[11];
					hobbies = hobbiesWithSeparation.replaceAll(";", ", ");

				}

				student = new Student(firstName, lastName, email, gender, mobileNumber, dob, subjects, hobbies, address, state, city);
					
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
		}  
		catch (Exception e)   
		{  
			e.printStackTrace();  
		}
		

		
		/*
		Student confirmationStudent = new DemoFormPage(driver, baseUrl)
				.navigate()
				.setFirstName(student.getFirstName())
				.setLastName(student.getLastName())
				.setEmail(student.getEmail())
				.setGender(student.getGender())
				.setMobileNumber(student.getMobileNumber())
				.setDOB(student.getDOB())
				.setSubjects(student.getSubjects())
				.setHobbies(student.getHobbies())
				.setAddress(student.getAddress())
				.setState(student.getState())
				.setCity(student.getCity())
				.submit()
				.getConfirmation();

		Assert.assertEquals(confirmationStudent.toString(), student.toString());
		*/

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
