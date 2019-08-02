package com.mobiotics.BSL_API_TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC_12_GetFinancial_Transection extends TestBAse{

	@Test
	public void getFinancial_Transections() throws InterruptedException {
		loginToPortal();
		log.info("*************************************************Get Financial Transection***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/FinancialTransactions";
		
		response=
				(Response) RestAssured.given()
			.queryParam("customerId", customerId)
			.queryParam("finanAccountTypeId", "1")
			.queryParam("startDate", "2019-06-01")
			.queryParam("endDate", "2019-06-10")
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
