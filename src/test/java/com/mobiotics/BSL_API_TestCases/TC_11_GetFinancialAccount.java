package com.mobiotics.BSL_API_TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC_11_GetFinancialAccount extends TestBAse{

	@Test
	public void getFinancialAccount() throws InterruptedException {
		loginToPortal();
		log.info("*************************************************Get Financial Account***************");
		initFrameWork();
		String  searchParameter="CAN"+"1040429819";
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/FinancialAccounts";
		response= 
		(Response) RestAssured.given()
			.queryParam("searchParameter", searchParameter)
			.header("Content-Type", "application/json")
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
