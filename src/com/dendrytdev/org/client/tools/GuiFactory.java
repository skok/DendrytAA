package com.dendrytdev.org.client.tools;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.*;

public class GuiFactory implements IDialogBoxFactory {
	private static final String TITLE = "AlkoAGILE2009";
	final static IDialogBoxFactory instance = new GuiFactory();
	private GuiFactory(){}
	public static IDialogBoxFactory getInstance(){
		return instance;
	}
	
	@Override
	public DialogBox createInfoDialogBox(String title, String content, Composite c){
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText(title);
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Zamknij");
		VerticalPanel vp = new VerticalPanel();
		if(c != null){
			vp.add(c);			
		}else{
			vp.add(new Label(content));
		}
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
	
	@Override
	public DialogBox createTODODialogBox(){
		return createInfoDialogBox(TITLE, "TODO: WILL BE IMPLEMENTED SOON !!!", null);
	}
	
	
	@Override
	public DialogBox createSystemErrorBox(String content) {
		return createInfoDialogBox(TITLE, "There was an error in the system: " + content, null);
	}
	
	
}
