package com.dendrytdev.org.client.designer.problemOverview;

import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Problem;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProblemOverviewServiceAsync {
	public void getProblemList(int hash, AsyncCallback<List<Problem>> ac);
	public void getMapOfCommentList(List<Long> problemId, AsyncCallback<Map<Long, List<Comment>>> ac);
}
