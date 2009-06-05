package com.dendrytdev.org.client.productsAndGroupsOverview;

import java.util.Iterator;
import java.util.List;

import com.dendrytdev.org.client.bean.Group;
import com.dendrytdev.org.client.productsAndGroupsAddition.GroupsService;
import com.dendrytdev.org.client.productsAndGroupsAddition.GroupsServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class GroupsOverviewController {
	GroupsOverview go;
	List<Group> groups;
	GroupsServiceAsync service=(GroupsServiceAsync)GWT.create(GroupsService.class);
	
	public GroupsOverviewController(GroupsOverview go){
		this.go=go;
	
	}
	public void refresh(){
		service.getAllGroups(new AsyncCallback<List<Group>>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad przy sciaganiu wszystkich grup");
				
			}

			@Override
			public void onSuccess(List<Group> result) {
				go.lb.clear();
				
				groups=result;
				setAnyGroup();
				
			}});
	}
	public void setAnyGroup(){
		if(groups!=null && groups.size()>0){
			Iterator<Group> it=groups.iterator();
			while(it.hasNext()){
				go.lb.addItem(it.next().getName());
			}
			go.lb.setSelectedIndex(0);
			
		}
		
		
	}
	public void remove(){
		Group g=new Group();
		g.setName(go.lb.getItemText(go.lb.getSelectedIndex()));
		service.removeGroup(g, new AsyncCallback<Object>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad przy usuwaniu");
				
				
			}

			@Override
			public void onSuccess(Object result) {
				refresh();
				
			}});
	}
}
