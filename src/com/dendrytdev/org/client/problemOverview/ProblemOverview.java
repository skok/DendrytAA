package com.dendrytdev.org.client.problemOverview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.problemOverview.raportOverview.RaportOverview;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.dendrytdev.org.client.tools.IDialogBoxFactory;
import com.dendrytdev.org.client.tools.IType;
import com.google.gwt.user.client.ui.*;

/**
 * ProblemOverview composite
 * gives client opportunity to search for dendryt-Problems
 * @author michal
 *
 */
public class ProblemOverview extends Composite implements IProblemOverview {
	
	
	void blankAllFields(){
		_productTextBox.setText(IType.EMPTY_STRING);
		_firstNameTextBox.setText(IType.EMPTY_STRING);
		_surnameTextBox.setText(IType.EMPTY_STRING);
		_phoneTextBox.setText(IType.EMPTY_STRING);
		_ratioTextBox.setText(IType.EMPTY_STRING);
		_dateTextBox.setText(IType.EMPTY_STRING);

		_servicemanTextBox.setText(IType.EMPTY_STRING);
		_designerTextBox.setText(IType.EMPTY_STRING);
		_programmerTextBox.setText(IType.EMPTY_STRING);
		_testerTextBox.setText(IType.EMPTY_STRING);
	
		_descriptionTextArea.setText(IType.EMPTY_STRING);	
	}
	
	
	ListBox _listBox = new ListBox();
	
		
	// initialize textboxes connected with PRODUCT
	TextBox _productTextBox = new TextBox();
	TextBox _firstNameTextBox = new TextBox();
	TextBox _surnameTextBox = new TextBox();
	TextBox _phoneTextBox = new TextBox();
	TextBox _ratioTextBox = new TextBox();
	TextBox _dateTextBox = new TextBox();
	
	// fields connected with ASSIGNMENT
	TextBox _servicemanTextBox = new TextBox();
	TextBox _designerTextBox = new TextBox();
	TextBox _programmerTextBox = new TextBox();
	TextBox _testerTextBox = new TextBox();
	
	TextArea _descriptionTextArea = new TextArea();	
	ProblemSuggestOracle _oracle = new ProblemSuggestOracle(); 
	SuggestBox _suggestBox = new SuggestBox(_oracle);
	
	Button _assignmentButton;
	Button _gotoRaportsButton;
	Button _refreshListButton;

	IDialogBoxFactory _factory = GuiFactory.getInstance();
	
	//register controler - refactor later ...
	IProblemOverviewController controller = new ProblemOverviewController(this);
	
	
	Map<Integer, Problem> _problemMap;
	int _problemListHashCode;
	
	void onListboxClick(){
		int inx = -100;
		try{
			inx = _listBox.getSelectedIndex();
			if(inx == -1){ // none is selected
				return;
			}
			String s = _listBox.getItemText(inx);			
			s = s.split("\\.")[0];
			Integer i = Integer.valueOf(s);
			fillTextBoxes(i);	
		}catch(Throwable t){
//			t.printStackTrace();
			return; // do nothing TODO: refactor the shit
		}
	}
	
	public ProblemOverview() {
		_listBox.setVisibleItemCount(5);
		_listBox.addClickListener(new ClickListener(){

			@Override
			public void onClick(Widget sender) {
				onListboxClick();						
			}
			
		});
		
		
		_suggestBox.addEventHandler(new SuggestionHandler(){

			@Override
			public void onSuggestionSelected(SuggestionEvent event) {
				ProblemMultiWordSuggestion p = (ProblemMultiWordSuggestion) event.getSelectedSuggestion();
				
				int inx = 0;
				for(Integer i : _problemMap.keySet()){
					if(_problemMap.get(i).equals(p.getProblem())){
						inx = i;
					}
				}
				_listBox.setSelectedIndex(inx - 1); //indexed from 0
				onListboxClick();
			}
			
		});
	
		_assignmentButton = new Button("Przydziel", new ClickListener(){
			@Override
			public void onClick(Widget sender) {
				
				DialogBox todoDialogBox1 = _factory.createTODODialogBox();
				todoDialogBox1.center();
				todoDialogBox1.setPopupPosition(todoDialogBox1.getAbsoluteLeft(), 100);				
			}
		});

		_gotoRaportsButton = new Button("Otworz raporty", new ClickListener(){
			@Override
			public void onClick(Widget sender) {
				DialogBox todoDialogBox1 = _factory.createInfoDialogBox("Przeglad raportow", null, new RaportOverview());
				todoDialogBox1.center();
				todoDialogBox1.setPopupPosition(todoDialogBox1.getAbsoluteLeft(), 100);				
			}
		});
		
		

		final DialogBox todoDialogBox2 = _factory.createTODODialogBox();
		_refreshListButton = new Button("Odswiez liste", new ClickListener(){
			@Override
			public void onClick(Widget sender) {
				controller.updateProblemList();
			}
		});

		
		
		_problemMap = new HashMap<Integer, Problem>();
		_problemListHashCode = IProblemOverview.PROBLEM_LIST_NOT_DOWNLOADED_YET;
		
		
		// download problem list from server and fill the GUI
		controller.updateProblemList();	
		
		HorizontalPanel mainPanel = new HorizontalPanel();
		initWidget(mainPanel);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		mainPanel.setWidth("500");

		/////////////////////////////////////////////////////////
		//wrapp LEFT Panel and add it to the mainPanel
		Panel leftPanel = generateLeftVerticalPanel(); // creating leftPanel HERE

		
		CaptionPanel leftCaptionPanel = new CaptionPanel("Lista problemow");
		leftCaptionPanel.add(leftPanel);
		leftCaptionPanel.setHeight("400");
		mainPanel.add(leftCaptionPanel);
		
		
		/////////////////////////////////////////////////////////
		//create RIGHT Panel
		VerticalPanel rightVerticalPanel = new VerticalPanel();
		mainPanel.add(rightVerticalPanel);

		//add labels with textboxes on up of RIGHT Panel
		rightVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		rightVerticalPanel.add(generateMiddlePanel());
		rightVerticalPanel.setHeight("400");

			
		//create RIGHT RIGHT ;) Panel
		
		VerticalPanel descriptionPanel = new VerticalPanel();

		// generate description text area here
	    _descriptionTextArea.setCharacterWidth(40);
	    _descriptionTextArea.setVisibleLines(20);

		descriptionPanel.add(_descriptionTextArea);
		
		CaptionPanel cpRight = new CaptionPanel("Opis problemu");
		cpRight.setHeight("400");
		cpRight.add(descriptionPanel);		
		mainPanel.add(cpRight);	
	}

