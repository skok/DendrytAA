package com.dendrytdev.org.client.designer.usersAddition;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.SimplePanel;

public class EmpAddition extends Composite {
	HorizontalPanel horizontalPanel = new HorizontalPanel();
	VerticalPanel verticalPanel = new VerticalPanel();
	VerticalPanel verticalPanel_1 = new VerticalPanel();
	final RadioButton rbService = new RadioButton("proffesion");
	final RadioButton rbDesigner = new RadioButton("proffesion");
	final RadioButton rbProgrammer = new RadioButton("proffesion");
	final RadioButton rbTest = new RadioButton("proffesion");
	CaptionPanel captionPanel_1 = new CaptionPanel("Podstawowe dane");
	SimplePanel simplePanel_1 = new SimplePanel();
	SimplePanel simplePanel = new SimplePanel();
	Button button = new Button("Dodaj pracownika");
	Grid grid = new Grid(7, 2);
	final TextBox tbLogin = new TextBox();
	final PasswordTextBox ptbPassword = new PasswordTextBox();
	final PasswordTextBox ptbPassword2 = new PasswordTextBox();
	final TextBox tbName = new TextBox();
	final TextBox tbSurname = new TextBox();
	final TextBox tbTelephone = new TextBox();
	final TextBox tbEmail = new TextBox();
	
	EmployeeAdditionController controller;
	
	public EmpAddition() {

		controller=new EmployeeAdditionController(this);
		
		
		initWidget(horizontalPanel);

		horizontalPanel.setSize("700", "400");

		

		CaptionPanel captionPanel = new CaptionPanel("Funkcja pracownika");
		verticalPanel.add(captionPanel);

		
		captionPanel.setContentWidget(verticalPanel_1);
		verticalPanel_1.setSize("5cm", "3cm");

		
		rbService.setText("Serwisant");
		verticalPanel_1.add(rbService);

		
		rbDesigner.setText("Projektant");
		verticalPanel_1.add(rbDesigner);

		
		rbProgrammer.setText("Programista");
		verticalPanel_1.add(rbProgrammer);

		
		rbTest.setText("Tester");
		verticalPanel_1.add(rbTest);

		
		horizontalPanel.add(captionPanel_1);
		captionPanel_1.setSize("310", "239");

	
		horizontalPanel.add(simplePanel_1);
		simplePanel_1.setWidth("20");

		horizontalPanel.add(verticalPanel);

	
		verticalPanel.add(simplePanel);
		simplePanel.setHeight("60");

	
		verticalPanel.add(button);

		button.setSize("150", "30");


		captionPanel_1.setContentWidget(grid);
		grid.setSize("5cm", "3cm");
		Label lLogin = new Label("Login:");
		grid.setWidget(0, 0, lLogin);


		grid.setWidget(0, 1, tbLogin);
		Label lPassword = new Label("Haslo:");
		grid.setWidget(1, 0, lPassword);


		grid.setWidget(1, 1, ptbPassword);
		ptbPassword.setSize("146", "22");
		Label lPassword2 = new Label("Potwierdz haslo:");
		grid.setWidget(2, 0, lPassword2);

	
		grid.setWidget(2, 1, ptbPassword2);
		ptbPassword2.setSize("146", "22");
		Label lName = new Label("Imie:");
		grid.setWidget(3, 0, lName);


		grid.setWidget(3, 1, tbName);
		Label lSurname = new Label("Nazwisko:");
		grid.setWidget(4, 0, lSurname);


		grid.setWidget(4, 1, tbSurname);
		Label lTelephone = new Label("Telefon");
		grid.setWidget(5, 0, lTelephone);


		grid.setWidget(5, 1, tbTelephone);
		Label lemail = new Label("E-mail:");
		grid.setWidget(6, 0, lemail);


		grid.setWidget(6, 1, tbEmail);

		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				controller.addEmployee();
			}
		});

		setSize("700", "400");
	}

}
