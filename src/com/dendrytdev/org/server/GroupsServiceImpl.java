package com.dendrytdev.org.server;

import java.util.List;

import com.dendrytdev.org.client.bean.Group;
import com.dendrytdev.org.client.productsAndGroupsAddition.GroupsService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GroupsServiceImpl extends RemoteServiceServlet implements GroupsService {
	public GroupsServiceImpl(){
		super();
	}
	
	@Override
	public Boolean addGroup(Group g) {
		return DatabaseConnector.addGroup(g);
	}

	@Override
	public void removeGroup(Group g) {
		DatabaseConnector.removeGroup(g);

	}

	@Override
	public List<Group> getAllGroups() {
		return DatabaseConnector.getAllGroups();
	}

}
