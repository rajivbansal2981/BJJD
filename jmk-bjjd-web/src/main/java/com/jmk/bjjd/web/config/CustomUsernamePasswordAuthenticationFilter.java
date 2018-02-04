package com.jmk.bjjd.web.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	 @Override
	    protected String obtainUsername(HttpServletRequest request)
	    {
	        String username = request.getParameter(getUsernameParameter());
	        String extraInput = request.getParameter("userType");
	        String combinedUsername = username + ":" + extraInput;
	        return combinedUsername;
	    }
}
