package com.dendrytdev.org.client.problemOverview;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.dendrytdev.org.client.tools.IDialogBoxFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * ProblemOverview composite
 * gives client opportunity to search for dendryt-Problems
 * @author michal
 *
 */
public class ProblemOverview extends Composite {
	
	
	void blankAllFields(){
		final String EMPTY = "";
		
		// initialize textboxes
		_productTextBox.setText(EMPTY);
		_firstNameTextBox.setText(EMPTY);
		_surnameTextBox.setText(EMPTY);
		_phoneTextBox.setText(EMPTY);
		_ratioTextBox.setText(EMPTY);
		_dateTextBox.setText(EMPTY);

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
	TextBox _firstNameTextBox;
	TextBox _surnameTextBox;
	TextBox _phoneTextBox;
	TextBox _ratioTextBox;
	TextBox _dateTextBox;
	
	// fields connected with ASSIGNMENT
	TextBox _servicemanTextBox;
	TextBox _designerTextBox;
	TextBox _programmerTextBox;
	TextBox _testerTextBox;
	
	TextArea _textArea;
	
	SuggestBox _suggestBox;
	
	Button _assignmentButton;
	Button _refreshListButton;

	IDialogBoxFactory _factory = GuiFactory.getInstance();
	
	// Service:
	

	
	
	public ProblemOverview() {
		ProblemOverviewServiceAsync service = GWT.create(ProblemOverviewService.class);
		//------
		ServiceDefTarget endpoint = (ServiceDefTarget) service;
		endpoint.setServiceEntryPoint(GWT.getModuleBaseURL() + "ProblemOverviewService");
		
		//------
		
		
		// initialize listBox
		_listBox = new ListBox();
		

		_listBox.setVisibleItemCount(5);
		_listBox.addClickListener(new ClickListener(){

			@Override
			public void onClick(Widget sender) {
				String s = _listBox.getItemText(_listBox.getSelectedIndex());
				s = s.split("\\.")[0];
				Integer i = Integer.valueOf(s);
				fillTextBoxes(i);			
			}
			
		});
		
		
		// initialize textboxes
		_productTextBox = new TextBox();
		_firstNameTextBox = new TextBox();
		_surnameTextBox = new TextBox();
		_phoneTextBox = new TextBox();
		_ratioTextBox = new TextBox();
		_dateTextBox = new TextBox();

		_servicemanTextBox = new TextBox();
		_designerTextBox = new TextBox();
		_programmerTextBox = new TextBox();
		_testerTextBox = new TextBox();
		
		_textArea = new TextArea();
	
		_suggestBox = new SuggestBox();
		
		
		
		
		// initialize buttons
		final DialogBox todoDialogBox1 = _factory.createTODODialogBox();
		_assignmentButton = new Button("Przydziel pracownikow", new ClickListener(){
			@Override
			public void onClick(Widget sender) {
				todoDialogBox1.center();
			}
		});
		
		

		final DialogBox todoDialogBox2 = _factory.createTODODialogBox();
		_refreshListButton = new Button("Odswiez liste", new ClickListener(){
			@Override
			public void onClick(Widget sender) {
				todoDialogBox2.center();
			}
		});

		
		
		
		
		//////////////////////////// TODO: testing purposes ONLY
		fillForTest();
		//////////////////////// TODO: testing purposes ONLY
		
		
		
		
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

		
		
		
		
		
		/////////////////////////////////////////////////////////
		//create RIGHT RIGHT ;) Panel
		
		VerticalPanel descriptionPanel = new VerticalPanel();

		// generate description text area here
		
	    _textArea.setCharacterWidth(40);
	    _textArea.setVisibleLines(20);

		descriptionPanel.add(_textArea);
		
//		DecoratorPanel descriptionWrapper = new DecoratorPanel();
//		descriptionWrapper.setWidget(descriptionPanel);
//		descriptionWrapper.setHeight("400");
//		mainPanel.add(descriptionWrapper);
		
		CaptionPanel cpRight = new CaptionPanel("Opis problemu");
		cpRight.setHeight("400");
		cpRight.add(descriptionPanel);		
		mainPanel.add(cpRight);
		
		service.f(new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				_productTextBox.setText("XXXXXXXXX");
				
			}

			@Override
			public void onSuccess(String result) {
				_productTextBox.setText(result);
				
			}
			});
		
	}

	Panel generateRightDownPanel() {

		VerticalPanel assignmentPanel = new VerticalPanel();
		assignmentPanel.add(generateAssignmentFieldsPanel()); //creating ASSIGNMENT panel HERE
		assignmentPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		assignmentPanel.add(_assignmentButton);

		
		CaptionPanel panel = new CaptionPanel("Przydzial");
		panel.add(assignmentPanel);
		VerticalPanel vp = new VerticalPanel();
		vp.add(panel);
		return vp; // fucking workaround ... TODO: refactor IT !!!!!!!!!		
	}
	
	
	
	VerticalPanel generateLeftVerticalPanel(){
		VerticalPanel leftVerticalPanel = new VerticalPanel();
		leftVerticalPanel.setWidth("250");
//		leftVerticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
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
	
	
	Map<Integer, Problem> _problemMap = new HashMap<Integer, Problem>();
	
	public void updateOfProblemList(List<Problem> problemList){
		_listBox.clear();
		_problemMap.clear();

		Integer i = 1; 
		String s;
		for(Problem p : problemList){
			_problemMap.put(i, p);
			s = i++ + "." + p.getProdukt();
			_listBox.addItem(s);
		}		

		blankAllFields();
	}
	
	
	void fillForTest(){
		List<Problem> list = new ArrayList<Problem>();
		Problem p = new Problem();		
		List<Problem> testingList = new ArrayList<Problem>();
		Problem pr = new Problem();
		pr.setProdukt("ProduktXX1");
		pr.setImieZglaszajacego("IMIE1");
		pr.setNazwiskoZglaszajacego("NAZWISKO1");
		pr.setTelefonZglaszajacego("0774822244");
		pr.setWagaKlienta("2");
		pr.setDataZgloszenia(new Date());
		pr.setSerwisant("S");
		pr.setProjektant("PR");
		pr.setProgramista("PROG");
		pr.setTester("T");
		pr.setOpis("Cos sie zepsulo chyba w czyms tam, albo i nie nawet");
		
		testingList.add(pr);
		
		pr = new Problem();
		pr.setProdukt("ProduktXX2");
		pr.setImieZglaszajacego("IMIE2");
		pr.setNazwiskoZglaszajacego("NAZWISKO2");
		pr.setTelefonZglaszajacego("0774821111");
		pr.setWagaKlienta("4");
		pr.setDataZgloszenia(new Date());
		pr.setSerwisant("S2");
		pr.setProjektant("PR2");
		pr.setProgramista("PROG2");
		pr.setTester("T2");
		pr.setOpis("Wyskoczylo okno z napisem jakims tam bla bla bla");
		testingList.add(pr);
		
		
		updateOfProblemList(testingList); 
	}
	
	
	/**
	 * @param i - index from the map
	 */
	void fillTextBoxes(int i){
		Problem p = _problemMap.get(i);
		_productTextBox.setText(p.getProdukt());
		_firstNameTextBox.setText(p.getImieZglaszajacego());
		_surnameTextBox.setText(p.getNazwiskoZglaszajacego());
		_phoneTextBox.setText(p.getTelefonZglaszajacego());
		_ratioTextBox.setText(p.getWagaKlienta());
		_dateTextBox.setText(p.getDataZgloszenia().toLocaleString());
		
		_servicemanTextBox.setText(p.getSerwisant());
		_designerTextBox.setText(p.getProjektant());
		_programmerTextBox.setText(p.getProgramista());
		_testerTextBox.setText(p.getTester());
		
		_textArea.setText(p.getOpis());		
	}
	
	
}
