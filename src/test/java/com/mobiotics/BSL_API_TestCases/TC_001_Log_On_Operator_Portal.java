package com.mobiotics.BSL_API_TestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class TC_001_Log_On_Operator_Portal extends TestBAse{
	
	@Test(priority=1)
	public void getLogOnToPortal() throws InterruptedException {
		
		log.info("*************************************************statrted Log on to the Portal***************");
		initFrameWork();
		//loginToPortal();
		//System.out.println("Authorization Key-----"+auth);
		RestAssured.baseURI=BaseURI;
		httpRequest=new RestAssured().given();
		//httpRequest=RestAssured.given();
		JSONObject requestParms=new JSONObject();
		requestParms.put("UserName", un);
		requestParms.put("Password", pw);
		requestParms.put("Dsn", Dsn);
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParms.toJSONString());
		response=httpRequest.post("/WSM/api/Auth/IccUserLogin");
		Thread.sleep(3000);
		
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
