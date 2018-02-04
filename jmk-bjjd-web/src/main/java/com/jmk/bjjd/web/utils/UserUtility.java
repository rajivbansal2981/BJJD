package com.jmk.bjjd.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.jmk.bjjd.dto.LoggedInUser;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.util.testdata.SQLTestDataUtil;

public final class UserUtility {

	private UserUtility() {

	}

	/**
	 * 
	 */
	public static LoggedInUser getLoggedInUser() {
		LoggedInUser loggedInUser = null;
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			loggedInUser = (LoggedInUser) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} else {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));
			UserModel userModel = SQLTestDataUtil.createUser("-999999");
			loggedInUser = new LoggedInUser(userModel, "rajivbansal2981",
					"rajiv379", grantedAuthorities);
			loggedInUser.setUserModel(userModel);
		}

		return loggedInUser;
	}

}
