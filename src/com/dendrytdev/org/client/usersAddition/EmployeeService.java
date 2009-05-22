package com.dendrytdev.org.client.usersAddition;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("EmployeeService")
public interface EmployeeService extends RemoteService {
	 public String myMethod(String s);
}
