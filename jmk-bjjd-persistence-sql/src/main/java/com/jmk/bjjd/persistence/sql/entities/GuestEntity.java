package com.jmk.bjjd.persistence.sql.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="GUEST")
public class GuestEntity extends UserEntity{
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="guest")
	private Set<AddressEntity> addresses;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name="REFERREDBY",referencedColumnName="ID")
 	private MemberEntity referredBy;
	
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

	/**
	 * @return the referredBy
	 */
	public MemberEntity getReferredBy() {
		return referredBy;
	}

	/**
	 * @param referredBy the referredBy to set
	 */
	public void setReferredBy(MemberEntity referredBy) {
		this.referredBy = referredBy;
	}
	

	

}
