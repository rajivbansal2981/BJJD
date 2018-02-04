package com.jmk.bjjd.util.testdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class NoSQLTestDataUtil {

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
		//Setting Roles
		List<RoleModel> roles=new ArrayList<RoleModel>();
		roles.add(new RoleModel("1001"));
		roles.add(new RoleModel("1002"));
		roles.add(new RoleModel("1003"));
		//Setting Address Object
		AddressModel permanentAddress=new AddressModel();
		permanentAddress.setFlatNo("294");
		permanentAddress.setStreetNo("9");
		permanentAddress.setAddressLine1("Chanderlok Colony,Durgapuri Ext.");
		permanentAddress.setCity("Shahadra");
		permanentAddress.setState("Delhi");
		permanentAddress.setPinCode("110093");
		permanentAddress.setLandmark("Navin Bharti Public School");
		
		//Seva Objects for Antrik Seva
		SevaModel seva1=new SevaModel();
		seva1.setId("-11111");
		seva1.setApplicable(Boolean.TRUE);
		seva1.setCreatedBy("rajivbansal2981");
		seva1.setDay(Day.SAT);
		seva1.setDayNumberInMonth(DayNumberInMonth.ALL);
		seva1.setSevaCategory(new SevaCategoryModel("SV01"));
		
		List<SevaModel> sevas=new ArrayList<SevaModel>();
		sevas.add(seva1);
		MemberModel member=new MemberModel(id);
		member.setFirstName("Rajiv");
		member.setLastName("Bansal");
		member.setPermanentAddress(permanentAddress);
		member.setWhenUpdated(new Date());
		member.setActive(true);
		member.setJoiningDate(new Date());
		member.setRoles(roles);
		member.setSevas(sevas);
		member.setReportingLead(new MemberModel("BJJDJKYV"));
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
		List<RoleModel> roles=new ArrayList<RoleModel>();
		roles.add(new RoleModel("-1004"));
		UserModel user =new MemberModel();
		user.setId(userId);
		user.setUserName("rajivbansal2981");
		user.setPassword("rajiv379");
		user.setRoles(roles);
		user.setActive(true);
		return user;
	}

	
}
