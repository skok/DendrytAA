package com.dendrytdev.org.client.problemOverview.raportOverview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.problemOverview.IProblemOverview;
import com.dendrytdev.org.client.problemOverview.ProblemMultiWordSuggestion;
import com.dendrytdev.org.client.problemOverview.ProblemSuggestOracle;
import com.dendrytdev.org.client.problemSubmiting.ProblemSubmitingController;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.dendrytdev.org.client.tools.IDialogBoxFactory;
import com.google.gwt.user.client.ui.*;


public class RaportOverview extends Composite {
		
		
		void blankAllFields(){
			final String EMPTY = "";
			
			// initialize textboxes
			_userNameAndSurname.setText(EMPTY);
			_actualAssignmentTextBox.setText(EMPTY);
			_userEmail.setText(EMPTY);
			_timeOfAddingComment.setText(EMPTY);
			_dataOfAddingComment.setText(EMPTY);
			
			_textArea.setText(EMPTY);
			
		}


		TextArea _textArea;
		
		
		// fields connected with PRODUCT
		TextBox _actualAssignmentTextBox;
		
		// fields connected with ASSIGNMENT (RightUpperPanel)
		TextBox _userNameAndSurname;
		TextBox _userEmail;
		TextBox _dataOfAddingComment;
		TextBox _timeOfAddingComment;
		
		ListBox _userListTextBox;
		
		SuggestBox _suggestBox;
		ProblemSuggestOracle _oracle;
		


//		IDialogBoxFactory _factory = GuiFactory.getInstance();
		
		//register controler - refactor later ...
//		ProblemSubmitingController controller = new ProblemSubmitingController(this);
		
		
		Map<Integer, Problem> _problemMap;
		int _problemListHashCode;
		
		public RaportOverview() {
			
			// initialize textboxes
			_userNameAndSurname = new TextBox();
			_userEmail = new TextBox();
			_dataOfAddingComment = new TextBox();
			_timeOfAddingComment = new TextBox();

			
			_actualAssignmentTextBox = new TextBox();
			_actualAssignmentTextBox.setEnabled(false);		
			
			_textArea = new TextArea();
			_textArea.setCharacterWidth(40);
		    _textArea.setVisibleLines(20);

			
			_userListTextBox = new ListBox();
			_userListTextBox.setVisibleItemCount(5);
		
			_oracle = new ProblemSuggestOracle(); 
			_suggestBox = new SuggestBox(_oracle);

			
			
			_problemMap = new HashMap<Integer, Problem>();
			_problemListHashCode = IProblemOverview.PROBLEM_LIST_NOT_DOWNLOADED_YET;
			
			
	
			
			HorizontalPanel mainPanel = new HorizontalPanel();
			initWidget(mainPanel);
			mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
			mainPanel.add(generateLeftPanel());
			
			VerticalPanel rightPanel = new VerticalPanel();	
			rightPanel.add(generateRightUpperPanel());
			rightPanel.add(generateRightLowerPanel());
			mainPanel.add(rightPanel);
			
			
			
			
			

			
			
			
			


			

			
		}


		/**
		 * 
		 * DAMN DAMN DAMN!!!
		 * Workaround used to extract method from addProblemPropertiesFields()-method
		 * and still work with instantine-GWT plugin
		 * 
		 * all other tries to do it in simply way failed.
		 * I tried to extract non-static method in ProblemOverview - failed.
		 * I tried to extract static method in ProblemOverview - failed.
		 * 
		 * Obviously it worked normally (when executing application) but
		 * DESIGN-mode in instantine-GWT plugin blowed up (DAMN!)
		 * @author michal
		 *
		 */
		static class StaticHelperClass{
			static String width;
			static void setWidth(String s){
				width = s;			
			}
			/**
			 * Just pass the label name and textBox reference and the method
			 * create horizontal panel with it 
			 * @param labelName
			 * @param textBox - should be already initialized (member of the class)
			 * @return
			 */
			static HorizontalPanel generateLabeledTextBoxPanel(String labelName, TextBox textBox){
				HorizontalPanel horizontalPane = new HorizontalPanel();
				Label l = new Label(labelName);
				l.setWidth(width);
				horizontalPane.add(l);
				horizontalPane.add(textBox);		
				return horizontalPane;
			}		
		}
		
		
		VerticalPanel generateLeftPanel(){
			VerticalPanel panel = new VerticalPanel();
			panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			panel.add(generatePeopleList());
			panel.setHeight("400");
			return panel;
		}
		
		VerticalPanel generateRightPanel(){
			VerticalPanel panel = new VerticalPanel();
			panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			panel.add(generatePeopleList());
			panel.setHeight("400");
			return panel;
		}
		
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
			return cp; // sorry ... refactor this shit later !!! TODO!
		}
		
		
		Composite generateRightLowerPanel() {
			CaptionPanel cp = new CaptionPanel("Komentarz");
			cp.add(_textArea);
			_textArea.setHeight("263");
			return cp;			
		}
			
				
		
		
		
		
		VerticalPanel generatePeopleList() {
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
			cpRight.setHeight("400");
			cpRight.add(descriptionPanel);		
			vp.add(cpRight);
		
			return vp; // sorry ... refactor this shit later !!! TODO!
		}
			
			
	}
