package com.dendrytdev.org.client.designer.usersAddition;


import java.util.List;

import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmployeeServiceAsync {
	public void addPerson(Person p, AsyncCallback<Boolean> asyncCallback);
	public void getEmployees(AsyncCallback<List<Person>> asyncCallback);
	public void deletePerson(Person p,AsyncCallback<Object> asyncCallback);
	public void setChanges(Person p,AsyncCallback<Object> asyncCallback);
}
