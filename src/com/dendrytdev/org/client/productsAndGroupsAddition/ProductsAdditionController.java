package com.dendrytdev.org.client.productsAndGroupsAddition;

import java.util.Iterator;
import java.util.List;

import com.dendrytdev.org.client.bean.Group;
import com.dendrytdev.org.client.bean.Product;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ProductsAdditionController {
	List<Group> groups;
	ProductsAddition pa;
	
	GroupsServiceAsync serviceGroups=(GroupsServiceAsync)GWT.create(GroupsService.class);
	
	ProductsServiceAsync service=(ProductsServiceAsync)GWT.create(ProductsService.class);
	
	public ProductsAdditionController(ProductsAddition pa){
		this.pa=pa;
		refresh();
		
	}
	public void refresh(){
		serviceGroups.getAllGroups(new AsyncCallback<List<Group>>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad przy sciaganiu grup z serwera");
				
			}

			@Override
			public void onSuccess(List<Group> result) {
				pa.lbGroup.clear();
				groups=result;
				Iterator<Group> it=groups.iterator();
				while(it.hasNext()){
					pa.lbGroup.addItem(it.next().getName());
				}
				if(groups!=null && groups.size()>0){
					pa.lbGroup.setSelectedIndex(0);
				}
				pa.tbProduct.setText("");
				pa.tbVersion.setText("");
				
			}});
	}
	public void addProduct(){
		if(pa.tbProduct.getText().length()>2 && pa.tbVersion.getText().length()>0){
			Product p=new Product();
			p.setGroup(pa.lbGroup.getItemText(pa.lbGroup.getSelectedIndex()));
			p.setName(pa.tbProduct.getText());
			p.setVersion(pa.tbVersion.getText());
			
			service.addProduct(p, new AsyncCallback<Boolean>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Blad przy dodawaniu");
					
				}

				@Override
				public void onSuccess(Boolean result) {
					if(result==true){
						Window.alert("Dodano");
						pa.tbProduct.setText("");
						pa.tbVersion.setText("");
					}else{
						Window.alert("Produkt i podanych parametrach juz istnieje");
						pa.tbProduct.setText("");
						pa.tbVersion.setText("");
					}
					
					
				}});
			
		}else{
			Window.alert("Produkt musi miec co najmniej 3 znaki a wersja 1");
		}
	}
}
