package restAssuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
/*
 * Verifying the single content in XML response
 * Verifying the multiple content in the XML respoinse
 * Verifying the multiple content in XML response in one go
 * Find Value using the XML path in XML response
 * xpath with text()
 * 
 * 
 * 
 */

public class DemoValidationOnXMLResponse {

	//Verifying the single content in XML response
	//@Test
	public void testSingleContent() {
		given()
			
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER .ID", equalTo("15"))
			.log().all();
		
	}
	
	//2 Verifying the multiple content in the XML respoinse
	//@Test(priority=2)
	public void testMultipleContent() {
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER .ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.body("CUSTOMER.STREET", equalTo("319 Upland Pl."));
	}
	
	//3.Verifying the multiple content in XML response in one go
	
	//@Test
	public void multipleContentInOneGo() {
given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy 319 Upland Pl."));
			
	}
	
	//4.Find Value using the XML path in XML response
	//@Test
	public void testUsingXpath1() {
        given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
	}
	
	//
	@Test
	public void testUsingXpath2() {
given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
	}
	
	
}
