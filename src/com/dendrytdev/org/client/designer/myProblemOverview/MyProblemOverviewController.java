package com.dendrytdev.org.client.designer.myProblemOverview;

import java.util.List;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.designer.problemOverview.IProblemOverview;
import com.dendrytdev.org.client.designer.problemOverview.ProblemOverviewController;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;

public class MyProblemOverviewController extends ProblemOverviewController{

	protected String ERROR_TEXT = "MyProblemOverviewController:updateProblemList()";
	protected MyProblemOverviewController(IProblemOverview ip) {
		super(ip);
	}
	
	
	@Override
	public void updateProblemList() {
		_service.getMyProblemList(new AsyncCallback<List<Problem>>(){

			@Override
			public void onFailure(Throwable caught) {
				DialogBox todoDialogBox1 = GuiFactory.getInstance().createSystemErrorBox(ERROR_TEXT + caught.getMessage());
				todoDialogBox1.center();				
			}

			@Override
			public void onSuccess(List<Problem> result) {
				if(result == null){
				}else{
					i.updateProblemList(result);		
					_timer.schedule(2500);
				}
			}
		});
	}

}
