package com.dendrytdev.org.client.tools;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;

public interface IDialogBoxFactory {
	/**
	 * 
	 * Create DialogBox with Label with contains content string
	 * xor with embeded composite-c
	 * 
	 * @return
	 */
	public DialogBox createInfoDialogBox(String title, String content, Composite c);
	public DialogBox createTODODialogBox();
	public DialogBox createSystemErrorBox(String content);
}