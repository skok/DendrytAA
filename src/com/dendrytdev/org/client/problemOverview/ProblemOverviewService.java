package com.dendrytdev.org.client.problemOverview;

import java.util.List;

import com.dendrytdev.org.client.bean.Problem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

//@RemoteServiceRelativePath("pos")
public interface ProblemOverviewService extends RemoteService {
	public List<Problem> getProblemList(int hash);
}
