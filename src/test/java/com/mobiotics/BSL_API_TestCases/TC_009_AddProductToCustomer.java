package com.mobiotics.BSL_API_TestCases;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC_009_AddProductToCustomer extends TestBAse{
	HashMap map= new HashMap();
	@Test
	public void addProductToCustomer() throws InterruptedException {
		loginToPortal();
		map.put("AgreementId", "4027853");
		System.out.println("AgreementId====="+AgreementId);
		ArrayList<String> CommercialProducts= new ArrayList<String>();
		CommercialProducts.add("132");
		map.put("CommercialProducts", CommercialProducts);
		map.put("ReasonId", "2765");
		map.put("Extended", "sample string 1");
		
		log.info("*************************************************Add product To customer***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/AddProducts";
		response=
				(Response) RestAssured.given()
				
					.body(map)

					
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
