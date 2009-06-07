package com.dendrytdev.org.client.servicer.myProblemOverview;

import com.dendrytdev.org.client.designer.problemOverview.ProblemOverview;

public class ServicerMyProblemOvervie extends ProblemOverview{
	@Override
	public void createController() {
		_controller = new ServicerMyProblemOverviewController(this);
	}
	
	
	
	protected void generateAssignmentButton(){
		_assignmentButton = null; // will not be added if is null		
	}
}
