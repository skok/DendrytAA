package com.dendrytdev.org.client.designer.problemAssignment;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.dto.AssignmentDTO;
import com.dendrytdev.org.client.designer.problemOverview.IProblemOverview;
import com.dendrytdev.org.client.designer.problemOverview.ProblemOverviewService;
import com.dendrytdev.org.client.designer.problemOverview.ProblemOverviewServiceAsync;
import com.dendrytdev.org.client.designer.problemOverview.ProblemOverview.StaticHelperClass;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProblemAssignmentComposite extends Composite{
	
	ListBox _serviceman = new ListBox();
	ListBox _designer = new ListBox();
	ListBox _programmer = new ListBox();
	ListBox _tester = new ListBox();
	
	long _problemID = -1; 
	
	/**
	 * refactor into separeted controller
	 */
	ProblemOverviewServiceAsync _service = GWT.create(ProblemOverviewService.class);
	
	public ProblemAssignmentComposite(){
		_serviceman.setWidth("350");
		_designer.setWidth("350");
		_programmer.setWidth("350");
		_tester.setWidth("350");
		
		Button acceptButton = new Button("Zatwierdz", new ClickHandler(){

			String getLogin(ListBox l){
				int inx = l.getSelectedIndex();
				String s = l.getItemText(inx);
				if(s.length() < 3){ // minimal lenght   - >  [X]
					Window.alert("ProblemAssignmentComposite!!");
					// refactor TODO
				}
				int start = s.indexOf("[") + 1;
				int stop = s.length() - 1;
				return s.substring(start, stop);
			}
			@Override
			public void onClick(ClickEvent event) {

				AssignmentDTO dto = new AssignmentDTO();
				dto.setServicerLogin(getLogin(_serviceman));
				dto.setDesignerLogin(getLogin(_designer));
				dto.setProgrammerLogin(getLogin(_programmer));
				dto.setTesterLogin(getLogin(_tester));
				dto.setProblemId(_problemID);
				_service.setAssignment(dto, new AsyncCallback<Object>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override public void onSuccess(Object result){
						_parent.updateProblemList();
						_parent.hideAssignmentDialogBox();
					}
					
				});
//				System.out.println(serviceman + "/" + designer + "/" + programmer + "/" + tester);
			}
			
		});
		
		
		VerticalPanel panel = new VerticalPanel();
		StaticHelperClass.setWidth("150");
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Serwisant:", _serviceman));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Projektant:", _designer));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Programista:", _programmer));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Tester:", _tester));
		panel.add(acceptButton);
		initWidget(panel);
		
		
		
		// do not do it at HOME!!! (refactor TODO)
		_service.getAllPeople(new AsyncCallback<Person[]>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Person[] result) {
				for(Person p : result){
					Function f = p.getFunction();
					switch(f){
					case SERVICE:
						_serviceman.addItem(p.toString());
						break;
					case DESIGNER:
						_designer.addItem(p.toString());
						break;
					case PROGRAMMER:
						_programmer.addItem(p.toString());
						break;
					case TESTER:
						_tester.addItem(p.toString());
						break;
					default:
					}
				}
			}
			
		});
	
	}
	
	IProblemOverview _parent;
	public void setProblemId(long id){
		_problemID = id;
	}
	
	public void setParent(IProblemOverview i){
		_parent = i;
	}

}
