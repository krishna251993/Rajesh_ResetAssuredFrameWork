package com.mobiotics.BSL_API.BasePack;

import java.util.List;

public class AddProduct {

	public String agreementId;
	List<String> comercialProducts;
	public String reasonId;
	public String extended;
	
	
	public String getID() {
		return agreementId;
	}
	
	public void setId(String agreementId ) {
		this.agreementId=agreementId;
		
	}
	public String getReasonId() {
		return reasonId;
	}
	public void setReasonId(String reasoId) {
		this.reasonId=reasoId;
	}
	public String getExtended() {
		return extended;
	}
	
	public void setExtended(String extended) {
		this.extended=extended;
	}
	
	public List<String> getComercialProduct(){
		return comercialProducts;
	}
	public void setComercialProduct(List<String> comercialProducts) {
		this.comercialProducts=comercialProducts;
	}
}
