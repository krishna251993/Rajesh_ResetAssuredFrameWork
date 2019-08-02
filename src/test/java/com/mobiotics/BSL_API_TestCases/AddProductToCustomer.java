package com.mobiotics.BSL_API_TestCases;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.mobiotics.BSL_API.BasePack.AddProduct;
import com.mobiotics.BSL_API.BasePack.TestBAse;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AddProductToCustomer extends TestBAse{
	/**
	 * 
	 */
	@BeforeClass
	public void addProductSrelization() {
		ArrayList<String> comercialProducts=new ArrayList<String>();
		comercialProducts.add("877");
		
		AddProduct addProduct=new AddProduct();
		addProduct.setId("2501024");
		addProduct.setComercialProduct(comercialProducts);
		addProduct.setReasonId("2765");
		addProduct.setExtended("sample string 1");
		
		log.info("*************************************************GetCustomerProductDetails***************");
		initFrameWork();
		RestAssured.baseURI=BaseURI;
		RestAssured.basePath="/WSM/api/Bsl/AddProducts";
		
		response=
				(Response) RestAssured.given()
				.body(addProduct)
				.header("Content-Type", "application/json")
				.header("Authorization", auth)
				
		
		.when()
			.post()
		
		.then()
			.extract().response();
		
	}
	@Test
	void checkResponseBody() {
		
		log.info("****************************************checking Response Body********************************************************");
		String response_Body=response.getBody().asString();
		log.info("Response Body---"+response_Body);
	}
	
	
	@Test
	void checkStatusCode() {
		log.info("****************************************checking Status code***********************************************************");
		int statusCode=response.getStatusCode();
		log.info("status code="+statusCode);
		
	}
	
	@Test
	void getAllHeaders() {
		log.info("****************************************Fetching All Headers*******************************************");
		Headers allHeaders=response.headers();
		
		for(Header header:allHeaders) {
			log.info(header.getName()+":"+header.getValue());
		}
	}
	
	@Test
	void checkingResponseTime() {
		log.info("****************************************checking Response Time*************************************");
		long responseTime=response.getTime();
		log.info("Response Time--->"+responseTime);
	}


	
}
