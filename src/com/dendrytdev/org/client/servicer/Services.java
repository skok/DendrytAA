package com.dendrytdev.org.client.servicer;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Services extends Composite{

	// fields connected with PRODUCT
	ListBox _productListbox;
	ListBox _importanceTextBox;


	TextArea _descriptionTextArea;
	Button _submitButton;
	
	CaptionPanel cpProduct=new CaptionPanel("Informacje o produkcie");
	
	Grid gProduct=new Grid(3,2);
	Label lProduct=new Label("Produkt");
	Label lImportance=new Label("Waga zglaszajacego");
	Label lClient=new Label("Klient");
	
	ListBox lbClients=new ListBox();
	
	CaptionPanel cpDescription=new CaptionPanel("Opis problemu");
	VerticalPanel vpDescription=new VerticalPanel();
	
	VerticalPanel vpMain=new VerticalPanel();
	
	ServicerController controller;
	
	public Services(){
		initWidget(vpMain);
		
		
		cpProduct.add(gProduct);		
		
		gProduct.setCellSpacing(5);
		
		
		
		_importanceTextBox = new ListBox();
		_importanceTextBox.addItem("1");
		_importanceTextBox.addItem("2");
		_importanceTextBox.addItem("3");
		_importanceTextBox.addItem("4");
		
		_productListbox = new ListBox();
		_productListbox.setWidth("150");
		
		gProduct.setWidget(0, 0, lProduct);
		gProduct.setWidget(0, 1, _productListbox);
		gProduct.setWidget(1, 0, lImportance);
		gProduct.setWidget(1, 1, _importanceTextBox);
		gProduct.setWidget(2, 0, lClient);
		gProduct.setWidget(2, 1, lbClients);
		
		lbClients.setWidth("250");
		
		cpDescription.add(vpDescription);
		
		
		
		_submitButton=new Button("Zglos problem");
		
		_descriptionTextArea = new TextArea();
		_descriptionTextArea.setCharacterWidth(40);
		_descriptionTextArea.setVisibleLines(20);
		
		vpDescription.add(_descriptionTextArea);
		vpDescription.add(_submitButton);
		
		vpMain.add(cpProduct);
		vpMain.add(cpDescription);
		
		vpMain.setSpacing(5);
		
		vpDescription.setSpacing(5);
		
		_submitButton.setHeight("25");
		
		
		controller=new ServicerController(this);
		

		
		
		_submitButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				controller.addProblem();	
				
			}});
		
		
	}
}
