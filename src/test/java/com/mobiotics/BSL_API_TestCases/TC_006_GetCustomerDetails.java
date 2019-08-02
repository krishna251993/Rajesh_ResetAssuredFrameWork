package com.mobiotics.BSL_API_TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class TC_006_GetCustomerDetails extends TestBAse{
	
	@Test(priority=6)
	void getCustomerDetails() throws InterruptedException {
		loginToPortal();
		log.info("*************************************************TC_006_GetCustomerDetails***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/LCOCustomerDetails";
		//httpRequest= new RestAssured().given();
		response=
		given()
		.queryParam("customerId", customerId)
		.header("Authorization", auth)
		//.header("Authorization", "Bearer ", auth)
		//.header("Authorization","{{"+auth+"}}")
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
		//auth=response.header("Authorization");
		//System.out.println("Authorization Key:-"+auth);
		for(Header header:allHeaders) {
			log.info(header.getName()+":"+header.getValue());
		}
		
		log.info("****************************************checking Response Time*************************************");
		long responseTime=response.getTime();
		log.info("Response Time--->"+responseTime);
		
		
		
	}
	

}
