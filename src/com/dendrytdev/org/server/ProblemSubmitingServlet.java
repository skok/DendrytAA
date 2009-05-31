package com.dendrytdev.org.server;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.problemSubmiting.ProblemSubmitingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ProblemSubmitingServlet extends RemoteServiceServlet implements ProblemSubmitingService{


	private static final long serialVersionUID = 1L;
	ProblemSubmitingService impl = new ProblemSubmitingServiceImpl();
	
	
	@Override
	public Product[] getAllProducts() {
		return impl.getAllProducts();
	}

	@Override
	public boolean submitProblem(Problem p) {
		return impl.submitProblem(p);
	}

}
