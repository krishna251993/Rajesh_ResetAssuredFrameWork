package com.mobiotics.BSL_API.BasePack;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;

import generic.Property;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mobiotics.lco.constant.AutomationConstants;

public class TestBAse implements AutomationConstants{
	
	public static RequestSpecification httpRequest;
	public static Response response;
	
	public String BaseURI;
	public String un;
	public String pw;
	
	public String deviceID;
	public String reasonID;
	
	public String Dsn;
	public String customerId;
	public  String auth;
	
	public String lcoBuDescription;
	public String productCatagoryId;
	public String page;
	public String pageSize;
	public String customerClassId;
	public String customerTypeId;
	public String postalCode;
	public String AgreementId;
	
	
	
	public Logger log;
	
	
	public TestBAse() {
		PropertyConfigurator.configure("log4j.properties");
		log=Logger.getLogger(this.getClass());
		Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);
	}
	
	public void initFrameWork() {
		log.info("initilizing framework");
		BaseURI=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "baseURI");
		un=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "UserName");
		pw=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Password");
		Dsn=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "Dsn");
		deviceID=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "deviceId");
		reasonID=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "reasonId");
		customerId=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "costomerId");
		//auth=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "auth");
		lcoBuDescription=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "lcoBuDescription");
		productCatagoryId=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "productCatagoryId");
		page=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "page");
		pageSize=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "pageSize");
		customerClassId=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "customerClassId");
		customerTypeId=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "customerTypeId");
		postalCode=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "postalCode");
		AgreementId=Property.getPropertyValue(CONFIG_PATH+CONFIG_FILE, "AgreementId");		
	
	}
	
	public void loginToPortal() throws InterruptedException {
		
			initFrameWork();
			
			RestAssured.baseURI=BaseURI;
			httpRequest=new RestAssured().given();
			httpRequest=RestAssured.given();
			JSONObject requestParms=new JSONObject();
			requestParms.put("UserName", un);
			requestParms.put("Password", pw);
			requestParms.put("Dsn", Dsn);
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(requestParms.toJSONString());
			response=httpRequest.post("/WSM/api/Auth/IccUserLogin");
			Thread.sleep(3000);
			Headers allHeaders=response.headers();
			
			auth=response.header("Authorization");

			
			/*
			System.out.println("Authorization Key:-"+auth);
			for(Header header:allHeaders) {
				log.info(header.getName()+":"+header.getValue());
			}
			
			
			long responseTime=response.getTime();
			log.info("Response Time--->"+responseTime);
			*/

			
		}


	
	
	
	}
	
	


