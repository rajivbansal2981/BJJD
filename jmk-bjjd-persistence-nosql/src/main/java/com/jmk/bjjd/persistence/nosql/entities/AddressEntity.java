package com.jmk.bjjd.persistence.nosql.entities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.jmk.bjjd.enums.AddressType;

@Document
public class AddressEntity {
	@Field("flatNo")
	private String flatNo;
	
	@Field("streetNo")
	private String streetNo;
	
	@Field("addressLine1")
	private String addressLine1;
	
	@Field("addressLine2")
	private String addressLine2;
	
	private String landmark;

	private String city;
	
	private String state;
	
	@Field("pinCode")
	private String pinCode;
	
	@Field("addressType")
	private AddressType addressType; 
	
	@DBRef
	private MemberEntity member;
	
	@DBRef
	private GuestEntity guest;

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @return the addressType
	 */
	public AddressType getAddressType() {
		return addressType;
	}

	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	/**
	 * @return the member
	 */
	public MemberEntity getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(MemberEntity member) {
		this.member = member;
	}

	/**
	 * @return the guest
	 */
	public GuestEntity getGuest() {
		return guest;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(GuestEntity guest) {
		this.guest = guest;
	}

	
}
