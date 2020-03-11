package com.stadline.demo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.stadline.demo.entity.AuthParameter;

@Aspect
@Configuration
public class ApiAspect {
 
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private AuthParameter authParameter;
	
	public ApiAspect(AuthParameter authParameter) {
		this.authParameter = authParameter;
	}
	
	@Before("execution(* com.stadline.demo.services.*.*(..))")
	public void checkAuthentification() {
		
		if(authParameter.getToken() == null) {
			authParameter.getTokenFromApi();
		}
		
	}
	
	
		
	
}
