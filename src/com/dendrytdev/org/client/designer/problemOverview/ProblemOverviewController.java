package com.dendrytdev.org.client.designer.problemOverview;

import java.util.List;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.DialogBox;

public class ProblemOverviewController implements IProblemOverviewController {
	
	
	ProblemOverviewServiceAsync _service = GWT.create(ProblemOverviewService.class);
	IProblemOverview i;
	ProblemOverviewController(IProblemOverview ip) {
		i = ip; 
	}


	@Override
	public void updateProblemList() {
		_service.getProblemList(i.getProblemListHashCode(), new AsyncCallback<List<Problem>>(){

			@Override
			public void onFailure(Throwable caught) {
				DialogBox todoDialogBox1 = GuiFactory.getInstance().createSystemErrorBox("Problem:updateProblemList()" + caught.getMessage());
				todoDialogBox1.center();				
			}

			@Override
			public void onSuccess(List<Problem> result) {
				
				// TODO: cos tu nie dziala, za kazdym razem zwraca inny hashcode,
				// pomimo tego, ze leci ten sam obiekt z serwera KURWA!
				if(result == null){
					// TODO: refactor the shit!
//					GuiFactory.getInstance().createInfoDialogBox("", "nie ma nic nowego :)").center();
				}else{
					i.updateProblemList(result);	
//					GuiFactory.getInstance().createInfoDialogBox("", "odswiezono").center();					
				}
			}
		});
		
	}
	
	
}
