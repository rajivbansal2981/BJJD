package com.jmk.bjjd.models;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import com.jmk.bjjd.enums.AddressType;


public class AddressModel extends BaseModel{
	private String flatNo;
	
	private String streetNo;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String landmark;

	private String city;
	
	@NotEmpty(message="Please enter the state")
	private String state;
	
	private String pinCode;
	
	private AddressType addressType;
	
	private MemberModel member;
	
	private GuestModel guest;

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * @return the member
	 */
	public MemberModel getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(MemberModel member) {
		this.member = member;
	}

	/**
	 * @return the guest
	 */
	public GuestModel getGuest() {
		return guest;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(GuestModel guest) {
		this.guest = guest;
	}

}
