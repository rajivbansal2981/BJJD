package com.jmk.bjjd.util.testdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jmk.bjjd.enums.AddressType;
import com.jmk.bjjd.enums.Day;
import com.jmk.bjjd.enums.DayNumberInMonth;
import com.jmk.bjjd.enums.PersonType;
import com.jmk.bjjd.models.AddressModel;
import com.jmk.bjjd.models.CollectionModel;
import com.jmk.bjjd.models.GuestModel;
import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.models.SevaCategoryModel;
import com.jmk.bjjd.models.SevaModel;
import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.util.TimeUtility;

public class SQLTestDataUtil {

	public static List<CollectionModel> createCollection(){
		List<CollectionModel> collections=new ArrayList<CollectionModel>();
		CollectionModel collection=new CollectionModel();
		collection.setId("-1001");
		collection.setGuest(new GuestModel("-11111"));
		collection.setMonth("MAR");
		collection.setYear(2017);
		collection.setSubmittedOn(new Date());
		collection.setMonthlyAmount(5000);
		collection.setPersonType(PersonType.GUEST);
		collection.setProjectAmount(5000);
		collection.setTotalAmount(10000);
		collection.setWhenCreated(new Date());
		collections.add(collection);
		collection=new CollectionModel();
		collection.setId("-1002");
		collection.setMember(new MemberModel("-99999"));
		collection.setMonth("MAR");
		collection.setYear(2015);
		collection.setSubmittedOn(new Date());
		collection.setMonthlyAmount(5000);
		collection.setPersonType(PersonType.MEMBER);
		collection.setProjectAmount(5000);
		collection.setTotalAmount(10000);
		collection.setWhenCreated(new Date());
		collections.add(collection);
		collection=new CollectionModel();
		collection.setId("-1003");
		collection.setMember(new MemberModel("-99999"));
		collection.setMonth("MAR");
		collection.setYear(2015);
		collection.setSubmittedOn(new Date());
		collection.setMonthlyAmount(6000);
		collection.setPersonType(PersonType.MEMBER);
		collection.setProjectAmount(5000);
		collection.setTotalAmount(11000);
		collection.setWhenCreated(new Date());
		collections.add(collection);
		return collections;
	}
	
	public static MemberModel createMember(String id){
		MemberModel member=new MemberModel(id);
		
		//Setting Roles
		List<RoleModel> roles=new ArrayList<RoleModel>();
		roles.add(new RoleModel("RL001"));
		roles.add(new RoleModel("RL002"));
		roles.add(new RoleModel("RL003"));
		//Setting Address Object
		AddressModel permanentAddress=new AddressModel();
		permanentAddress.setId("-1123");
		permanentAddress.setMember(member);
		permanentAddress.setFlatNo("294");
		permanentAddress.setStreetNo("9");
		permanentAddress.setAddressType(AddressType.PERMANENT);
		permanentAddress.setAddressLine1("Chanderlok Colony,Durgapuri Ext.");
		permanentAddress.setCity("Shahadra");
		permanentAddress.setState("Delhi");
		permanentAddress.setPinCode("110093");
		permanentAddress.setLandmark("Navin Bharti Public School");
		permanentAddress.setWhenCreated(TimeUtility.getSystemDate());
		permanentAddress.setCreatedBy("BJJDJKYV0060");
		permanentAddress.setWhenUpdated(TimeUtility.getSystemDate());
		permanentAddress.setUpdatedBy("BJJDJKYV0060");
		permanentAddress.setTenantId(9L);
		
		//Seva Objects for Antrik Seva
		SevaModel seva1=new SevaModel();
		seva1.setId("-11111");
		seva1.setApplicable(Boolean.TRUE);
		seva1.setCreatedBy("rajivbansal2981");
		seva1.setDay(Day.SAT);
		seva1.setDayNumberInMonth(DayNumberInMonth.ALL);
		seva1.setMember(member);
		seva1.setSevaCategory(new SevaCategoryModel("SVC01"));
		seva1.setWhenCreated(TimeUtility.getSystemDate());
		seva1.setCreatedBy("BJJDJKYV0060");
		seva1.setWhenUpdated(TimeUtility.getSystemDate());
		seva1.setUpdatedBy("BJJDJKYV0060");
		seva1.setTenantId(9L);
		
		List<SevaModel> sevas=new ArrayList<SevaModel>();
		sevas.add(seva1);
		
		member.setFirstName("Rajiv");
		member.setLastName("Bansal");
		member.setPermanentAddress(permanentAddress);
		member.setWhenUpdated(new Date());
		member.setMobileNo1("9999779379");
		member.setActive(true);
		member.setJoiningDate(new Date());
		member.setRoles(roles);
		member.setSevas(sevas);
		member.setWhenCreated(TimeUtility.getSystemDate());
		member.setCreatedBy("BJJDJKYV0060");
		member.setWhenUpdated(TimeUtility.getSystemDate());
		member.setUpdatedBy("BJJDJKYV0060");
		member.setTenantId(9L);
		return member;
	}
	
	public static List<GuestModel> createGuests(){
		List<GuestModel> guests=new ArrayList<GuestModel>();
		AddressModel address=new AddressModel();
		address.setFlatNo("294");
		address.setStreetNo("9");
		GuestModel guest=new GuestModel();
		guest.setId("-1001");
		guest.setFirstName("ABCD");
		guest.setReferredBy(new MemberModel("-10005"));
		guest.setAddress(address);
		guest.setMobileNo1("999999999");
		guest.setCreatedBy("asdf");
		guests.add(guest);
		guest=new GuestModel();
		guest.setId("-1002");
		guest.setFirstName("ABCD");
		guest.setReferredBy(new MemberModel("-10005"));
		guest.setAddress(address);
		guest.setMobileNo1("999999999");
		guest.setCreatedBy("asdf");
		guests.add(guest);
		guest=new GuestModel();
		guest.setId("-1003");
		guest.setFirstName("ABCD");
		guest.setReferredBy(new MemberModel("-10005"));
		guest.setAddress(address);
		guest.setMobileNo1("999999999");
		guest.setCreatedBy("asdf");
		guests.add(guest);
		return guests;
	}
	
	public static UserModel createUser(String userId){
		UserModel user =new MemberModel();
		user.setId(userId);
		user.setUserName("rajivbansal2981");
		user.setPassword("rajiv379");
		user.setTenantId(9L);
		return user;
	}

	
}
