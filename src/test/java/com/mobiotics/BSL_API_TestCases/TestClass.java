package com.mobiotics.BSL_API_TestCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestClass extends TestBAse{
	
	 String auth1=null;
	
public void  createAuth() throws InterruptedException {
	initFrameWork();
	
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
	Headers allHeaders=response.headers();
	
	auth1=response.header("Authorization");
	}
	
	@Test(priority=1)
	public void getLogOnToPortal() throws InterruptedException {
		
		log.info("*************************************************statrted Log on to the Portal***************");
		initFrameWork();
		//loginToPortal();
		//System.out.println("Authorization Key-----"+auth);
		//createAuth();
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
	
	@Test(priority=2)
	void sendSpecialCommand() throws InterruptedException {
		//createAuth();
		//loginToPortal();
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
		.header("Authorization", auth1)
		
		
		.when()
			.post()
		
		
		.then()
			.extract().response();
		System.out.println("Authorization Key---"+auth);
		int status_Code=response.getStatusCode();
		System.out.println("status code"+status_Code);
		System.out.println("Authorization Key="+BSL_APIs_Test.generatedAuth);
		
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
	
	@Test(priority=3)
	void getAvailableComercialProduct() throws InterruptedException {
		//loginToPortal();
		log.info("*************************************************Get_Available_Comercial_ProductFOrOperator***************");
		initFrameWork();
		//createAuth();
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
		
		
		.header("Authorization", auth1)
		.header("Content-Type", "application/x-www-form-urlencoded")
		
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
