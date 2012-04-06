package org.cloudfoundry.services;

import org.springframework.context.ApplicationContext;

public class SpringDispenser {
	private SpringDispenser() {}
	private static ApplicationContext appContext;
	
	public static void initialize(ApplicationContext context) {
		appContext = context;
	}
	
	public static Object getBean(String name) {
		return appContext.getBean(name);
	}
	
}
