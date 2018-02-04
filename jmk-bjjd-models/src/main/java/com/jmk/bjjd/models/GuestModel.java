package com.jmk.bjjd.models;

import javax.validation.Valid;


public class GuestModel extends UserModel{
	
	@Valid
	private AddressModel address;
	
	private MemberModel referredBy;
	
	public GuestModel(){
		
	}
	
	public GuestModel(String id){
		setId(id);
	}

	/**
	 * @return the address
	 */
	public AddressModel getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(AddressModel address) {
		this.address = address;
	}

	/**
	 * @return the referredBy
	 */
	public MemberModel getReferredBy() {
		return referredBy;
	}

	/**
	 * @param referredBy the referredBy to set
	 */
	public void setReferredBy(MemberModel referredBy) {
		this.referredBy = referredBy;
	}
	
	
	
	
}
