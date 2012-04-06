package org.cloudfoundry.samples;

import java.util.List;

import org.cloudfoundry.services.SpringDispenser;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CounterDAO {
	private CounterDAO() {
		
	}
	
	public static synchronized int incrementContactsCounterBy(int delta) {
		MongoTemplate mongoTemplate = (MongoTemplate) SpringDispenser.getBean("mongoTemplate");
		List<Counter> counters = mongoTemplate.findAll(Counter.class);
		Counter counter = (Counter) counters.get(0);
		counter.setContactsCounter(counter.getContactsCounter() + delta);
		mongoTemplate.save(counter);
		return counter.getContactsCounter();
	}
	
	
	public static synchronized int incrementSTPCounterBy(int delta) {
		MongoTemplate mongoTemplate = (MongoTemplate) SpringDispenser.getBean("mongoTemplate");
		List<Counter> counters = mongoTemplate.findAll(Counter.class);
		Counter counter = (Counter) counters.get(0);
		counter.setStpCounter(counter.getStpCounter() + delta);
		mongoTemplate.save(counter);
		return counter.getStpCounter();
	}
}
