package com.dendrytdev.org.server.servicer;

import java.util.List;

import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.servicer.ServicerService;
import com.dendrytdev.org.server.dao.DatabaseConnector;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class  ServicerServiceImpl extends RemoteServiceServlet implements ServicerService {
	private static final long serialVersionUID = 1L;
	@Override
	public void addProblem(Problem problem) {
		DatabaseConnector.addProblem(problem);
		
	}

	@Override
	public List<Person> getAllClients() {
		return DatabaseConnector.getAllClients();
	}

	@Override
	public List<Product> getAllProducts() {
		return DatabaseConnector.getAllProducts();
	}

}
