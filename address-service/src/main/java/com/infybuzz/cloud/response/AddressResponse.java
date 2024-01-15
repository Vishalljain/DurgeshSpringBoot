package com.infybuzz.cloud.response;

import com.infybuzz.cloud.entity.Address;

public class AddressResponse {
	private long addressId;
	private String street;
	private String city;
	
	//we will have one constructor to convert the object of address entity class to this model class that is address response.java 
	public AddressResponse(Address address) {
		super();
		this.addressId = address.getId();
		this.street = address.getStreet();
		this.city = address.getCity();
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
