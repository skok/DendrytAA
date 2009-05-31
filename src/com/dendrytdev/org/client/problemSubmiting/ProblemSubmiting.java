package com.dendrytdev.org.client.problemSubmiting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.problemOverview.IProblemOverview;
import com.dendrytdev.org.client.problemOverview.IProblemOverviewController;
import com.dendrytdev.org.client.problemOverview.ProblemMultiWordSuggestion;
import com.dendrytdev.org.client.problemOverview.ProblemOverviewController;
import com.dendrytdev.org.client.problemOverview.ProblemSuggestOracle;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.dendrytdev.org.client.tools.IDialogBoxFactory;
import com.google.gwt.user.client.ui.*;

public class ProblemSubmiting extends Composite implements IProblemSubmiting{
		
		
		void blankAllFields(){
			final String EMPTY = "";
			
			// initialize textboxes
			_productListbox.clear();
			_importanceTextBox.clear();
			_servicemanTextBox.setText(EMPTY);
			_designerTextBox.setText(EMPTY);
			_programmerTextBox.setText(EMPTY);
			_testerTextBox.setText(EMPTY);
			
			_descriptionTextArea.setText(EMPTY);
			
			//_suggestBox.setText(EMPTY);
			
		}
		ListBox _listBox;
		
		
		// fields connected with PRODUCT
		ListBox _productListbox;
		ListBox _importanceTextBox;
		
		// fields connected with ASSIGNMENT
		TextBox _servicemanTextBox;
		TextBox _designerTextBox;
		TextBox _programmerTextBox;
		TextBox _testerTextBox;
		
		TextArea _descriptionTextArea;
		
		SuggestBox _suggestBox;
		ProblemSuggestOracle _oracle;
		
		Button _submitButton;

		IDialogBoxFactory _factory = GuiFactory.getInstance();
		
		//register controler - refactor later ...
		ProblemSubmitingController controller = new ProblemSubmitingController(this);
		
		
	
		public ProblemSubmiting() {
			
			// initialize listBox
			_listBox = new ListBox();
			

			_listBox.setVisibleItemCount(5);
		
			
			
			// initialize textboxes
			_productListbox = new ListBox();
			_importanceTextBox = new ListBox();
			_importanceTextBox.addItem("1");
			_importanceTextBox.addItem("2");
			_importanceTextBox.addItem("3");
			_importanceTextBox.addItem("4");
			


			_servicemanTextBox = new TextBox();
			_designerTextBox = new TextBox();
			_programmerTextBox = new TextBox();
			_testerTextBox = new TextBox();
			
			_descriptionTextArea = new TextArea();
		
			_oracle = new ProblemSuggestOracle(); 
			_suggestBox = new SuggestBox(_oracle);

			
			
			
			
			// initialize buttons
			final DialogBox todoDialogBox1 = _factory.createTODODialogBox();
			_submitButton = new Button("Zglos problem", new ClickListener(){
				@Override
				public void onClick(Widget sender) {
					controller.submitProblem(getFilledProblem());
				}
			});
			
				

			
	
			
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

			
			controller.updateProductList();
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
			static HorizontalPanel generateLabeledTextBoxPanel(String labelName, Widget textBox){
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
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Produkt:", _productListbox));
			panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Waga zglaszajacego:", _importanceTextBox));

			
			CaptionPanel cp = new CaptionPanel("Informacje o produkcie");
			cp.add(panel);
			VerticalPanel vp = new VerticalPanel();
			vp.setHeight("400");
			vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
			vp.add(cp);
			
			
			VerticalPanel descriptionPanel = new VerticalPanel();
		    _descriptionTextArea.setCharacterWidth(40);
		    _descriptionTextArea.setVisibleLines(20);
		    descriptionPanel.add(_descriptionTextArea);
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
		
		@Override
		public void updateProductList(Product[] arr){
			_productListbox.clear();
			for(Product p : arr){
				_productListbox.addItem(p.getName());				
			}
		}
		
		public Problem getFilledProblem(){
			Problem p = new Problem();
			p.setProduct(_productListbox.getItemText(_productListbox.getSelectedIndex()));
			p.setClientImportance(_importanceTextBox.getItemText(_importanceTextBox.getSelectedIndex()));
			p.setDescription(_descriptionTextArea.getText());
			System.out.println(p.getDescription());
			return p;
		}
		
	}
