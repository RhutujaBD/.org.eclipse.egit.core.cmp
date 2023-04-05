package com.example.address;

public class Address {
	private String currentAddress;
	private String permanentAddress;
	public String getCurrentAddress() {
		return currentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String currentAddress, String permanentAddress) {
		super();
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
	}

	@Override
	public String toString() {
		return currentAddress+","+ permanentAddress;
	}

	
		
	
}
