package com.dendrytdev.org.client.designer.productsAndGroupsOverview;

import com.dendrytdev.org.client.designer.usersOverview.ClientsOverviewController;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ProductsOverview extends Composite{
	CaptionPanel cpProducts=new CaptionPanel("Lista produktow");
	Label lSort=new Label("Sortowanie/wyszukiwanie");
	ListBox lbSort=new ListBox();
	Label lSearch=new Label("Wyszukaj");
	TextBox tbSearch=new TextBox();
	HorizontalPanel hpSort=new HorizontalPanel();
	ListBox lbProducts=new ListBox();
	
	
	
	Label lProduct=new Label("Produkt: ");
	Label lVersion=new Label("Wersja: ");
	Label lgroup=new Label("Grupa: ");
	
	TextBox tbProduct=new TextBox();
	TextBox tbVersion=new TextBox();
	TextBox tbgroup=new TextBox();
	
	Button bRemove=new Button("Usun");
	
	Button bRefresh=new Button("Odswiez");
	
	HorizontalPanel hp=new HorizontalPanel();
	
	VerticalPanel vpProducts=new VerticalPanel();
	
	Grid gProduct=new Grid(4,2);
	
	ProductsOverviewController controller;
	
	public ProductsOverview() {
		{
			initWidget(hp);
			
			tbProduct.setEnabled(false);
			tbVersion.setEnabled(false);
			tbgroup.setEnabled(false);
			
			controller=new ProductsOverviewController(this);
			
			bRefresh.setHeight("25");
			bRemove.setHeight("25");
			
			hp.add(vpProducts);
			hp.add(gProduct);
	
			hpSort.add(lSort);
			hpSort.add(lbSort);
			
			lbSort.addItem("Produkt");
			lbSort.addItem("Grupa");
			lbSort.addItem("Wersja");
			
			
			lbSort.setVisibleItemCount(1);
			lbSort.setWidth("150");
			
			lbProducts.setVisibleItemCount(9);
			lbProducts.setWidth("330");
			
			vpProducts.add(hpSort);
			vpProducts.add(lbProducts);
			
			vpProducts.add(bRefresh);
			
			vpProducts.add(lSearch);
			vpProducts.add(tbSearch);
			
			vpProducts.setSpacing(5);
			
			
			gProduct.setWidget(0, 0, lProduct);
			gProduct.setWidget(1, 0, lVersion);
			gProduct.setWidget(2, 0, lgroup);
			
			gProduct.setWidget(0, 1, tbProduct);
			gProduct.setWidget(1, 1, tbVersion);
			gProduct.setWidget(2, 1, tbgroup);
			
			gProduct.setWidget(3, 0, bRemove);
			
			
			lbProducts.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.setProduct();
					
				}});
			
			bRefresh.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.refresh();
					
				}});
			bRemove.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					controller.remove();
					
				}});
			
		}
	}

}
