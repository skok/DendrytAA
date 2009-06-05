package com.dendrytdev.org.client.designer.productsAndGroupsAddition;

import com.dendrytdev.org.client.bean.Group;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GroupsAddition extends Composite{
	GroupsServiceAsync service=(GroupsServiceAsync)GWT.create(GroupsService.class);
	
	
	HorizontalPanel hp=new HorizontalPanel();
	VerticalPanel vp=new VerticalPanel();
	Label lName = new Label("Nazwa grupy:   ");
	TextBox tb=new TextBox();
	Button button=new Button("Dodaj");
	public GroupsAddition() {
		{
			initWidget(vp);
			hp.add(lName);
			hp.add(tb);
			vp.add(hp);
			vp.add(button);
		
			button.setHeight("25");
			button.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					if(tb.getText().length()>2){
					Group g=new Group();
					g.setName(tb.getText());
					service.addGroup(g, new AsyncCallback<Boolean>(){

						@Override
						public void onFailure(Throwable caught) {
							Window.alert("Blad dodawania");
							
						}

						@Override
						public void onSuccess(Boolean result) {
							if(result==true){
								tb.setText("");
								Window.alert("Grupa dodana");
							}else{
								Window.alert("Nazwa grupy juz istnieje, wpisz nowa");
								tb.setText("");
							}
							
						}});
					}else{
						Window.alert("Grupa musi zawierac co najmniej 3 znaki");
						tb.setText("");
					}
				}});
		}
	}

}
