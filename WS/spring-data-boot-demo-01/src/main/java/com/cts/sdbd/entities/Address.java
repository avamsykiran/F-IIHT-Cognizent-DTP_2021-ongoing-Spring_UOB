package com.cts.sdbd.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name="address_line")
	private String addressLine;
	@Column(name="city")
	private String city;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String addressLine, String city) {
		super();
		this.addressLine = addressLine;
		this.city = city;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addressLine=" + addressLine + ", city=" + city + "]";
	}
	
	
}
