package com.mobiotics.BSL_API_TestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;

public class TC_008_Update_CustomerDetails extends TestBAse {
	@Test
	void updateCustomerDetails() throws InterruptedException {
		loginToPortal();
		
		log.info("*************************************************statrted Log on to the Portal***************");
		initFrameWork();
		
		RestAssured.baseURI=BaseURI;
		httpRequest=new RestAssured().given();
		//httpRequest=RestAssured.given();
		JSONObject requestParms=new JSONObject();
		requestParms.put("CustomerAddress", "{'LastName':'HE'}");
		
		requestParms.put("Id", "1040803669");
		httpRequest.header("Authorization", auth);
		httpRequest.body(requestParms.toJSONString());
		response=httpRequest.put("/WSM/api/Bsl/Customer");
		Thread.sleep(3000);
		
		
		log.info("****************************************checking Response Body********************************************************");
		String response_Body=response.getBody().asString();
		log.info("Response Body---"+response_Body);
		
		
		log.info("****************************************checking Status code***********************************************************");
		int statusCode=response.getStatusCode();
		log.info("status code="+statusCode);
		
		
	}
	
	

}
