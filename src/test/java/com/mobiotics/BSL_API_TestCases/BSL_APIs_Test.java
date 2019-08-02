package com.mobiotics.BSL_API_TestCases;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mobiotics.BSL_API.BasePack.TestBAse;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class BSL_APIs_Test extends TestBAse {
	
	public static String generatedAuth;
	
	//@BeforeClass
	@Test(priority=1)
	void getLogOnToPortal() throws InterruptedException {
		log.info("*************************************************statrted Log on to the Portal***************");
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
		
		log.info("****************************************checking Response Body********************************************************");
		String response_Body=response.getBody().asString();
		log.info("Response Body---"+response_Body);
		
		
		log.info("****************************************checking Status code***********************************************************");
		int statusCode=response.getStatusCode();
		log.info("status code="+statusCode);
		
		
		log.info("****************************************Fetching All Headers*******************************************");
		Headers allHeaders=response.headers();
		
		auth=response.header("Authorization");
		generatedAuth=auth;
		System.out.println("Authorization Key:-"+auth);
		for(Header header:allHeaders) {
			log.info(header.getName()+":"+header.getValue());
		}
		
		log.info("****************************************checking Response Time*************************************");
		long responseTime=response.getTime();
		log.info("Response Time--->"+responseTime);
		
		
		
}
	
	@Test(priority=2)
	public void sendSpecialCommand() {
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
	public void TC_003_Get_Available_Comercial_ProductFOrOperator() {
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
	
	@Test(priority=4)
	public void TC_004_GetCustomerProductDetails() {
		log.info("*************************************************GetCustomerProductDetails***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/Products";
		response=
		RestAssured.given()
		.queryParam("customerId", customerId)
		//.header("Authorization", "Bearer ", auth)
		
		.header("Authorization", auth)
		//.header("Content-Type", "application/x-www-form-urlencoded")
		
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
	
	
	@Test(priority=5)
	public void TC_006_GetCustomerDetails() {
		log.info("*************************************************TC_006_GetCustomerDetails***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/LCOCustomerDetails";
		//httpRequest= new RestAssured().given();
		response=
		given()
		.queryParam("customerId", customerId)
		.header("Authorization", auth)
		//.header("Authorization", "Bearer ", auth)
		//.header("Authorization","{{"+auth+"}}")
		//.header("Content-Type", "application/x-www-form-urlencoded")
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
	
	@Test(priority=6)
	public void TC_007_getOperator_Details() {
		log.info("*************************************************Get Operator Details***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/CustomersPerLCO";
		response=
		(Response) RestAssured.given()
		.queryParam("lcoBuDescription", "lco200000955")
		.queryParam("page", "1")
		.queryParam("pageSize", "20")
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
	
	/*
	
	@Test(priority=7)
	public void TC_008_Update_CustomerDetails() throws InterruptedException {
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
	
	
	*/
	
	    @Test(priority=8)
		public void addProductToCustomer() {
			HashMap map= new HashMap();
		
			map.put("AgreementId", "2501024");
			System.out.println("AgreementId====="+AgreementId);
			ArrayList<String> CommercialProducts= new ArrayList<String>();
			CommercialProducts.add("877");
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
	
	
	@Test(priority=9)
	public void TC_10_CreateCustomer() {
		HashMap map= new HashMap();
		map.put("AccountTypeId", "1");
		map.put("ClassId", "3");
		ArrayList<String> CommercialProducts= new ArrayList<String>();
		CommercialProducts.add("238");
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
	
	
	/*
	@Test(priority=10)
	public void TC_11_GetFinancialAccount() {
		log.info("*************************************************Get Financial Account***************");
		initFrameWork();
		String  searchParameter="CAN"+"1040803669";
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/FinancialAccounts";
		response=
		(Response) RestAssured.given()
			.queryParam("searchParameter", searchParameter)
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
	
	
	
	@Test(priority=11)
	public void TC_12_GetFinancial_Transection() {
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
	
	
	@Test(priority=12)
	public void TC_13_Create_PaymentFT() {
		HashMap map=new HashMap();
		map.put("BaseAmount", "1000.0");
		map.put("Comments", "LCO201");
		map.put("CustomerId", "1001506184");
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
	
	
	*/
		
	
	
}
