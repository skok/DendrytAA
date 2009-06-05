package com.dendrytdev.org.client.designer.problemOverview;

import java.util.List;

import com.dendrytdev.org.client.bean.Problem;

public interface IProblemOverview {

	public abstract void updateProblemList(List<Problem> problemList);
	public int getProblemListHashCode();
	
	public static final int PROBLEM_LIST_NOT_DOWNLOADED_YET = 0;

}