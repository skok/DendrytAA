package com.dendrytdev.org.client.servicer;

import java.util.List;

import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServicerServiceAsync {
	public void getAllProducts(AsyncCallback<List<Product>> asyncCallback);
	public void getAllClients(AsyncCallback<List<Person>> asyncCallback);
	public void addProblem(Problem problem,AsyncCallback<Object> asyncCallback);
}
