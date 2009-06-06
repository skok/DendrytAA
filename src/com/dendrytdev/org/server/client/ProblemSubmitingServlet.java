package com.dendrytdev.org.server.client;

import javax.servlet.http.HttpSession;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.client.problemSubmiting.ProblemSubmitingService;
import com.dendrytdev.org.server.login.LoginTool;
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
		p.setClient(LoginTool.getLogin(getHttpSession()));
		return impl.submitProblem(p);
	}
	
	public HttpSession getHttpSession(){
		return getThreadLocalRequest().getSession();
	}

}
