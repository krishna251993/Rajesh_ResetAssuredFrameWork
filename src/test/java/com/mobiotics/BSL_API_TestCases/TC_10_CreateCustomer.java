package com.mobiotics.BSL_API_TestCases;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC_10_CreateCustomer extends TestBAse {
	
	HashMap map= new HashMap();
	@Test
	public void createCustomer() throws InterruptedException {
		loginToPortal();
		map.put("AccountTypeId", "1");
		map.put("ClassId", "3");
		ArrayList<String> CommercialProducts= new ArrayList<String>();
		CommercialProducts.add("935");
		CommercialProducts.add("2");
		
		map.put("CommercialProductIds", CommercialProducts);
		map.put("ContactPhone", "9511597535");
		ArrayList<String> deviceIds= new ArrayList<String>();
		
		deviceIds.add("478093");
		map.put("DeviceIds", deviceIds);
		map.put("Extra", "johoo");
		map.put("LcoBuDescription", "LCO200000955");
		map.put("ExemptionCodeId", "1");
		map.put("FirstName", "Sunil");
		map.put("LastName", "Hudgi(girl)");
		map.put("TypeId", "21");
		map.put("ValidAddressId", "10659");
		
		log.info("*************************************************Create Customer***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/Customer";
		
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
		
		for(Header header:allHeaders) {
			log.info(header.getName()+":"+header.getValue());
		}
		
		log.info("****************************************checking Response Time*************************************");
		long responseTime=response.getTime();
		log.info("Response Time--->"+responseTime);
		
		
	}
	
	

}
