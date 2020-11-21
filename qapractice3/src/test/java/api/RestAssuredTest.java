package api;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import org.json.simple.JSONObject;





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

		JSONObject request = new JSONObject();
		given().
		body(request.toString()).
		when().
		delete(basePath + "/api/users/2").
		then().assertThat().statusCode(204);

		//HTTP 204 - No Content
		//The request has succeeded but there is nothing to send for the response.
	}

	
	@Test
	public void UsingPatchToUpdate() {
		
		HashMap<String,Object> request = new HashMap<String,Object>();
		request.put("name", "morpheus2");
		
		JSONObject jsonRequest = new JSONObject(request);
		
		
		given().body(jsonRequest.toJSONString())
		.when()
		.patch(basePath + "/api/users/2").then().statusCode(200)
		.assertThat()
		.body("updatedAt", equalTo(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(new Date())));
	
		
	}
	
	@Test
	public void UsingPutToUpdate() {
		
		HashMap<String,Object> request = new HashMap<String,Object>();
		request.put("name", "morpheus2");
		
		JSONObject jsonRequest = new JSONObject(request);
		
		given().body(jsonRequest.toJSONString())
		.when()
		.put(basePath + "/api/users/2").then().statusCode(200)
		.assertThat()
		.body("updatedAt", equalTo(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(new Date())));
	
		
	}
	
}


