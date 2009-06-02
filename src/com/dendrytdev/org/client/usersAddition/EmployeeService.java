package com.dendrytdev.org.client.usersAddition;

import java.util.List;

import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("EmployeeService")
public interface EmployeeService extends RemoteService {
	 public Boolean addPerson(Person p);
	 public List<Person> getEmployees();
	 public void deletePerson(Person p);
	 public void setChanges(Person p);
}
