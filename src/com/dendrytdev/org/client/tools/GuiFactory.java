package com.dendrytdev.org.client.tools;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;

public class GuiFactory implements IDialogBoxFactory {
	final static IDialogBoxFactory instance = new GuiFactory();
	private GuiFactory(){}
	public static IDialogBoxFactory getInstance(){
		return instance;
	}
	
	public DialogBox createInfoDialogBox(String title, String content){
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText(title);
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Zamknij");
		VerticalPanel vp = new VerticalPanel();
		vp.add(new Label(content));
		vp.add(closeButton);
		dialogBox.setWidget(vp);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});
		
		return dialogBox;
	}
	
	public DialogBox createTODODialogBox(){
		return createInfoDialogBox("AlkoAGILE2009", "TODO: WILL BE IMPLEMENTED SOON !!!");
	}
	
	
}
