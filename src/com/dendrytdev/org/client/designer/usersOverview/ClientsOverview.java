package com.dendrytdev.org.client.designer.usersOverview;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ClientsOverview extends Composite{
	ClientsOverviewController controller;
	
	HorizontalPanel hpGlowny=new HorizontalPanel();
	
	
	CaptionPanel cpListaPracownikow=new CaptionPanel("Lista klientow");
	VerticalPanel vpKlienci=new VerticalPanel();
	Label lSort=new Label("Sortowanie/wyszukiwanie: ");
	ListBox lbSort=new ListBox();
	ListBox lbClients=new ListBox();
	Button bOdswiez=new Button("Odswiez");
	Label lWyszukaj=new Label("Wyszukaj:");
	TextBox tbWyszukaj=new TextBox();
	
	
	
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
	
	HorizontalPanel hpSort=new HorizontalPanel();
	
	
	TextBox tbLogin=new TextBox();
	PasswordTextBox ptbHaslo=new PasswordTextBox();
	PasswordTextBox ptbPowtHaslo=new PasswordTextBox();
	TextBox tbNazwa=new TextBox();
	TextBox tbEmail=new TextBox();
	TextBox tbCity=new TextBox();
	TextBox tbAddress=new TextBox();
	TextBox tbTelefon=new TextBox();
	CheckBox cbPolisa=new CheckBox();
	
	Button bZapisz=new Button("Zapisz");
	Button bUsun=new Button("Usun");
	
	
	
	public ClientsOverview() {
		{
			
			initWidget(hpGlowny);
	
			
			
			bOdswiez.setSize("75", "25");
			lbClients.setVisibleItemCount(9);
			lbClients.setWidth("380");
			lbSort.setSize("200", "25");
			lbSort.setVisibleItemCount(1);
			bUsun.setSize("130", "30");
			bZapisz.setSize("130", "30");
			vpKlienci.setSpacing(5);
			gDane.setCellSpacing(3);
			hpGlowny.setSpacing(5);
			
			
			lbSort.addItem("Login");
			lbSort.addItem("Nazwisko i imie");
			
			hpSort.add(lSort);
			hpSort.add(lbSort);
			
			
			
			vpKlienci.add(hpSort);
			vpKlienci.add(lbClients);
			vpKlienci.add(bOdswiez);
			vpKlienci.add(lWyszukaj);
			vpKlienci.add(tbWyszukaj);
			
		
			
			cpListaPracownikow.add(vpKlienci);
			
			
			
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
			gDane.setWidget(9, 0, bUsun);
			gDane.setWidget(9, 1, bZapisz);
			
			
			controller=new ClientsOverviewController(this);
			

			
			
			lbClients.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.setClient();
					
				}});
			bOdswiez.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.reload();
					
				}});
			bZapisz.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.saveChanges();
					
				}});
			bUsun.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.deleteClient();
					
				}});
			cpDane.add(gDane);
			
			hpGlowny.add(cpListaPracownikow);
			hpGlowny.add(cpDane);
			
		}
	}

}
