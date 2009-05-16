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
//	//private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	/* (non-Javadoc)
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	public void onModuleLoad() {

		RootPanel rootPanel = RootPanel.get();
		{
			DecoratedTabPanel usersAddition=new DecoratedTabPanel();
			usersAddition.add(new EmpAddition(),"Dodawanie pracownikow");
			usersAddition.add(new ClientsAddition(),"Dodawanie klientow");
			usersAddition.selectTab(0);
			
			DecoratedTabPanel productsAndGroupsAddition=new DecoratedTabPanel();
			productsAndGroupsAddition.add(new GroupsAddition(),"Dodawanie grup");
			productsAndGroupsAddition.add(new ProductsAddition(),"Dodawanie produktow");
			productsAndGroupsAddition.selectTab(0);
			
			DecoratedTabPanel usersOverview=new DecoratedTabPanel();
			usersOverview.add(new EmpOverview(),"Przeglad pracownikow");
			usersOverview.add(new ClientsOverview(),"Przeglad klientow");
			usersOverview.selectTab(0);
			
			DecoratedTabPanel productsAndGroupsOverview=new DecoratedTabPanel();
			productsAndGroupsOverview.add(new GroupsOverview(),"Przeglad grup");
			productsAndGroupsOverview.add(new ProductsOverwiew(),"Przeglad produktow");
			productsAndGroupsAddition.selectTab(0);
			
			DecoratedTabPanel problemOverview=new DecoratedTabPanel();
			problemOverview.add(new ProblemOverview(),"Przeglad wszystkich zgloszen");
			problemOverview.selectTab(0);
			
			DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
			
			decoratedTabPanel.add(usersAddition,"Dodawanie uzytkownikow");
			usersAddition.setSize("700", "400");
			
			decoratedTabPanel.add(productsAndGroupsAddition,"Dodawanie grup i produktow");
			decoratedTabPanel.add(usersOverview,"Przegladanie uzytkownikow");
			decoratedTabPanel.add(productsAndGroupsOverview,"Przegladanie grup i produktow");
			decoratedTabPanel.add(problemOverview,"Przeglad zgloszen i raportow");
			
			decoratedTabPanel.selectTab(4);
			rootPanel.add(decoratedTabPanel);
			

			
		}
	

	}
}
