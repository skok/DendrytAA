package com.dendrytdev.org.client.login;

import com.dendrytdev.org.client.DendrytAA;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;

public class LogoutButton extends Button{
	private IAuthenticateUserAsync _loginService;
	
	public LogoutButton(){
		
		setText("Wyloguj");
		
		_loginService = (IAuthenticateUserAsync) GWT.create(IAuthenticateUser.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) _loginService;
		endpoint.setServiceEntryPoint(GWT.getModuleBaseURL() + "AuthenticationServlet");
		
		
		addClickHandler(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				_loginService.logout(new AsyncCallback<Object>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Object result) {
						DendrytAA.start();
					}
					
				});
				
			}
		});
	}

}
