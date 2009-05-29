package com.dendrytdev.org.client.usersAddition;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
	EmployeeServiceAsync service = (EmployeeServiceAsync) GWT
			.create(EmployeeService.class);

	public EmpAddition() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);

		horizontalPanel.setSize("700", "400");

		VerticalPanel verticalPanel = new VerticalPanel();

		CaptionPanel captionPanel = new CaptionPanel("Funkcja pracownika");
		verticalPanel.add(captionPanel);

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		captionPanel.setContentWidget(verticalPanel_1);
		verticalPanel_1.setSize("5cm", "3cm");

		final RadioButton rbService = new RadioButton("proffesion");
		rbService.setText("Serwisant");
		verticalPanel_1.add(rbService);

		final RadioButton rbDesigner = new RadioButton("proffesion");
		rbDesigner.setText("Projektant");
		verticalPanel_1.add(rbDesigner);

		final RadioButton rbProgrammer = new RadioButton("proffesion");
		rbProgrammer.setText("Programista");
		verticalPanel_1.add(rbProgrammer);

		final RadioButton rbTest = new RadioButton("proffesion");
		rbTest.setText("Tester");
		verticalPanel_1.add(rbTest);

		CaptionPanel captionPanel_1 = new CaptionPanel("Podstawowe dane");
		horizontalPanel.add(captionPanel_1);
		captionPanel_1.setSize("310", "239");

		SimplePanel simplePanel_1 = new SimplePanel();
		horizontalPanel.add(simplePanel_1);
		simplePanel_1.setWidth("20");

		horizontalPanel.add(verticalPanel);

		SimplePanel simplePanel = new SimplePanel();
		verticalPanel.add(simplePanel);
		simplePanel.setHeight("60");

		Button button = new Button("Dodaj pracownika");
		verticalPanel.add(button);

		button.setSize("150", "30");

		Grid grid = new Grid(7, 2);
		captionPanel_1.setContentWidget(grid);
		grid.setSize("5cm", "3cm");
		Label lLogin = new Label("Login:");
		grid.setWidget(0, 0, lLogin);

		final TextBox tbLogin = new TextBox();
		grid.setWidget(0, 1, tbLogin);
		Label lPassword = new Label("Haslo:");
		grid.setWidget(1, 0, lPassword);

		final PasswordTextBox ptbPassword = new PasswordTextBox();
		grid.setWidget(1, 1, ptbPassword);
		ptbPassword.setSize("146", "22");
		Label lPassword2 = new Label("Potwierdz haslo:");
		grid.setWidget(2, 0, lPassword2);

		final PasswordTextBox ptbPassword2 = new PasswordTextBox();
		grid.setWidget(2, 1, ptbPassword2);
		ptbPassword2.setSize("146", "22");
		Label lName = new Label("Imie:");
		grid.setWidget(3, 0, lName);

		final TextBox tbName = new TextBox();
		grid.setWidget(3, 1, tbName);
		Label lSurname = new Label("Nazwisko:");
		grid.setWidget(4, 0, lSurname);

		final TextBox tbSurname = new TextBox();
		grid.setWidget(4, 1, tbSurname);
		Label lTelephone = new Label("Telefon");
		grid.setWidget(5, 0, lTelephone);

		final TextBox tbTelephone = new TextBox();
		grid.setWidget(5, 1, tbTelephone);
		Label lemail = new Label("E-mail:");
		grid.setWidget(6, 0, lemail);

		final TextBox tbEmail = new TextBox();
		grid.setWidget(6, 1, tbEmail);

		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (tbLogin.getText() != "") {
					if (ptbPassword.getText().equals(ptbPassword2.getText()) 
							|| ptbPassword.getText().length() < 3) {
						Person p = new Person();
						p.setLogin(tbLogin.getText());
						p.setEmail(tbEmail.getText());
						p.setFirstName(tbName.getText());
						p.setPassword(ptbPassword.getText());
						p.setSurname(tbSurname.getText());
						p.setTelephone(tbTelephone.getText());
						if(rbDesigner.getValue()){
							p.setFunction(Function.DESIGNER);
						}else if(rbProgrammer.getValue()){
							p.setFunction(Function.PROGRAMMER);
						}else if(rbService.getValue()){
							p.setFunction(Function.SERVICE);
						}else if(rbTest.getValue()){
							p.setFunction(Function.TESTER);
						}
						service.addPerson(p, new AsyncCallback<Boolean>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Blad przy dodawaniu");
								Window.alert(caught.getMessage());
							}

							@Override
							public void onSuccess(Boolean result) {
								if (result == true) {
									tbLogin.setText("");
									tbName.setText("");
									tbEmail.setName("");
									tbSurname.setText("");
									tbTelephone.setText("");
									ptbPassword.setText("");
									ptbPassword2.setText("");
									Window.alert("Uzytkownik dodany");
								} else {
									tbLogin.setText("");
									Window.alert("Login zajety");
								}

							}
						});
					} else {
						ptbPassword.setText("");
						ptbPassword2.setText("");
						Window.alert("Haslo musi zawierac conajmniej 3 znaki, pola \"haslo\" i \"powtorz\" haslo musza byc rowne ");
					}
				} else {
					Window.alert("Wpisz login!");
				}
			}
		});

		setSize("700", "400");
	}

}
