package com.mobiotics.BSL_API_TestCases;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC_13_Create_PaymentFT extends TestBAse {

	HashMap map = new HashMap();

	@Test
	void create_PaymentFT() throws InterruptedException {
		loginToPortal();
		map.put("BaseAmount", "1000.0");
		map.put("Comments", "LCO201");
		map.put("CustomerId", "1040429819");
		map.put("FinancialAccountTypeID", "2");
		map.put("LedgerAccountId", "44");
		map.put("TransactionCode", "123188231290");
		map.put("Extended", "sample string 3");
		
		
		log.info("*************************************************Create Payment FT***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/MakePayment";
		response=
		(Response) RestAssured.given()
		
			.body(map)
			.header("Content-Type", "application/json")
			.header("Authorization", auth)
			
		.when()
		
			.post()
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
