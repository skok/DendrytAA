package com.dendrytdev.org.client.usersAddition;

import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmployeeServiceAsync {
	public void addPerson(Person p, AsyncCallback<Boolean> asyncCallback);
	
}
