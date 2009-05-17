package com.dendrytdev.org.client.problemOverview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dendrytdev.org.client.bean.Problem;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class ProblemOverviewController implements IProblemOverviewController {
	
	
	ProblemOverviewServiceAsync service;
	IProblemOverview i;
	ProblemOverviewController(IProblemOverview ip) {
		i = ip;
		service = GWT.create(ProblemOverviewService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) service;
		endpoint.setServiceEntryPoint(GWT.getModuleBaseURL() + "ProblemOverviewServlet");
	}


	@Override
	public void updateProblemList() {
		service.getProblemList(i.getProblemListHashCode(), new AsyncCallback<List<Problem>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub				
			}

			@Override
			public void onSuccess(List<Problem> result) {
				i.updateProblemList(result);				
			}
		});
		
	}
	
	
}
