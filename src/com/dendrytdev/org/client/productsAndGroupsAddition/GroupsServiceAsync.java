package com.dendrytdev.org.client.productsAndGroupsAddition;

import java.util.List;

import com.dendrytdev.org.client.bean.Group;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GroupsServiceAsync {
	public void addGroup(Group g,AsyncCallback<Boolean> asyncCallback);
	public void removeGroup(Group g,AsyncCallback<Object> asyncCallback);
	public void getAllGroups(AsyncCallback<List<Group>> asyncCallback);
}
