package com.dendrytdev.org.server.designer;


import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.dto.AssignmentDTO;
import com.dendrytdev.org.client.bean.dto.RaportDTO;
import com.dendrytdev.org.client.designer.problemOverview.ProblemOverviewService;
import com.dendrytdev.org.server.login.LoginTool;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


public class ProblemOverviewServlet extends RemoteServiceServlet implements ProblemOverviewService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	ProblemOverviewService impl = new ProblemOverviewServiceImpl();
	Logger _tracer = Logger.getLogger(this.getClass().getName());
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

	@Override
	public List<Problem> getMyProblemList() {
		String login = LoginTool.getLogin(getHttpSession());
		_tracer.info("login=" + login);
		((ProblemOverviewServiceImpl)impl).set_currentLogin(login);
		List<Problem> out = impl.getMyProblemList();		
		return out;
//		return null; //kurwo dziwko pizdo szmato
	}
	public HttpSession getHttpSession(){
		return getThreadLocalRequest().getSession();
	}

	@Override
	public void assignMeAsDesigner(Long problemID) {
		String login = LoginTool.getLogin(getHttpSession());
		((ProblemOverviewServiceImpl)impl).set_currentLogin(login);
		impl.assignMeAsDesigner(problemID);		
	}
	
}
