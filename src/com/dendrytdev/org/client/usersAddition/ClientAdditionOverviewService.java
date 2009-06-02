package com.dendrytdev.org.client.usersAddition;

import java.util.List;

import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ClientAdditionOverviewService")
public interface ClientAdditionOverviewService extends RemoteService {
	Boolean addClient(Person p);

	void deletePerson(Person p);

	void setChanges(Person p);

	List<Person> getClients();
}
