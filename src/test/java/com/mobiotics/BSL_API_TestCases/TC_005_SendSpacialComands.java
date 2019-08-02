package com.mobiotics.BSL_API_TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class TC_005_SendSpacialComands extends TestBAse {
	
	@Test(priority=5)
	public void postData() {
		/*
		log.info("*************************************************Send Special Command***************");
		initFrameWork();
		RestAssured.baseURI="https://172.21.60.31";
		RestAssured.basePath="/WSM/api/Bsl/SendSpecialCommandToDevice";
		
		Response response=
				given()
					
					.contentType("application/json")
					.queryParam("deviceId", "81121")
					.queryParam("reasonId", "147884")
					.header("Authorization", auth)
					
				
				
				
				.when()
					.post()
				
				
				.then()
					.extract().response();
					int status_Code=response.getStatusCode();
					System.out.println(status_Code);
					
					
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
*/
	}
	

}
