package org.cloudfoundry.samples;

public class Counter {
	private int contactsCounter;
	private int stpCounter;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Counter() {
		contactsCounter = 0;
		stpCounter = 0;
	}
	public Counter(int contacts, int plans) {
		this.contactsCounter = contacts;
		this.stpCounter = plans;
	}

	public int getContactsCounter() {
		return contactsCounter;
	}

	public void setContactsCounter(int contactsCounter) {
		this.contactsCounter = contactsCounter;
	}

	public int getStpCounter() {
		return stpCounter;
	}

	public void setStpCounter(int stpCounter) {
		this.stpCounter = stpCounter;
	}
	
	@Override
	public String toString() {
		return "Counter [id=" + id + ", contactsCounter=" + contactsCounter + ", stpCounter=" + stpCounter + "]";
	}
	
}
