package com.jmk.bjjd.web.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.models.SevaModel;
import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.util.constants.MemberURIConstants;
import com.jmk.bjjd.web.facade.MemberMgmtServiceFacade;
import com.jmk.bjjd.web.utils.SetDefaultFieldsUtility;
import com.jmk.bjjd.web.utils.UserUtility;

@Component("memberMgmtServiceFacade")
public class DefaultMemberMgmtServiceFacade implements MemberMgmtServiceFacade{
	
	@Value("${webservice.url}")
	private String webServiceURL;

	@Override
	public MemberModel saveRecord(MemberModel model) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			model = restTemplate.postForObject(webServiceURL
					+ MemberURIConstants.SAVE_MEMBER, prepareMemberModel(model), MemberModel.class);
		} catch (RestClientException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		return model;
	}

	@Override
	public MemberModel updateRecord(MemberModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberModel> fetchAllRecords(Long tenantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecordById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberModel findRecordByKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberModel> saveRecords(List<MemberModel> records) {
		RestTemplate restTemplate=new RestTemplate();
		return null;
	}

	@Override
	public void deleteRecords(List<MemberModel> records) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoleModel> findRolesByTenantId(Long tenantId) {
		RestTemplate restTemplate=new RestTemplate();
		List<HttpMessageConverter<?>> msgConverters=restTemplate.getMessageConverters();
		msgConverters.add(new MappingJackson2HttpMessageConverter());
		List<RoleModel> roles=restTemplate.getForObject(webServiceURL+MemberURIConstants.FETCH_ROLES_BY_TENANTID, List.class,tenantId);
		return roles;
	}

	@Override
	public List<MemberModel> findTeamLeadersByTenantId(Long tenantId) {
		RestTemplate restTemplate=new RestTemplate();
		List<HttpMessageConverter<?>> msgConverters=restTemplate.getMessageConverters();
		msgConverters.add(new MappingJackson2HttpMessageConverter());
		List<MemberModel> teamLeaders=restTemplate.getForObject(webServiceURL+MemberURIConstants.FETCH_ALL_TEAMLEADERS_BY_TENANTID, List.class,tenantId);
		return teamLeaders;
	}
	
	protected MemberModel prepareMemberModel(MemberModel memberModel) throws NoSuchFieldException, SecurityException{
		UserModel userModel=UserUtility.getLoggedInUser().getUserModel();
		SetDefaultFieldsUtility.setDefaultFieldsWhileCreating(memberModel, userModel);
		if(memberModel.getMailingAddress()!=null){
			memberModel.getMailingAddress().setMember(memberModel);
			SetDefaultFieldsUtility.setDefaultFieldsWhileCreating(memberModel.getMailingAddress(), userModel);
		}
		if(memberModel.getPermanentAddress()!=null){
			memberModel.getPermanentAddress().setMember(memberModel);
			SetDefaultFieldsUtility.setDefaultFieldsWhileCreating(memberModel.getPermanentAddress(), userModel);
		}
		if(memberModel.getPhotoUpload()!=null){
			memberModel.getPhotoUpload().setMember(memberModel);
			SetDefaultFieldsUtility.setDefaultFieldsWhileCreating(memberModel.getPhotoUpload(), userModel);
		}
		for(SevaModel sevaModel:memberModel.getSevas()){
			sevaModel.setMember(memberModel);
			SetDefaultFieldsUtility.setDefaultFieldsWhileCreating(sevaModel, userModel);
		}
		return memberModel;
	}

}
