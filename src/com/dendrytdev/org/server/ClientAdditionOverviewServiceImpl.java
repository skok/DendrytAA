package com.dendrytdev.org.server;

import java.util.List;

import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.usersAddition.ClientAdditionOverviewService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ClientAdditionOverviewServiceImpl extends RemoteServiceServlet implements ClientAdditionOverviewService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ClientAdditionOverviewServiceImpl(){
		super();
	}
	@Override
	public Boolean addClient(Person p) {
		
		return DatabaseConnector.addPerson(p);
		//return false;
	}
	@Override
	public void deletePerson(Person p) {
		DatabaseConnector.remove(p);
		
	}
	@Override
	public List<Person> getClients() {
		List<Person> result=DatabaseConnector.getAllClients();
		return result;
		
	}
	@Override
	public void setChanges(Person p) {
		DatabaseConnector.setChanges(p);
		
	}

}
