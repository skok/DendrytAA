package com.dendrytdev.org.client.designer.myProblemOverview;

import com.dendrytdev.org.client.designer.problemOverview.ProblemOverview;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class MyProblemOverview extends ProblemOverview {

	
	@Override
	public void createController() {
		_controller = new MyProblemOverviewController(this);
	}
	
	
	
	protected void generateAssignmentButton(){
		_assignmentButton = new Button("Przydziel", new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				onAssignmentClick();	
			}
			
		});
		
	}
}
