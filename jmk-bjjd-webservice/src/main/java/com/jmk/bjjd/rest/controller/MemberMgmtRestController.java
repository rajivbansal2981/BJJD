package com.jmk.bjjd.rest.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.service.MemberMgmtService;
import com.jmk.bjjd.util.constants.MemberURIConstants;

@RestController("memberMgmtRestController")
public class MemberMgmtRestController {

	@Resource(name="memberMgmtService")
	private MemberMgmtService service;
	
	@RequestMapping(value=MemberURIConstants.GET_MEMBERDETAILS_BY_ID,method=RequestMethod.GET)
	public MemberModel getMemberDetailsById(@PathVariable("id") String id){
		MemberModel memberModel=service.findRecordByKey(id);
		return memberModel;
	}
	
	@RequestMapping(value=MemberURIConstants.FETCH_ALL_MEMBERS_BY_TENANTID,method=RequestMethod.GET)
	public List<MemberModel> fetchAllMemberDetailsByTenantId(@PathVariable("tenantId") Long tenantId){
		List<MemberModel> memberModels=service.fetchAllRecordsByTenantId(tenantId);
		return memberModels;
	}
	
	@RequestMapping(value=MemberURIConstants.SAVE_MEMBER,method=RequestMethod.POST)
	public MemberModel saveMember(@RequestBody MemberModel memberModel){
		memberModel=service.saveRecord(memberModel);
		return memberModel;
	}
	
	@RequestMapping(value=MemberURIConstants.SAVE_MEMBERS,method=RequestMethod.POST)
	public void saveMembers(@RequestBody List<MemberModel> memberModels){
		service.saveRecords(memberModels);
	}
	
	@RequestMapping(value=MemberURIConstants.UPDATE_MEMBER,method=RequestMethod.POST)
	public MemberModel updateMember(@RequestBody MemberModel memberModel){
		memberModel=service.updateRecord(memberModel);
		return memberModel;
	}
	
	@RequestMapping(value=MemberURIConstants.UPDATE_MEMBERS,method=RequestMethod.POST)
	public void updateMembers(@RequestBody List<MemberModel> memberModels){
		service.saveRecords(memberModels);
	}
	
	@RequestMapping(value=MemberURIConstants.DELETE_MEMBER_BY_ID,method=RequestMethod.POST)
	public void deleteMember(@RequestBody MemberModel memberModel){
		service.deleteRecordById(memberModel.getId());
	}
	
	@RequestMapping(value=MemberURIConstants.DELETE_MEMBERS,method=RequestMethod.POST)
	public void deleteMembers(@RequestBody List<MemberModel> memberModels){
		service.deleteRecords(memberModels);
	}
	
	@RequestMapping(value=MemberURIConstants.FETCH_ROLES_BY_TENANTID,method=RequestMethod.GET)
	public List<RoleModel> fetchRolesByTenantId(@PathVariable("tenantId")Long tenantId){
		List<RoleModel> roleModels=service.findRolesByTenantId(tenantId);
		return roleModels;
	}
	
	@RequestMapping(value=MemberURIConstants.FETCH_ALL_TEAMLEADERS_BY_TENANTID,method=RequestMethod.GET)
	public List<MemberModel> fetchTeamLeadersByTenantId(@PathVariable("tenantId")Long tenantId){
		List<MemberModel> memberModels=service.findTeamLeadersByTenantId(tenantId);
		return memberModels;
	}
	
}
