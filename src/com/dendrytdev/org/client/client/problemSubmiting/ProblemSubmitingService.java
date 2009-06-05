package com.dendrytdev.org.client.client.problemSubmiting;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.google.gwt.user.client.rpc.RemoteService;

public interface ProblemSubmitingService extends RemoteService {
	public Product[] getAllProducts();
	public boolean submitProblem(Problem p);
}
