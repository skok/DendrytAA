package com.dendrytdev.org.client.tools;

import com.google.gwt.user.client.ui.DialogBox;

public interface IDialogBoxFactory {
	public DialogBox createInfoDialogBox(String title, String content);
	public DialogBox createTODODialogBox();
}