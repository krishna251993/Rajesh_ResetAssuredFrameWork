package com.mobiotics.BSL_API_TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class TC_003_Get_Available_Comercial_ProductFOrOperator extends TestBAse{

	
	@Test(priority=3)
	void getAvailableComercialProduct() throws InterruptedException {
		//loginToPortal();
		log.info("*************************************************Get_Available_Comercial_ProductFOrOperator***************");
		initFrameWork();
		
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/AvailableCommercialProductsForLco";
		//httpRequest= new RestAssured().given();
		response=
		RestAssured.given()
		.queryParam("lcoBuDescription", lcoBuDescription)
		.queryParam("productCatagoryId", productCatagoryId)
		.queryParam("page", page)
		.queryParam("pageSize", pageSize)
		.queryParam("customerClassId", customerClassId)
		.queryParam("customerTypeId", customerTypeId)
		.queryParam("postalCode", postalCode)
		
		
		.header("Authorization", auth)
		.header("Content-Type", "application/x-www-form-urlencoded")
		
		.when()
			.get()
		.then()
			.extract().response();
		
		
		log.info("****************************************checking Response Body********************************************************");
		
		System.out.println("Authorization Key---"+auth);
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
