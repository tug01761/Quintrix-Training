import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;





public class RestAssuredTest extends FunctionalTest{

	@Test
	public void GetSingleUserEmailAddress() {


		given().get(basePath + "/api/users/2").then()
		.statusCode(200)
		.body("data.email", equalTo("janet.weaver@reqres.in"));


	}

	@Test
	public void SuccessfulyLogin() {

		String expectedToken = "QpwL5tke4Pnpja7X4";

		Map<String, Object> loginCredentials = new HashMap<String, Object>();
		loginCredentials.put("email", "eve.holt@reqres.in");
		loginCredentials.put("password", "cityslicka");  



		given().
		contentType("application/json").
		body(loginCredentials).
		when().
		post(basePath + "/api/login").
		then().statusCode(200).assertThat().body("token", equalTo(expectedToken));

	}

	@Test
	public void TestingStatusCode204() {

		Object request = new Object();
		given().
		body(request.toString()).
		when().
		delete("https://reqres.in/api/users/2").
		then().assertThat().statusCode(204);

		//HTTP 204 - No Content
		//The request has succeeded but there is nothing to send for the response.
	}

	/*
	@Test
	public void UsingPatchToUpdate() {
		Map<String, Object> loginCredentials = new HashMap<String, Object>();
		loginCredentials.put("name", "morpheus2");
		
		
		given().get(basePath + "/api/users/2").then()
		.statusCode(200);
		
		
	}
	*/
	
}