	Panel generateRightDownPanel() {
		VerticalPanel assignmentPanel = new VerticalPanel();
		assignmentPanel.add(generateAssignmentFieldsPanel()); //creating ASSIGNMENT panel HERE
		assignmentPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		assignmentPanel.add(_assignmentButton);

		CaptionPanel panel = new CaptionPanel("Przydzial");
		panel.add(assignmentPanel);
		VerticalPanel vp = new VerticalPanel();
		vp.add(panel);
		vp.add(new Grid(1,1));
		vp.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		vp.add(_gotoRaportsButton);
		
		return vp; // fucking workaround ... TODO: refactor IT !!!!!!!!!		
	}
	
	VerticalPanel generateLeftVerticalPanel(){
		VerticalPanel leftVerticalPanel = new VerticalPanel();
		leftVerticalPanel.setWidth("250");
		_listBox.setSize("200", "300");
		leftVerticalPanel.add(_listBox);

		HorizontalPanel hp = new HorizontalPanel();
		Label label = new Label("Wyszukaj:");
		hp.add(label);
		hp.add(_suggestBox);

		leftVerticalPanel.add(hp);

		_suggestBox.setWidth("120");
		
		leftVerticalPanel.add(_refreshListButton);
		
		return leftVerticalPanel;
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
	 * 
	 * 
	 * WARNING - not thread-safe
	 * @author michal
	 *
	 */
	public static class StaticHelperClass{
		static String width;
		public static void setWidth(String s){
			width = s;			
		}
		/**
		 * Just pass the label name and textBox reference and the method
		 * create horizontal panel with it 
		 * @param labelName
		 * @param textBox - should be already initialized (member of the class)
		 * @return
		 */
		public static HorizontalPanel generateLabeledTextBoxPanel(String labelName, TextBox textBox){
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
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Imie zglaszajacego:", _firstNameTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Nazwisko zglaszajacego:", _surnameTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Telefon zglaszajacego:", _phoneTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Waga zglaszajacego:", _ratioTextBox));
		panel.add(StaticHelperClass.generateLabeledTextBoxPanel("Data zgloszenia:", _dateTextBox));
		
		CaptionPanel cp = new CaptionPanel("Informacje o produkcie");
		cp.add(panel);
		VerticalPanel vp = new VerticalPanel();
		vp.setHeight("400");
		vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
		vp.add(cp);
		vp.add(generateRightDownPanel());
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
		_firstNameTextBox.setText(p.getClient());
//		_surnameTextBox.setText(p.getNazwiskoZglaszajacego());
//		_phoneTextBox.setText(p.get);
		
		// TODO: what about surname and phone ??? 
		// is this information available somewhere 
		// maybe from joining Person with getClient ????????
		
		_ratioTextBox.setText(p.getClientImportance());
		if(p.getProblemDate() != null){
			_dateTextBox.setText(p.getProblemDate().toLocaleString());			
		}
		_servicemanTextBox.setText(p.getService());
		_designerTextBox.setText(p.getDesigner());
		_programmerTextBox.setText(p.getProgrammer());
		_testerTextBox.setText(p.getTester());
		System.out.println("_" + p.getDescription());
		_descriptionTextArea.setText(p.getDescription());		
	}

	@Override
	public int getProblemListHashCode() {
		return _problemListHashCode;
	}
	
	
}
