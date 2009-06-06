package com.dendrytdev.org.server.designer;


import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.dto.AssignmentDTO;
import com.dendrytdev.org.client.bean.dto.RaportDTO;
import com.dendrytdev.org.client.designer.problemOverview.ProblemOverviewService;
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

	@Override
	public Map<Long, List<Comment>> getMapOfCommentList(List<Long> problemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person[] getAllPeople() {
		return impl.getAllPeople();
	}

	@Override
	public void setAssignment(AssignmentDTO a) {
		impl.setAssignment(a);
	}

	@Override
	public RaportDTO getRaport(Long problemID) {
		return impl.getRaport(problemID);
	}
	
	
}
