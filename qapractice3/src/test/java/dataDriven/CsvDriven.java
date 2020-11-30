package dataDriven;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CsvDriven {

	public List<Student> convertCSVtoStudent(String filePath) {

		List<Student> studentList = new ArrayList<Student>();
		
		try
		{
			CSVReader reader = new CSVReader(new FileReader(filePath));
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

				Student student = new Student(firstName, lastName, email, gender, mobileNumber, dob, subjects, hobbies, address, state, city);

				studentList.add(student);
			}  
		}  
		catch (Exception e)   
		{  
			e.printStackTrace();  
		}
		for(int i = 0; i < studentList.size(); i++)
		{
		System.out.println(studentList.get(i).toString());
		}
		return studentList;  
	}  

}
