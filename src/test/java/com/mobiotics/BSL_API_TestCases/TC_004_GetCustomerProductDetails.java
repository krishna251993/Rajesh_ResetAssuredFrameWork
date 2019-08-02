package com.mobiotics.BSL_API_TestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;


public class TC_004_GetCustomerProductDetails extends TestBAse{
	@Test(priority=4)
	void getCustomerProductDetails() throws InterruptedException {
		loginToPortal();
		log.info("*************************************************GetCustomerProductDetails***************");
		//initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/Products";
		response=
		RestAssured.given()
		.queryParam("customerId", customerId)
		//.header("Authorization", "Bearer ", auth)
		
		.header("Authorization", auth)
		//.header("Content-Type", "application/x-www-form-urlencoded")
		
		.when()
			.get()
		.then()
			.extract().response();
		
		
		log.info("****************************************checking Response Body********************************************************");
		String response_Body=response.getBody().asString();
		log.info("Response Body---"+response_Body);
		
		log.info("****************************************checking Status code***********************************************************");
		int statusCode=response.getStatusCode();
		log.info("status code="+statusCode);
		
		
		log.info("****************************************Fetching All Headers*******************************************");
		Headers allHeaders=response.headers();
		
		for(Header header:allHeaders) {
			log.info(header.getName()+":"+header.getValue());
		}
		
		
		log.info("****************************************checking Response Time*************************************");
		long responseTime=response.getTime();
		log.info("Response Time--->"+responseTime);
	}
	
  

}
