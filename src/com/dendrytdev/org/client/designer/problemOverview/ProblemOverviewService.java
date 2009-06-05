package com.dendrytdev.org.client.designer.problemOverview;

import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Problem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

//@RemoteServiceRelativePath("pos")
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
}
