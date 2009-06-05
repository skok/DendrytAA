package com.dendrytdev.org.client;

import com.dendrytdev.org.client.login.LogInInterface;
import com.google.gwt.core.client.EntryPoint;


public class DendrytAA implements EntryPoint {
	/**
	 * TODO: refactor :>
	 */
	public static void start(){
		IUserInterface i = new LogInInterface();
		i.mainInterface();
	}
	
	/**
	 * entry point method.
	 */
	public void onModuleLoad() {
		
//		IUserInterfaceFactory interfaceFactory;
		
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
