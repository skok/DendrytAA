package com.dendrytdev.org.client.problemOverview;

import java.util.List;

import com.dendrytdev.org.client.bean.Problem;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProblemOverviewServiceAsync {
	public void getProblemList(int hash, AsyncCallback<List<Problem>> ac);
}
