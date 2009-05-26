package com.dendrytdev.org.client;

import com.google.gwt.user.client.ui.Composite;

/**
 * Factory interface of user specific UI 
 * Each system's user (actor) has it's own factory implementation
 */
public interface IUserInterfaceFactory {
	
	/**
	 * Generate main user specific UI
	 */
	Composite generateMainUI();

}
