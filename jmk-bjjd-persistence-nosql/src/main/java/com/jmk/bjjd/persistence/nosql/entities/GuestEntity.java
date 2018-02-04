package com.jmk.bjjd.persistence.nosql.entities;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="guest")
public class GuestEntity extends UserEntity{
	
	@DBRef
	private Set<AddressEntity> addresses;
	
	
	public GuestEntity(){
		
	}
	
	public GuestEntity(String key){
		setId(key);
	}

	/**
	 * @return the addresses
	 */
	public Set<AddressEntity> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(Set<AddressEntity> addresses) {
		this.addresses = addresses;
	}

	@Override
	public List<RoleEntity> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoles(List<RoleEntity> roles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean getActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setActive(Boolean active) {
		// TODO Auto-generated method stub
		
	}
	

}
