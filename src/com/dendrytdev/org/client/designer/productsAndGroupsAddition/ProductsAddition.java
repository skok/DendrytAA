package com.dendrytdev.org.client.designer.productsAndGroupsAddition;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class ProductsAddition extends Composite{	
	
	Grid g=new Grid(4,2);
	Button bAdd=new Button("Dodaj");
	Button bRefresh=new Button("Odswiez");
	
	Label lGroup=new Label("Grupa: ");
	Label lProduct=new Label("Produkt: ");
	Label lVersion=new Label("Wersja: ");
	ListBox lbGroup=new ListBox();
	TextBox tbProduct=new TextBox();
	TextBox tbVersion=new TextBox();
	
	ProductsAdditionController controller;
	public ProductsAddition() {
		{
			
			
			initWidget(g);
			g.setSize("262px", "205px");
			setSize("262", "205");
			
			controller=new ProductsAdditionController(this);
			

			
			
			g.setWidget(0, 0, lGroup);
			lGroup.setSize("80", "21");
			g.setWidget(1, 0, lProduct);
			lProduct.setSize("80", "21");
			g.setWidget(2, 0, lVersion);
			lVersion.setSize("80", "21");
			
			g.setWidget(0, 1, lbGroup);
			g.setWidget(1, 1, tbProduct);
			g.setWidget(2, 1, tbVersion);
			
			lbGroup.setVisibleItemCount(1);
			lbGroup.setWidth("150");
			
			
			g.setWidget(3, 0, bAdd);
			bAdd.setHeight("25");
			bAdd.setWidth("80");
			bRefresh.setHeight("25");
			
			g.setWidget(3, 1, bRefresh);
			g.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_LEFT);
			
			
			bAdd.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.addProduct();
					
				}});
			bRefresh.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.refresh();
					
				}});
			
			
		}
	}

}
