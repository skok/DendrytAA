package com.dendrytdev.org.client.problemSubmiting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.problemOverview.IProblemOverview;
import com.dendrytdev.org.client.problemOverview.IProblemOverviewController;
import com.dendrytdev.org.client.problemOverview.ProblemMultiWordSuggestion;
import com.dendrytdev.org.client.problemOverview.ProblemOverviewController;
import com.dendrytdev.org.client.problemOverview.ProblemSuggestOracle;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.dendrytdev.org.client.tools.IDialogBoxFactory;
import com.google.gwt.user.client.ui.*;

public class ProblemSubmitingMain extends Composite implements IProblemOverview {
		
		
		void blankAllFields(){
			final String EMPTY = "";
			
			// initialize textboxes
			_productTextBox.setText(EMPTY);
			_ratioTextBox.setText(EMPTY);
			_servicemanTextBox.setText(EMPTY);
			_designerTextBox.setText(EMPTY);
			_programmerTextBox.setText(EMPTY);
			_testerTextBox.setText(EMPTY);
			
			_textArea.setText(EMPTY);
			
			//_suggestBox.setText(EMPTY);
			
		}
		ListBox _listBox;
		
		
		// fields connected with PRODUCT
		TextBox _productTextBox;
		TextBox _ratioTextBox;
		
		// fields connected with ASSIGNMENT
		TextBox _servicemanTextBox;
		TextBox _designerTextBox;
		TextBox _programmerTextBox;
		TextBox _testerTextBox;
		
		TextArea _textArea;
		
		SuggestBox _suggestBox;
		ProblemSuggestOracle _oracle;
		
		Button _submitButton;

		IDialogBoxFactory _factory = GuiFactory.getInstance();
		
		//register controler - refactor later ...
		ProblemSubmitingController controller = new ProblemSubmitingController(this);
		
		
		Map<Integer, Problem> _problemMap;
		int _problemListHashCode;
		
		public ProblemSubmitingMain() {
			
			// initialize listBox
			_listBox = new ListBox();
			

			_listBox.setVisibleItemCount(5);
		
			
			
			// initialize textboxes
			_productTextBox = new TextBox();
			_ratioTextBox = new TextBox();


			_servicemanTextBox = new TextBox();
			_designerTextBox = new TextBox();
			_programmerTextBox = new TextBox();
			_testerTextBox = new TextBox();
			
			_textArea = new TextArea();
		
			_oracle = new ProblemSuggestOracle(); 
			_suggestBox = new SuggestBox(_oracle);

			
			
			
			
			// initialize buttons
			final DialogBox todoDialogBox1 = _factory.createTODODialogBox();
			_submitButton = new Button("Zglos problem", new ClickListener(){
				@Override
				public void onClick(Widget sender) {
					todoDialogBox1.center();
				}
			});
			
			


			
			
			_problemMap = new HashMap<Integer, Problem>();
			_problemListHashCode = IProblemOverview.PROBLEM_LIST_NOT_DOWNLOADED_YET;
			
			
	
			
			HorizontalPanel mainPanel = new HorizontalPanel();
			initWidget(mainPanel);
			mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//			mainPanel.setWidth("500");

		
			
			/////////////////////////////////////////////////////////
			//create RIGHT Panel
			VerticalPanel rightVerticalPanel = new VerticalPanel();
			mainPanel.add(rightVerticalPanel);

			//add labels with textboxes on up of RIGHT Panel
			rightVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
			
			rightVerticalPanel.add(generateMiddlePanel());
			rightVerticalPanel.setHeight("400");

			
			
			
			


			

			
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
		
		
		/**
		 * Generates a set of horizontal panels with labels and textboxes.
		 * All it is connected with content of Problem-bean	 * 
		 * @param panel - panel to which it adds this hPanels
		 */
		VerticalPanel generateMiddlePanel() {
			
			
			VerticalPanel panel = new VerticalPanel();
			StaticHelperClass.setWidth("200");
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Produkt:", _productTextBox));
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Waga zglaszajacego:", _ratioTextBox));

			
			CaptionPanel cp = new CaptionPanel("Informacje o produkcie");
			cp.add(panel);
			VerticalPanel vp = new VerticalPanel();
			vp.setHeight("400");
			vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
			vp.add(cp);
			
			
			VerticalPanel descriptionPanel = new VerticalPanel();
		    _textArea.setCharacterWidth(40);
		    _textArea.setVisibleLines(20);
		    descriptionPanel.add(_textArea);
		    descriptionPanel.add(_submitButton);
			CaptionPanel cpRight = new CaptionPanel("Opis problemu");
			cpRight.setHeight("400");
			cpRight.add(descriptionPanel);		
			vp.add(cpRight);
//			vp.add(generateRightDownPanel());
			
			
			return vp; // sorry ... refactor this shit later !!! TODO!
		}
			
		
		VerticalPanel generateAssignmentFieldsPanel() {
			VerticalPanel panel = new VerticalPanel();
			StaticHelperClass.setWidth("200");
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Serwisant:", _servicemanTextBox));
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Projektant:", _designerTextBox));
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Programista:", _programmerTextBox));
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Tester:", _testerTextBox));
			return panel;
		}
		
		

		public void updateProblemList(List<Problem> problemList){
			if(problemList == null){
				// internal error here, this argument should not be null !
				return; 
			}
			_problemListHashCode = problemList.hashCode();
			_listBox.clear();
			_problemMap.clear();
			_oracle.clear();

			Integer i = 1; 
			String s;
			for(Problem p : problemList){
				_problemMap.put(i, p);
				s = i++ + "." + p.getProduct();
				_listBox.addItem(s);
				
				// fill oracle below
				_oracle.add(new ProblemMultiWordSuggestion(p));			
			}		

			blankAllFields();
		}
		
		
		
		/**
		 * @param i - index from the map
		 */
		void fillTextBoxes(int i){
			Problem p = _problemMap.get(i);
			_productTextBox.setText(p.getProduct());

			
			
			
			_ratioTextBox.setText(p.getClientImportance());
		
			_servicemanTextBox.setText(p.getService());
			_designerTextBox.setText(p.getDesigner());
			_programmerTextBox.setText(p.getProgrammer());
			_testerTextBox.setText(p.getTester());
			
			_textArea.setText(p.getDescription());		
		}

		@Override
		public int getProblemListHashCode() {
			return _problemListHashCode;
		}
		
		
	}
