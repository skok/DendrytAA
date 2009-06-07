package com.dendrytdev.org.client.designer.raportOverview;

import java.util.HashMap;
import java.util.Map;


import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.dto.RaportDTO;
import com.dendrytdev.org.client.designer.problemOverview.*;
import com.dendrytdev.org.client.designer.problemOverview.ProblemOverview.StaticHelperClass;
import com.dendrytdev.org.client.employee.CommentComposite;
import com.dendrytdev.org.client.tools.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;


public class RaportOverview extends Composite {
	
	ClickHandler _ch = new ClickHandler(){

		@Override
		public void onClick(ClickEvent event) {
			_parent.hideRaportsDialogBox();
			
			Function fun = _parent.getCurrentFunction();
			Long pId = _parent.getCurrentProblemId();
			CommentComposite com = new CommentComposite(fun, pId);
			DialogBox d = GuiFactory.getInstance().createInfoDialogBox("Dodaj Komentarz", null, com);
			d.show();
			d.center();
		}
		
	};
	
	
		
		void blankAllFields(){			
			// initialize textboxes
			_userNameAndSurname.setText(IType.EMPTY_STRING);
			_actualAssignmentTextBox.setText(IType.EMPTY_STRING);
			_userEmail.setText(IType.EMPTY_STRING);
			_timeOfAddingComment.setText(IType.EMPTY_STRING);
			_dataOfAddingComment.setText(IType.EMPTY_STRING);
			_textArea.setText(IType.EMPTY_STRING);
			
		}


		TextArea _textArea = new TextArea();
		
		
		// fields connected with PRODUCT
		TextBox _actualAssignmentTextBox = new TextBox();
		
		// fields connected with ASSIGNMENT (RightUpperPanel)
		TextBox _userNameAndSurname = new TextBox();
		TextBox _userEmail = new TextBox();
		TextBox _dataOfAddingComment = new TextBox();
		TextBox _timeOfAddingComment = new TextBox();
		
		ListBox _userListTextBox = new ListBox();
		
		ProblemSuggestOracle _oracle = new ProblemSuggestOracle(); 
		SuggestBox _suggestBox = new SuggestBox(_oracle);
	
		//register controler - refactor later ...
//		ProblemSubmitingController controller = new ProblemSubmitingController(this);
		
		
		Map<Integer, Problem> _problemMap = new HashMap<Integer, Problem>();
		int _problemListHashCode;
		
		
		
		ProblemOverviewServiceAsync _service = GWT.create(ProblemOverviewService.class);
		RaportOverviewServiceAsync service = GWT.create(RaportOverviewService.class);
		
		public RaportOverview() {
		_actualAssignmentTextBox.setEnabled(false);
		_textArea.setCharacterWidth(40);
		_textArea.setVisibleLines(20);
		_userListTextBox.setVisibleItemCount(5);
		_problemListHashCode = IProblemOverview.PROBLEM_LIST_NOT_DOWNLOADED_YET;

		_userListTextBox.addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				onUserListTextBoxClick();
			}
		});
		
		HorizontalPanel mainPanel = new HorizontalPanel();
		initWidget(mainPanel);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainPanel.add(generateLeftPanel());
		mainPanel.add(generateRightPanel());
	}
		
		Widget generateRightPanel(){
			VerticalPanel rightPanel = new VerticalPanel();	
			rightPanel.add(generateRightUpperPanel());
			rightPanel.add(generateRightLowerPanel());
			return rightPanel;
		}
		
		VerticalPanel generateLeftPanel(){
			VerticalPanel panel = new VerticalPanel();
			panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			panel.add(generatePeopleList());
			panel.setHeight("400");
			return panel;
		}
		
