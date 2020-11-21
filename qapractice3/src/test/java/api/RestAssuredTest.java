package api;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;


import org.json.simple.JSONObject;
import org.junit.Assert;





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
	
	@Test
	public void GetDataIntoObject() {

		double actualID = 2.0;
		String actualEmail = "janet.weaver@reqres.in";
		String actualFirstName = "Janet";
		String actualLastname = "Weaver";
		String actualAvatar = "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg";
		
		SingleUserSuccessResponse test = given().when(). get(basePath + "/api/users/2").as(SingleUserSuccessResponse.class);
		

		Assert.assertEquals(test.data.get("id"), actualID);
		Assert.assertEquals(test.data.get("email"), actualEmail);
		Assert.assertEquals(test.data.get("first_name"), actualFirstName);
		Assert.assertEquals(test.data.get("last_name"), actualLastname);
		Assert.assertEquals(test.data.get("avatar"), actualAvatar);
		
		
	}
	
	@Test
	public void GetDataIntoListObject() {
		
		ListUserSuccessResponse test = given().when(). get(basePath + "/api/users?page=2").as(ListUserSuccessResponse.class);
		
		double actualID = 9.0;
		String actualEmail = "tobias.funke@reqres.in";
		String actualFirstName = "Tobias";
		String actualLastname = "Funke";
		String actualAvatar = "https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg";
		
		Assert.assertEquals(test.data.get(2).get("id"), actualID);
		Assert.assertEquals(test.data.get(2).get("email"), actualEmail);
		Assert.assertEquals(test.data.get(2).get("first_name"), actualFirstName);
		Assert.assertEquals(test.data.get(2).get("last_name"), actualLastname);
		Assert.assertEquals(test.data.get(2).get("avatar"), actualAvatar);
	}
	
}


