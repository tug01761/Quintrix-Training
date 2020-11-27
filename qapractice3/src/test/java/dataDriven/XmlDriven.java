package dataDriven;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlDriven {


	public void convertXMLToStudent() {

		Student student;

		String f_name = "";
		String l_name = "";
		String email = "";
		String gender = "";
		String mobileNumber = "";
		String dob = "";
		String address = "";
		String state = "";
		String city = "";
		String newSubjects = "";
		String newDateString = "";

		File file = new File("src/test/resources/Students.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeList1 = doc.getElementsByTagName("person");
			NodeList nodeList2 = doc.getElementsByTagName("dob");
			NodeList nodeList3 = doc.getElementsByTagName("contact");

			for(int i = 0; i < 3; i++)
			{

				String subjects = "";
				String hobbies = "";

				Node node1 = nodeList1.item(i); 
				Node node2 = nodeList2.item(i);
				Node node3 = nodeList3.item(i);

				if (node1.getNodeType() == Node.ELEMENT_NODE)   
				{  
					Element eElement1 = (Element) node1;  

					f_name = eElement1.getElementsByTagName("f_name").item(0).getTextContent();
					l_name = eElement1.getElementsByTagName("l_name").item(0).getTextContent(); 
					gender = eElement1.getElementsByTagName("gender").item(0).getTextContent();

					
					for(int j = 0; j < eElement1.getElementsByTagName("subject").getLength(); j++)
					{
						String subject = eElement1.getElementsByTagName("subject").item(j).getTextContent();
						subjects += ", " + subject;
					}
					
					newSubjects = subjects.substring(0,0)+""+subjects.substring(2);

					try {
						if(eElement1.getElementsByTagName("hobbies").getLength() > 0);
						{
							hobbies = eElement1.getElementsByTagName("hobby").item(0).getTextContent();
						}
					}
					catch (NullPointerException e) {

					}

					String house = eElement1.getElementsByTagName("house").item(0).getTextContent();
					String street = eElement1.getElementsByTagName("street").item(0).getTextContent();
					String postalCode = eElement1.getElementsByTagName("postalCode").item(0).getTextContent();

					address = house + " " + street + ", " + postalCode;

					state = eElement1.getElementsByTagName("state").item(0).getTextContent();
					city = eElement1.getElementsByTagName("city").item(0).getTextContent();
				} 
				

				if (node2.getNodeType() == Node.ELEMENT_NODE)   
				{  
					Element eElement2 = (Element) node2;  

					String day = eElement2.getAttribute("day");
					String month =  eElement2.getAttribute("month");
					String year =  eElement2.getAttribute("year");

					dob = day + " " + month + " " + year;
					
					String Old_Format = "dd MMMM yyyy";
					String New_Format = "MM/dd/yyyy";
					
					

					SimpleDateFormat sdf = new SimpleDateFormat(Old_Format);

					try {
						Date d = sdf.parse(dob);
						sdf.applyPattern(New_Format);
						newDateString = sdf.format(d);
						
					} catch (ParseException e) {
						e.printStackTrace();
					}


				} 

				if (node3.getNodeType() == Node.ELEMENT_NODE)   
				{  
					Element eElement3 = (Element) node3;  

					String mobileNumberWithDashLine = eElement3.getTextContent();
					mobileNumber = mobileNumberWithDashLine.replaceAll("-", "");
					
				} 
				


				
				System.out.println(f_name);
				System.out.println(l_name);
				System.out.println(email);
				System.out.println(gender);
				System.out.println(mobileNumber);
				System.out.println(newDateString);
				System.out.println(newSubjects);
				System.out.println(hobbies);
				System.out.println(address);
				System.out.println(state);
				System.out.println(city);
				System.out.println("----------------------------");
				
				student = new Student(f_name, l_name, email, gender, mobileNumber, newDateString, newSubjects, hobbies, address, state, city);

			}






		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
