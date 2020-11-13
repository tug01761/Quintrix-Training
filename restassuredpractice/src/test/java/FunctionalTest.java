import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class FunctionalTest {
	
	  @BeforeClass
	  public static void setup() {
		  String basePath = System.getProperty("server.base");
	      if(basePath==null){
	          basePath = "https://reqres.in";
	      }
	      RestAssured.basePath = basePath;
	      
	  }

}
