package com.dendrytdev.org.client;

import com.dendrytdev.org.client.Servicer.Services;
import com.dendrytdev.org.client.login.LogInInterface;
import com.dendrytdev.org.client.problemOverview.raportOverview.RaportOverview;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;



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
	 * TODO: refactor :>
	 */
	public static void start(){
		IUserInterface i = new LogInInterface();
		i.mainInterface();
	}
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		IUserInterfaceFactory interfaceFactory;
		
		// TODO: implement strategy here
//		interfaceFactory = new DesignerUIFactory();
//		interfaceFactory = new ClientUIFactory();
//		RootPanel.get().clear();
//		RootPanel.get().add(interfaceFactory.generateMainUI());

		
		start();
	
		
//		RootPanel.get().clear();
//		RootPanel.get().add(new RaportOverview());
		// for gui designing purposes - its easy to see what i actually develop without logging
		

	

	}
	

	
}
