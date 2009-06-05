package com.dendrytdev.org.client.designer.productsAndGroupsAddition;

import java.util.List;

import com.dendrytdev.org.client.bean.Group;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("GroupsService")
public interface GroupsService extends RemoteService{
	public Boolean addGroup(Group g);
	public void removeGroup(Group g);
	public List<Group> getAllGroups();
}
