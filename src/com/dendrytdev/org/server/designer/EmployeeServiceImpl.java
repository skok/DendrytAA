package com.dendrytdev.org.server.designer;


import java.util.List;


import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.designer.usersAddition.EmployeeService;
import com.dendrytdev.org.server.DatabaseConnector;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;



public class EmployeeServiceImpl extends RemoteServiceServlet implements
		EmployeeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeServiceImpl() {
		super();
	}

	@Override
	public Boolean addPerson(Person p) {
		return DatabaseConnector.addPerson(p);	
	}

	@Override
	public List<Person> getEmployees() {
		List<Person> result=DatabaseConnector.getAllEmployees();
		return result;
	}

	@Override
	public void deletePerson(Person p) {
		DatabaseConnector.remove(p);
		
	}

	@Override
	public void setChanges(Person p) {
		DatabaseConnector.setChanges(p);
		
	}

	


	

}
