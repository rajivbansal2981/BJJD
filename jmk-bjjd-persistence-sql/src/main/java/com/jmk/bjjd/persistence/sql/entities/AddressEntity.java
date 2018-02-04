package com.jmk.bjjd.persistence.sql.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jmk.bjjd.enums.AddressType;

@Table(name="ADDRESS")
@Entity
public class AddressEntity extends BaseEntity{
	
	@Column(name="FLATNO")
	private String flatNo;
	
	@Column(name="STREETNO")
	private String streetNo;
	
	@Column(name="ADDRESSLINE1")
	private String addressLine1;
	
	@Column(name="ADDRESSLINE2")
	private String addressLine2;
	
	@Column(name="LANDMARK")
	private String landmark;

	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "PINCODE")
	private String pinCode;
	
	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private AddressType addressType; 
	
	@OneToOne
	@JoinColumn(name="MEMBERID",referencedColumnName="ID")
	private MemberEntity member;
	
	@ManyToOne
	@JoinColumn(name="GUESTID",referencedColumnName="ID")
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
