package com.dendrytdev.org.client;

import com.dendrytdev.org.client.problemOverview.ProblemOverview;
import com.dendrytdev.org.client.productsAndGroupsAddition.GroupsAddition;
import com.dendrytdev.org.client.productsAndGroupsAddition.ProductsAddition;
import com.dendrytdev.org.client.productsAndGroupsOverview.GroupsOverview;
import com.dendrytdev.org.client.productsAndGroupsOverview.ProductsOverwiew;

import com.dendrytdev.org.client.usersAddition.ClientsAddition;
import com.dendrytdev.org.client.usersAddition.EmpAddition;
import com.dendrytdev.org.client.usersOverview.ClientsOverview;
import com.dendrytdev.org.client.usersOverview.EmpOverview;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.DecoratedTabPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DendrytAA implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
//	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);



	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {
		
		IUserInterfaceFactory interfaceFactory;
		
		// TODO: implement strategy here
		interfaceFactory = new ClientUIFactory();
		interfaceFactory = new DesignerUIFactory();
		RootPanel.get().clear();
		RootPanel.get().add(interfaceFactory.generateMainUI());

	}
	

	
}
