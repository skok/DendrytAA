package com.dendrytdev.org.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.problemOverview.ProblemOverviewService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ProblemOverviewServlet extends RemoteServiceServlet implements ProblemOverviewService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	ProblemOverviewService impl = new ProblemOverviewServiceImpl();

	public List<Problem> getProblemList(int hash) {
		return impl.getProblemList(hash);
	}
	
}
