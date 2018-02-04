package com.jmk.bjjd.web.facade.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.jmk.bjjd.dto.LoggedInUser;
import com.jmk.bjjd.models.MemberModel;
import com.jmk.bjjd.models.RoleModel;
import com.jmk.bjjd.models.UserModel;
import com.jmk.bjjd.util.constants.UserURIConstants;
import com.jmk.bjjd.web.facade.UserMgmtServiceFacade;

@Component("userMgmtServiceFacade")
public class DefaultUserMgmtServiceFacade implements UserMgmtServiceFacade {

	@Value("${webservice.url}")
	private String webServiceURL;
	
	private Logger logger=LoggerFactory.getLogger(DefaultUserMgmtServiceFacade.class);
	
	private static Map<String,String> roleMappings;
	
	{
		roleMappings=new HashMap<String,String>();
		roleMappings.put("ADMIN","ROLE_ADMIN");
		roleMappings.put("USER","ROLE_USER");
		roleMappings.put("MEMBER","ROLE_MEMBER");
		roleMappings.put("TL","ROLE_TL");
		roleMappings.put("GUEST","ROLE_GUEST");
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		String[] userAttributes=userName.split(":");
		userName=userAttributes[0];
		String userType="MEMBER";//userAttributes[1];
		UserModel userModel=findUserDetailsByUserName(userName,userType);
		logger.info("UserName: "+userModel.getUserName());
		return new LoggedInUser(userModel, userModel.getUserName(), userModel.getPassword(), getAuthorities(userModel.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(List<RoleModel> roles) {
		Assert.notNull(roles);
		List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
		for(RoleModel role:roles){
			grantedAuthorities.add(new SimpleGrantedAuthority(roleMappings.get(role.getName())));
		}
		return grantedAuthorities;
	}

	
	@Override
	public UserModel findUserDetailsByUserName(String userName,String userType) {
		RestTemplate restTemplate=new RestTemplate();
		List<HttpMessageConverter<?>> msgConverters = restTemplate.getMessageConverters();
		msgConverters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);
        Map<String, String> map = new HashMap<String, String>();
		map.put("userName",userName);
		map.put("userType", userType);
		UserModel userModel=restTemplate.getForObject(webServiceURL+UserURIConstants.GET_USERDETAILS_BY_USERNAME_AND_TYPE, getReferencedClass(userType),map);
		return userModel;
	}

	@Override
	public void changePassword(String userId, String password) {
		
	}
	
	/**
	 * Get the referenced class by userType
	 * @param userType
	 * @return
	 */
	protected Class<? extends UserModel> getReferencedClass(String userType){
		if("MEMBER".equals(userType)){
			return MemberModel.class;
		}else if("GUEST".equals(userType)){
			return MemberModel.class;
		}
		return null;
	}

}
