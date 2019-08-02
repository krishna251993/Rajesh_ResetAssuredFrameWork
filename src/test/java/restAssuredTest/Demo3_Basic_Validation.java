package restAssuredTest;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * 
 * Test Status code
 * Log Response
 * Verifiying the single content in the response body
 * Setting parameter and headers
 * 
 * 
 * 
 */

public class Demo3_Basic_Validation {
	
	@Test(priority=1)
	public void testStatusCode() {
		
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/post/5")
			
		.then()
			.statusCode(200)
			.log().all();
		
		
		
	}
	//Log Response
	@Test(priority=2)
	public void testLogging() {
		given()
		
		.when()
			.get("http://service.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(404)
			.log().all();
	}
	
	//Verifiying the single content in the response body
	
	@Test(priority=3)
	public void testSinglecontent() {
		
       given()
		
		.when()
			.get("http://service.groupkt.com/country/get/iso2code/IN")
		.then()
			.statusCode(404)
			.body("RestResponse.result.name", equalTo("India"));
		
	}
	//4 Verivying the multiple content from the response body
	@Test(priority=4)
	public void testMultipleContent() {
	       given()
			
			.when()
				.get("http://service.groupkt.com/country/get/all")
			.then()
				
				.body("RestResponse.result.name", hasItems("India","Australia","United state of America"));
	}
	
	//5 Setting the parameters and Header in the request
	@Test
	public void testPramsAndHeaders() {
		given()
			.params("MyName", "Rajesh")
			.header("MyHeader", "India")
		.when()
			.get("http://service.groupkt.com/country/get/all")
		.then()
			
			.log().all();
	}
	
	
}
