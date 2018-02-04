package com.jmk.bjjd.service;

import java.util.List;

import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;

public interface MemberMgmtService extends BaseMgmtService<MemberModel> {
	List<RoleModel> findRolesByTenantId(Long tenantId);
	List<MemberModel> findTeamLeadersByTenantId(Long tenantId);
}
