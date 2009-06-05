package com.dendrytdev.org.client.productsAndGroupsOverview;

import com.dendrytdev.org.client.usersOverview.ClientsOverviewController;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class GroupsOverview extends Composite{
	CaptionPanel cp=new CaptionPanel("Lista grup");
	VerticalPanel vp=new VerticalPanel();
	FlowPanel fp=new FlowPanel();
	ListBox lb=new ListBox();
	TextBox tb=new TextBox();
	Label lSearch=new Label("Wyszukaj: ");
	Button bRefresh=new Button("Odswiez");
	Button bRemove=new Button("Usun");
	
	GroupsOverviewController controller;

	public GroupsOverview() {
		{
			
			
			initWidget(fp);
			
			controller=new GroupsOverviewController(this);
			
			fp.add(cp);
			

			
			fp.add(bRemove);
			
			bRemove.setHeight("25");
			bRefresh.setHeight("25");
			
			cp.setWidth("210");
			
			cp.add(vp);
			vp.add(lb);
			
			lb.setVisibleItemCount(9);
			lb.setWidth("200");
			
			
			
			vp.add(bRefresh);
			
			vp.add(lSearch);
			vp.add(tb);
			
			vp.setSpacing(5);
			
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