//		VerticalPanel generateRightPanel(){
//			VerticalPanel panel = new VerticalPanel();
//			panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//			panel.add(generatePeopleList());
//			panel.setHeight("400");
//			return panel;
//		}
		
		/**
		 * Generates a set of horizontal panels with labels and textboxes.
		 * All it is connected with content of Person-bean	 * 
		 * @param panel - panel to which it adds this hPanels
		 */
		Composite generateRightUpperPanel() {	
			VerticalPanel panel = new VerticalPanel();
			StaticHelperClass.setWidth("200");
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Imie i nazwisko uczestnika:", _userNameAndSurname));
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("E-mail uczestnika:", _userEmail));
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Data dodania komentarza:", _dataOfAddingComment));
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Czas dodania komentarza:", _timeOfAddingComment));
	
			CaptionPanel cp = new CaptionPanel("Informacje o uczestniku");
			cp.add(panel);
			return cp;
		}
			
		Composite generateRightLowerPanel() {
			CaptionPanel cp = new CaptionPanel("Komentarz");
			VerticalPanel v = new VerticalPanel();
			Button b = new Button("Nowy komentarz", _ch);
			v.add(_textArea);
			v.add(b);
			_textArea.setHeight("265");
			cp.add(v);
			return cp;			
		}	
				
		
		Widget generatePeopleList() {
			StaticHelperClass.setWidth("180");
			VerticalPanel vp = new VerticalPanel();
			vp.setHeight("400");
			vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
			
			VerticalPanel descriptionPanel = new VerticalPanel();
			descriptionPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			_userListTextBox.setSize("240", "360");
		    descriptionPanel.add(_userListTextBox);
		    descriptionPanel.add(StaticHelperClass.generateLabeledTextBoxPanel("Aktualny przydzial:", _actualAssignmentTextBox));
		    
			CaptionPanel cpRight = new CaptionPanel("Lista uczestnikow");
			cpRight.setHeight("440");
			cpRight.add(descriptionPanel);		
			vp.add(cpRight);
		
			return vp; // sorry ... refactor this shit later !!! TODO!
		}
		
		IProblemOverview _parent;
		public void setParent(IProblemOverview i){
			_parent = i;
		}
			
		long _problemID;	
		/**
		 * all the logic here
		 * ...
		 * i know that smells bad.. ... TODO:refactor
		 */
		public void setProblemId(long id){
			_problemID = id;
			
			// TODO: refactor the shit (into controler)
			service.getCommentsWithPeople(_problemID,
					new AsyncCallback<RaportDTO>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onSuccess(RaportDTO result) {
							if (result != null) {
							
//								System.out.println("comment.length="+ result.getCommentArray().length);
//								for (Person p : result.getPersonList()) {
//									System.out.println(p.getLogin());
//								}
//
//								for (Comment c : result.getCommentArray()) {
//									System.out.println(c.getUser() + " " + c.getContent());
//								}
								String worker = result.getCurrentWorker();
								if(worker != null){
									_actualAssignmentTextBox.setText(worker);
								}else{
									System.out.println("!!");
								}
								
								fillUserListBox(result.getCommentArray(), result.getPersonList());
							}
						}

					});
		}
		
		Map<String, Comment> _textboxidInComment = new HashMap<String, Comment>();
		Map<String, Person> _loginInPersonMap = new HashMap<String, Person>();
		void fillUserListBox(Comment[] carr, Person[] parr){
			_textboxidInComment = new HashMap<String, Comment>();
			_loginInPersonMap = new HashMap<String, Person>();
			if(parr != null){
				for(Person p : parr){
					_loginInPersonMap.put(p.getLogin(), p);
				}
			}
//			_commentArray = carr;
			
			_userListTextBox.clear();
			int i = 0;
			for(Comment c : carr){
				String inx = String.valueOf(i++);
				_userListTextBox.addItem(_loginInPersonMap.get(c.getUser()).toString(), inx);
				_textboxidInComment.put(inx, c);
			}
			
		}
		
		
		
		@SuppressWarnings("deprecation")
		void onUserListTextBoxClick(){
			int inx = Integer.valueOf(_userListTextBox.getValue(_userListTextBox.getSelectedIndex()));
			Comment c = _textboxidInComment.get(String.valueOf(inx));
			System.out.println(c + " " + inx);
			
			Person p = _loginInPersonMap.get(c.getUser());
			_userNameAndSurname.setText(p.toString());
			_timeOfAddingComment.setText(c.getDate().toLocaleString());
			_textArea.setText(c.getContent());
			
			
		}
		
	}
