package com.dendrytdev.org.client;

import com.google.gwt.user.client.ui.Composite;

public interface IUserInterfaceFactory {

	public Composite generateDesignerInterface();

	public Composite generateProgrammerInterface();

	public Composite generateServicerInterface();

	public Composite generateTesterInterface();

	public Composite generateClientInterface();

}