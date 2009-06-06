package com.dendrytdev.org.client.designer.usersAddition;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class ClientsAddition extends Composite{
	ClientAdditionController controller;
	
	CaptionPanel cpDane=new CaptionPanel("Dane klienta");
	Grid gDane=new Grid(10,2);
	
	Label lLogin=new Label("Login");
	Label lHaslo=new Label("Haslo:");
	Label lPowtHaslo=new Label("Powtorz haslo");
	Label lNazwa=new Label("Nazwa klienta:");
	Label lEmail=new Label("E-mail:");
	Label lCity=new Label("Miasto:");
	Label lAddress=new Label("Adres:");
	Label lTelefon=new Label("Telefon:");
	Label lPolisa=new Label("Polisa");
	
	TextBox tbLogin=new TextBox();
	PasswordTextBox ptbHaslo=new PasswordTextBox();
	PasswordTextBox ptbPowtHaslo=new PasswordTextBox();
	TextBox tbNazwa=new TextBox();
	TextBox tbEmail=new TextBox();
	TextBox tbCity=new TextBox();
	TextBox tbAddress=new TextBox();
	TextBox tbTelefon=new TextBox();
	CheckBox cbPolisa=new CheckBox();
	
	Button bDodaj=new Button("Dodaj");
	
	public ClientsAddition() {
		{
			controller=new ClientAdditionController(this);
			
			initWidget(cpDane);
			
			gDane.setWidget(0, 0, lLogin);
			gDane.setWidget(1, 0, lHaslo);
			gDane.setWidget(2, 0, lPowtHaslo);
			gDane.setWidget(3, 0, lNazwa);
			gDane.setWidget(4, 0, lEmail);
			gDane.setWidget(5, 0, lAddress);
			gDane.setWidget(6, 0, lCity);
			gDane.setWidget(7, 0, lTelefon);
			gDane.setWidget(8, 0, lPolisa);
			
			gDane.setWidget(0, 1, tbLogin);
			gDane.setWidget(1, 1, ptbHaslo);
			gDane.setWidget(2, 1, ptbPowtHaslo);
			gDane.setWidget(3, 1, tbNazwa);
			gDane.setWidget(4, 1, tbEmail);
			gDane.setWidget(5, 1, tbCity);
			gDane.setWidget(6, 1, tbAddress);
			gDane.setWidget(7, 1, tbTelefon);
			gDane.setWidget(8, 1, cbPolisa);
			
			gDane.setWidget(9, 0, bDodaj);
			
			bDodaj.setSize("130", "25");
			
			bDodaj.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.addClient();
					
				}});
			
			cpDane.add(gDane);
			
		}
	}

}
