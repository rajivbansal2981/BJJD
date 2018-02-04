package com.jmk.bjjd.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.models.SevaModel;
import com.jmk.bjjd.persistence.service.MemberPersistenceService;
import com.jmk.bjjd.service.MemberMgmtService;

@Service("memberMgmtService")
public class DefaultMemberMgmtService implements MemberMgmtService{
	
	@Resource(name="${persistenceservicetype}MemberPersistenceService")
	private MemberPersistenceService service;

	@Override
	public MemberModel saveRecord(MemberModel model) {
	//	updateSevaDetails(model.getSevas());
		return service.saveRecord(model);
	}

	@Override
	public MemberModel updateRecord(MemberModel model) {
		updateSevaDetails(model.getSevas());
		return service.updateRecord(model);
	}

	@Override
	public List<MemberModel> fetchAllRecordsByTenantId(Long tenantId) {
		return service.fetchAllRecordsByTenantId(tenantId);
	}

	@Override
	public void deleteRecordById(String id) {
		service.deleteRecordById(id);
	}

	@Override
	public MemberModel findRecordByKey(String id) {
		return service.findRecordByKey(id);
	}

	@Override
	public List<MemberModel> saveRecords(List<MemberModel> memberModels) {
		for(MemberModel memberModel:memberModels){
			updateSevaDetails(memberModel.getSevas());
		}
		return service.saveRecords(memberModels);
	}

	@Override
	public void deleteRecords(List<MemberModel> records) {
		service.deleteRecords(records);
	}
	
	protected void updateSevaDetails(List<SevaModel> sevas){
		Iterator<SevaModel> sevaIterator=sevas.iterator();
		while(sevaIterator.hasNext()){
			SevaModel sevaModel=sevaIterator.next();
			if(sevaModel.isApplicable()){
				sevaIterator.remove();
			}
		}
	}

	@Override
	public List<RoleModel> findRolesByTenantId(Long tenantId) {
		return service.findRolesByTenantId(tenantId);
	}

	@Override
	public List<MemberModel> findTeamLeadersByTenantId(Long tenantId) {
		return service.findTeamLeadersByTenantId(tenantId);
	}


}
