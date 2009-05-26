package com.dendrytdev.org.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.usersAddition.EmployeeService; //import com.google.gwt.dev.js.rhino.ObjToIntMap.Iterator;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.Query;

public class EmployeeServiceImpl extends RemoteServiceServlet implements
		EmployeeService {

	public EmployeeServiceImpl() {
		super();
	}

	@Override
	public Boolean addPerson(Person p) {
		return DatabaseConnector.addPerson(p);	
	}



	

}
