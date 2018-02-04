package com.jmk.bjjd.web.config.core;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(value=2)
public class SpringSecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer{

}
