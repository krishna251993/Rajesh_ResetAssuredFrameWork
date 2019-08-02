package restAssuredTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import restUtills.RestUtills;

public class Demo2_Post_Request {
	
	public static HashMap<String, String> map=new HashMap<String, String>();
	@BeforeClass
	public void postData() {
		
		map.put("FirstName", RestUtills.getFirstName());
		map.put("FirstName", RestUtills.getLastName());
		map.put("FirstName", RestUtills.getUserName());
		map.put("Password", RestUtills.getPassword());
		map.put("FirstName", RestUtills.getEmail());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/resister";
		
		
	}
	
	@Test
	public void testPost() {
		Response response=
		given()
			.contentType("application/json")
			.body(map)
		
		.when()
			.post()
			
		.then()
		.extract().response();
		
		int status_code=response.getStatusCode();
		System.out.println("status code----->"+status_code);
		
	}

}
