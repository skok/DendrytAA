package com.dendrytdev.org.client;

import com.dendrytdev.org.client.problemSubmiting.ProblemSubmiting;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;

/**
 * Client(client in system's actor meaning) UI factory
 */
public class ClientUIFactory implements IUserInterfaceFactory{

	@Override
	public Composite generateMainUI() {
		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		ProblemSubmiting s = new ProblemSubmiting();
		decoratedTabPanel.add(s,"Zglaszanie problemow");
		s.setSize("300", "300");
		
		decoratedTabPanel.selectTab(0);
		
		return decoratedTabPanel;
	}

}