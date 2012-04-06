package org.cloudfoundry.services;


import java.util.List;

import org.cloudfoundry.samples.Counter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CloudApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("Setting active profile to cloud");
		System.out.println("Initializing Spring Dispenser with Application Context");
		applicationContext.getEnvironment().setActiveProfiles("cloud");
		applicationContext.refresh();
		SpringDispenser.initialize(applicationContext);
		MongoTemplate mongoTemplate = (MongoTemplate) SpringDispenser.getBean("mongoTemplate");
		List<Counter> counters = mongoTemplate.findAll(Counter.class);
		if(counters ==null || counters.size() == 0) {
			Counter counter = new Counter(0,0);
			mongoTemplate.save(counter);
		} else {
			System.out.println("Application Initialized. Current totals retrieved");
			System.out.println("total plans = " + ((Counter)counters.get(0)).getStpCounter());
			System.out.println("total contacts = " + ((Counter)counters.get(0)).getContactsCounter());
		}
	}

}
