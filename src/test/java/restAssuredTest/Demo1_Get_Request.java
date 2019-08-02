package restAssuredTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * give()
 * 	set cookie , add auth, add param, set headers   info etc
 * 
 * when()
 * 	get, post , delete , put
 * 
 * then()
 *  		validate the status code, extract the response,extract the header,cookies & respionse body
 
 */

public class Demo1_Get_Request {
	@Test
	public void get_WeatherDetail() {
		Response response=
		given()
		.when()
			.get("http://restapi.demoqa.com/utlities/weather/city/");
			
		int status_code=response.getStatusCode();
		System.out.println(status_code);
		
	}

}
