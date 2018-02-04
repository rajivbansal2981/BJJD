package com.jmk.bjjd.persistence.service;

import java.util.List;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;

public interface MemberPersistenceService extends BasePersistenceService<MemberModel>,UserPersistenceService {
	List<RoleModel> findRolesByTenantId(Long tenantId);
	List<MemberModel> findTeamLeadersByTenantId(Long tenantId);
	
}
