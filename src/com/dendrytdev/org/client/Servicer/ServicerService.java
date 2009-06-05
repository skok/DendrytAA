package com.dendrytdev.org.client.servicer;

import java.util.List;

import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ServicerService")
public interface ServicerService extends RemoteService{
	public List<Product> getAllProducts();
	public List<Person> getAllClients();
	public void addProblem(Problem problem);
}
