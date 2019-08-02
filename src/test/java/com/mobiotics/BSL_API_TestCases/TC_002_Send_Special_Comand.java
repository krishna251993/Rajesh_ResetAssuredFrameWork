package com.mobiotics.BSL_API_TestCases;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class TC_002_Send_Special_Comand extends TestBAse {
	
	@Test(priority=2)
	void sendSpecialCommand() throws InterruptedException {
		loginToPortal();
		
		//System.out.println(auth);
		log.info("*************************************************statrted Send Special Command***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/SendSpecialCommandToDevice";
		//httpRequest=new RestAssured().given();
		response=
				
		RestAssured.given()
		
		.queryParam("deviceId", deviceID)
		.queryParam("reasonId", reasonID)
		.header("Content-Type", "application/json")
		.header("Authorization", auth)
		
		
		.when()
			.post()
		
		
		.then()
			.extract().response();
		System.out.println("Authorization Key---"+auth);
		int status_Code=response.getStatusCode();
		System.out.println("status code"+status_Code);
		
		
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
