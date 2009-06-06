package com.dendrytdev.org.client.designer.problemOverview;

import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.dto.AssignmentDTO;
import com.dendrytdev.org.client.bean.dto.RaportDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ProblemOverviewServlet")
public interface ProblemOverviewService extends RemoteService {
	public List<Problem> getProblemList(int hash);
	
	
	/**
	 * As an argument you give a list of problemID
	 * and the implementation returns for each problemID
	 * a list of comment
	 * 
	 * @param problemId - list of ProblemID
	 * @return map (ProblemID->ProblemCommentList)
	 */
	public Map<Long, List<Comment>> getMapOfCommentList(List<Long> problemId);
	
	
	
	public Person[] getAllPeople();
	public void setAssignment(AssignmentDTO a);
	public RaportDTO getRaport(Long problemID); 
}
