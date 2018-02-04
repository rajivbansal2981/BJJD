package com.jmk.bjjd.web.utils;

import java.util.Calendar;
import java.util.Date;

import com.jmk.bjjd.models.BaseModel;
import com.jmk.bjjd.models.UserModel;

public final class SetDefaultFieldsUtility {

	private SetDefaultFieldsUtility(){
		
	}
	
	public static void setDefaultFieldsWhileCreating(BaseModel baseModel,UserModel userModel){
		Date currentDate=Calendar.getInstance().getTime();
		baseModel.setCreatedBy(userModel.getUserName());
		baseModel.setUpdatedBy(userModel.getUserName());
		baseModel.setWhenCreated(currentDate);
		baseModel.setWhenUpdated(currentDate);
		baseModel.setTenantId(userModel.getTenantId());
	}
	
	public static void setDefaultFieldsWhileUpdating(BaseModel baseModel,UserModel userModel){
		Date currentDate=Calendar.getInstance().getTime();
		baseModel.setUpdatedBy(userModel.getUserName());
		baseModel.setWhenUpdated(currentDate);
		baseModel.setTenantId(userModel.getTenantId());
	}
	
}
