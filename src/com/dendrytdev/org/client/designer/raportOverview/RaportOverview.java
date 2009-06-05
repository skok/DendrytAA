package com.dendrytdev.org.client.designer.raportOverview;

import java.util.HashMap;
import java.util.Map;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.designer.problemOverview.*;
import com.dendrytdev.org.client.designer.problemOverview.ProblemOverview.StaticHelperClass;
import com.dendrytdev.org.client.tools.*;
import com.google.gwt.user.client.ui.*;


public class RaportOverview extends Composite {
		
		
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
		
		public RaportOverview() {
			_actualAssignmentTextBox.setEnabled(false);		
			_textArea.setCharacterWidth(40);
		    _textArea.setVisibleLines(20);
			_userListTextBox.setVisibleItemCount(5);
			_problemListHashCode = IProblemOverview.PROBLEM_LIST_NOT_DOWNLOADED_YET;
			
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
			Button b = new Button("Nowy komentarz");
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
			
			
	}
