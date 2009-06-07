package com.dendrytdev.org.client.tester.myProblemOverview;

import com.dendrytdev.org.client.designer.problemOverview.ProblemOverview;

public class TesterMyProblemOverview extends ProblemOverview{
	@Override
	public void createController() {
		_controller = new TesterMyProblemOverviewController(this);
	}
	
	protected void generateAssignmentButton(){
		_assignmentButton = null; // will not be added if is null		
	}
}
