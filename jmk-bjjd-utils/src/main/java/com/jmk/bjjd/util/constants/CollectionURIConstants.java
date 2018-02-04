package com.jmk.bjjd.util.constants;

public interface CollectionURIConstants {
	public static final String GET_COLLECTIONDETAILS_BY_ID="/rest/getcollectiondetailsbyid/{id}";
	
	public static final String SAVE_COLLECTION="/rest/savecollection";
	
	public static final String SAVE_COLLECTIONS="/rest/savecollections";
	
	public static final String UPDATE_COLLECTION="/rest/updatecollection";
	
	public static final String UPDATE_COLLECTIONS="/rest/updatecollections";
	
	public static final String DELETE_COLLECTION_BY_ID="/rest/deletecollectionbyid/{id}";
	
	public static final String DELETE_COLLECTIONS="/rest/deletecollection";
	
	public static final String FETCH_ALL_COLLECTIONS_BY_TENANTID="/rest/fetchallcollectionsbytenantid/{tenantId}";
	
	public static final String FETCH_COLLECTIONS_BY_MEMBERID="/rest/fetchcollectionsbymemberid/{memberId}";
	
	public static final String FETCH_COLLECTIONS_BY_GUESTID="/rest/fetchcollectionsbyguestid/{guestId}";
	
	public static final String FETCH_COLLECTIONS_BY_PERSONTYPE_AND_TENANTID="/rest/fetchcollectionsbypersontype/{personType}/{tenantId}";

}
