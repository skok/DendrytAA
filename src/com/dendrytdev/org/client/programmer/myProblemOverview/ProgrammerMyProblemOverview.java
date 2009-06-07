package com.dendrytdev.org.client.programmer.myProblemOverview;

import com.dendrytdev.org.client.designer.problemOverview.ProblemOverview;

public class ProgrammerMyProblemOverview extends ProblemOverview{

	
	@Override
	public void createController() {
		_controller = new ProgrammerMyProblemOverviewController(this);
	}
	
	
	
	protected void generateAssignmentButton(){
		_assignmentButton = null; // will not be added if is null		
	}
}
