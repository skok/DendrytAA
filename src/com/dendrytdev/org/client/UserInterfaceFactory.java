package com.dendrytdev.org.client;

import com.dendrytdev.org.client.Servicer.Services;
import com.dendrytdev.org.client.problemOverview.ProblemOverview;
import com.dendrytdev.org.client.problemSubmiting.ProblemSubmiting;
import com.dendrytdev.org.client.productsAndGroupsAddition.GroupsAddition;
import com.dendrytdev.org.client.productsAndGroupsAddition.ProductsAddition;
import com.dendrytdev.org.client.productsAndGroupsOverview.GroupsOverview;
import com.dendrytdev.org.client.productsAndGroupsOverview.ProductsOverview;
import com.dendrytdev.org.client.usersAddition.ClientsAddition;
import com.dendrytdev.org.client.usersAddition.EmpAddition;
import com.dendrytdev.org.client.usersOverview.ClientsOverview;
import com.dendrytdev.org.client.usersOverview.EmpOverview;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;

public class UserInterfaceFactory implements IUserInterfaceFactory {


	@Override
	public Composite generateDesignerInterface() {
		DecoratedTabPanel usersAddition = new DecoratedTabPanel();
		usersAddition.add(new EmpAddition(), "Dodawanie pracownikow");
		usersAddition.add(new ClientsAddition(), "Dodawanie klientow");
		usersAddition.selectTab(0);

		DecoratedTabPanel productsAndGroupsAddition = new DecoratedTabPanel();
		productsAndGroupsAddition.add(new GroupsAddition(), "Dodawanie grup");
		productsAndGroupsAddition.add(new ProductsAddition(), "Dodawanie produktow");
		productsAndGroupsAddition.selectTab(0);

		final DecoratedTabPanel usersOverview = new DecoratedTabPanel();
		usersOverview.add(new EmpOverview(), "Przeglad pracownikow");
		usersOverview.add(new ClientsOverview(), "Przeglad klientow");

		usersOverview.selectTab(0);

		DecoratedTabPanel productsAndGroupsOverview = new DecoratedTabPanel();
		productsAndGroupsOverview.add(new GroupsOverview(), "Przeglad grup");
		productsAndGroupsOverview.add(new ProductsOverview(), "Przeglad produktow");
		productsAndGroupsOverview.selectTab(0);

		DecoratedTabPanel problemOverview = new DecoratedTabPanel();
		problemOverview.add(new ProblemOverview(), "Przeglad wszystkich zgloszen");
		problemOverview.selectTab(0);

		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		decoratedTabPanel.add(usersAddition, "Dodawanie uzytkownikow");
		usersAddition.setSize("700", "400");

		decoratedTabPanel.add(productsAndGroupsAddition, "Dodawanie grup i produktow");
		decoratedTabPanel.add(usersOverview, "Przegladanie uzytkownikow");
		usersOverview.setSize("700", "400");

		decoratedTabPanel.add(productsAndGroupsOverview, "Przegladanie grup i produktow");
		productsAndGroupsOverview.setSize("800", "400");
		productsAndGroupsAddition.setSize("250", "210");
		decoratedTabPanel.add(problemOverview, "Przeglad zgloszen i raportow");

		decoratedTabPanel.selectTab(4);

		return decoratedTabPanel;
	}
	
	
	@Override
	public Composite generateProgrammerInterface() {
		throw new RuntimeException("not implemented yet!");
	}
	
	@Override
	public Composite generateServicerInterface() {
		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		Services s = new Services();
		decoratedTabPanel.add(s, "Zglaszanie problemow");
		s.setSize("300", "300");
		decoratedTabPanel.selectTab(0);
		return decoratedTabPanel;
	}
	@Override
	public Composite generateTesterInterface() {
		throw new RuntimeException("not implemented yet!");
	}
	

	@Override
	public Composite generateClientInterface() {
		DecoratedTabPanel decoratedTabPanel = new DecoratedTabPanel();
		ProblemSubmiting s = new ProblemSubmiting();
		decoratedTabPanel.add(s, "Zglaszanie problemow");
		s.setSize("300", "300");
		decoratedTabPanel.selectTab(0);
		return decoratedTabPanel;
	}

	

	

}