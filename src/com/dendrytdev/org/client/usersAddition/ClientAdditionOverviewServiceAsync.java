package com.dendrytdev.org.client.usersAddition;

import java.util.List;

import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ClientAdditionOverviewServiceAsync {
	public void addClient(Person p, AsyncCallback<Boolean> asyncCallback);
	public void getClients(AsyncCallback<List<Person>> asyncCallback);
	public void deletePerson(Person p,AsyncCallback<Object> asyncCallback);
	public void setChanges(Person p,AsyncCallback<Object> asyncCallback);
}
