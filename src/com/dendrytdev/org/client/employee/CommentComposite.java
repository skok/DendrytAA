package com.dendrytdev.org.client.employee;

import com.dendrytdev.org.client.bean.Function;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CommentComposite extends Composite{
	CommentServiceAsync service=(CommentServiceAsync)GWT.create(CommentService.class);
	
	
	CaptionPanel cpComment=new CaptionPanel("Komentarz");
	TextArea taComment=new TextArea();

	Button bForward=new Button("Forward");
	Button bBackward=new Button("Backward");
	Button bCancel=new Button("Anuluj");
	
	
	VerticalPanel vpMain=new VerticalPanel();
	HorizontalPanel hpButtons=new HorizontalPanel();
	
	Label lSpace=new Label();
	
	
	Function function;
	Long problemId;
	public CommentComposite(final Function function,final Long problemId){
		initWidget(vpMain);
		
		cpComment.add(taComment);
		
		vpMain.add(cpComment);
		vpMain.add(hpButtons);
		
		hpButtons.add(bForward);
		hpButtons.add(bBackward);
		hpButtons.add(lSpace);
		hpButtons.add(bCancel);
	
		taComment.setSize("400", "300");
		
		bForward.setSize("100", "25");
		bBackward.setSize("100", "25");
		lSpace.setSize("100", "25");
		bCancel.setSize("100", "25");
		
		this.function=function;
		this.problemId=problemId;
		
		if(function==Function.DESIGNER){
			bBackward.setVisible(false);
			bForward.setVisible(true);
			bForward.setText("Do programisty");
		}else if(function==Function.PROGRAMMER){
			bBackward.setVisible(true);
			bForward.setVisible(true);
			bBackward.setText("Do projektanta");
			bForward.setText("Do testera");
			
		}else if(function==Function.TESTER){
			bBackward.setVisible(true);
			bForward.setVisible(true);
			bBackward.setText("Do programisty");
			bForward.setText("Do serwisanta");
		}else if(function==Function.SERVICE){
			bBackward.setVisible(true);
			bForward.setVisible(true);
			bBackward.setText("Do testera");
			bForward.setText("Zakoncz");
		}
		
		bBackward.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				service.addComment(problemId, function, false, taComment.getText(), new AsyncCallback<Object>(){

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Blad przy przekazywaniu do tylu");
						
					}

					@Override
					public void onSuccess(Object result) {
						// TODO Auto-generated method stub
						
					}});
				
				
			}});
		bForward.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				service.addComment(problemId, function, true, taComment.getText(), new AsyncCallback<Object>(){

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Blad przy przekazywaniu do tylu");
						
					}

					@Override
					public void onSuccess(Object result) {
						// TODO Auto-generated method stub
						
					}});
				
			}});
		
		
		
	}
	
	
}
