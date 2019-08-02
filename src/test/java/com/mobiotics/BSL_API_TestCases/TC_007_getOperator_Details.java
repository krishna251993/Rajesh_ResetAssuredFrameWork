package com.mobiotics.BSL_API_TestCases;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC_007_getOperator_Details extends TestBAse{
	@Test
	void getOperatorDetails() throws InterruptedException {
		loginToPortal();
		log.info("*************************************************Get Operator Details***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/CustomersPerLCO";
		response=
		(Response) RestAssured.given()
		.queryParam("lcoBuDescription", "lco200000955")
		.queryParam("page", "1")
		.queryParam("pageSize", "20")
		.header("Authorization", auth)
		
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
