package com.dendrytdev.org.client.problemSubmiting;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;


public interface ProblemSubmitingServiceAsync extends RemoteService {
	public void getAllProducts(AsyncCallback<Product[]> a);

	public void submitProblem(Problem p, AsyncCallback<Boolean> a);
}
