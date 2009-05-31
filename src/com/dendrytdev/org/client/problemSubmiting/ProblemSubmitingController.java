package com.dendrytdev.org.client.problemSubmiting;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.problemOverview.IProblemOverview;
import com.dendrytdev.org.client.problemOverview.ProblemOverviewService;
import com.dendrytdev.org.client.problemOverview.ProblemOverviewServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class ProblemSubmitingController {
	
	
	ProblemSubmitingServiceAsync service;
	IProblemSubmiting i;



	ProblemSubmitingController(IProblemSubmiting ip) {
		i = ip;
		service = GWT.create(ProblemSubmitingService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) service;
		endpoint.setServiceEntryPoint(GWT.getModuleBaseURL() + "ProblemSubmitingServlet");

	}
	
	static int _i = 0;
	void updateProductList(){
		service.getAllProducts(new AsyncCallback<Product[]>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onSuccess(Product[] result) {
				i.updateProductList(result);
				
			}
			
		});
		
	}
	
	void submitProblem(Problem p){
		service.submitProblem(p, new AsyncCallback<Boolean>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}

}
