package com.dendrytdev.org.client.designer.problemOverview;

import java.util.List;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;

public class ProblemOverviewController implements IProblemOverviewController {
	
	
	protected ProblemOverviewServiceAsync _service = GWT.create(ProblemOverviewService.class);
	protected IProblemOverview i;
	protected ProblemOverviewController(IProblemOverview ip) {
		i = ip; 
	}

	
	protected AsyncCallback<List<Problem>> _callback = new AsyncCallback<List<Problem>>(){

		@Override
		public void onFailure(Throwable caught) {
			DialogBox todoDialogBox1 = GuiFactory.getInstance().createSystemErrorBox("Problem:updateProblemList()" + caught.getMessage());
			todoDialogBox1.center();				
		}

		@Override
		public void onSuccess(List<Problem> result) {
			// TODO: cos tu nie dziala, za kazdym razem zwraca inny hashcode,
			// pomimo tego, ze leci ten sam obiekt z serwera !!!!!!
			if(result == null){
			}else{
				i.updateProblemList(result);					
			}
			_timer.schedule(2500);
		}
	};
	
	protected Timer _timer = new Timer(){

		@Override
		public void run() {
			updateProblemList();
		}
		
	};

	@Override
	public void updateProblemList() {
		_service.getProblemList(i.getProblemListHashCode(), _callback);
		
	}

	@Override
	public void takeOverTheTask(Long taskID) {
		_service.assignMeAsDesigner(taskID, new AsyncCallback<Object>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Object result) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	
}
