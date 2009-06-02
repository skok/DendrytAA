package com.dendrytdev.org.client.usersOverview;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RadioButton;

public class EmpOverview extends Composite {
	HorizontalPanel horizontalPanel = new HorizontalPanel();
	CaptionPanel captionPanel = new CaptionPanel("Lista pracownikow");
	VerticalPanel verticalPanelLeft = new VerticalPanel();
	HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
	Label label = new Label("Sortowanie/wyszukiwanie: ");
	ListBox listBoxSortSearch = new ListBox();
	final ListBox listBoxEmployees = new ListBox();
	Label labelSearch = new Label("Wyszukaj");
	TextBox textBox = new TextBox();
	VerticalPanel verticalPanelRight = new VerticalPanel();
	CaptionPanel captionPanelDate = new CaptionPanel("Dane");
	Grid grid = new Grid(7, 2);
	Label lPassword=new Label("Haslo");
	PasswordTextBox ptbPassword=new PasswordTextBox();
	Label lPassword2=new Label("Powtorz Haslo");
	PasswordTextBox ptbPassword2=new PasswordTextBox();
	
	CaptionPanel captionPanelFunction = new CaptionPanel("Funkcja");
	VerticalPanel verticalPanel_1 = new VerticalPanel();
	final RadioButton rbService = new RadioButton("function", "Serwisant");
	final RadioButton rbDesigner = new RadioButton("function", "Projektant");
	final RadioButton rbProgrammer = new RadioButton("function", "Programista");
	final RadioButton rbTest = new RadioButton("function", "Tester");
	Button bremove = new Button("Usun pracownika");
	Button bSave = new Button("Zapisz zmiany");
	Button bRefresh=new Button("Odswiez");
	HorizontalPanel hpButtons = new HorizontalPanel();
	final TextBox tbLogin = new TextBox();
	final TextBox tbName = new TextBox();
	final TextBox tbSurname = new TextBox();
	final TextBox tbTelephone = new TextBox();
	final TextBox tbEmail = new TextBox();
	Label lLogin = new Label("Login:");
	Label lName = new Label("Imie:");
	Label lSurname = new Label("Nazwisko:");
	Label lTelephone = new Label("Telefon:");
	Label lEmail = new Label("E-mail:");
	
	
	EmployeeOverviewController controller;
	
	public EmpOverview() {
		controller=new EmployeeOverviewController(this);
		
		initWidget(horizontalPanel);
		horizontalPanel.setSize("630", "331");

		horizontalPanel.add(captionPanel);
		captionPanel.setSize("390", "330");

		captionPanel.setContentWidget(verticalPanelLeft);
		verticalPanelLeft.setSize("386", "300");

		verticalPanelLeft.add(horizontalPanel_1);

		horizontalPanel_1.add(label);

		horizontalPanel_1.add(listBoxSortSearch);
		listBoxSortSearch.setSize("200", "25");
		listBoxSortSearch.setVisibleItemCount(1);
		listBoxSortSearch.addItem("Login");
		listBoxSortSearch.addItem("Nazwisko i imie");
		listBoxSortSearch.setSelectedIndex(0);

		listBoxEmployees.setWidth("380");
		listBoxEmployees.setVisibleItemCount(9);
		

		verticalPanelLeft.add(listBoxEmployees);
		verticalPanelLeft.add(bRefresh);
		bRefresh.setSize("75", "25");
		bRefresh.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				controller.reload();
				
			}});
		
		verticalPanelLeft.add(labelSearch);

		verticalPanelLeft.add(textBox);

		horizontalPanel.add(verticalPanelRight);

		verticalPanelRight.add(captionPanelDate);

		captionPanelDate.setContentWidget(grid);
		grid.setSize("5cm", "3cm");


		grid.setWidget(0, 0, lLogin);

		grid.setWidget(1, 0, lName);

		grid.setWidget(2, 0, lSurname);

		grid.setWidget(3, 0, lTelephone);

		grid.setWidget(4, 0, lEmail);
		grid.setWidget(5, 0, lPassword);
		grid.setWidget(6, 0, lPassword2);

		grid.setWidget(0, 1, tbLogin);
		tbLogin.setEnabled(false);
		
		grid.setWidget(1, 1, tbName);

		grid.setWidget(2, 1, tbSurname);

		grid.setWidget(3, 1, tbTelephone);

		
		grid.setWidget(4, 1, tbEmail);

		grid.setWidget(5, 1, ptbPassword);
		grid.setWidget(6, 1, ptbPassword2);
		
		verticalPanelRight.add(captionPanelFunction);

		captionPanelFunction.setContentWidget(verticalPanel_1);
		verticalPanel_1.setSize("5cm", "3cm");

		verticalPanel_1.add(rbService);

		verticalPanel_1.add(rbDesigner);

		verticalPanel_1.add(rbProgrammer);

		verticalPanel_1.add(rbTest);

		bremove.setSize("130", "30");

		bSave.setSize("130", "30");

		hpButtons.setSpacing(5);
		hpButtons.add(bremove);
		hpButtons.add(bSave);

		verticalPanelRight.add(hpButtons);

		listBoxEmployees.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				controller.setEmployee();
				
			}
		});

		bremove.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				controller.deleteEmployee();

			}
		});

		bSave.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				controller.saveChanges();
			}
		});
	}

}
