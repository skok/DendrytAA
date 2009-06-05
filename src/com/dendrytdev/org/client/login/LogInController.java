package com.dendrytdev.org.client.login;



import com.dendrytdev.org.client.UserInterfaceFactory;
import com.dendrytdev.org.client.DendrytAA;

import com.dendrytdev.org.client.IUserInterface;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LogInController {
	private IAuthenticateUserAsync loginService;
	private String login;
	
	
	private AsyncCallback<Function> logInCallback=new AsyncCallback<Function>(){

		public void onFailure(Throwable caught) {
			DialogBox todoDialogBox1 = GuiFactory.getInstance().createSystemErrorBox("LogInController" + caught.getMessage());
			todoDialogBox1.center();	 
		}

		//REFACTOR THIS !!!!!!!!!!!!!!!!!!!!!!!!! TODO:
		public void onSuccess(Function result) {
			RootPanel.get().clear();

			if(result == Function.NOT_A_USER){
				Window.alert("Niepoprawny login lub haslo!");
				DendrytAA.start();
				return;
			}else{
				RootPanel.get().add(result.getUserInterface());
			}

				
			
			HorizontalPanel hp = new HorizontalPanel();
			Hyperlink h = new Hyperlink();
		
			h.setText("wyloguj");
			h.addClickHandler(new ClickHandler(){

				@Override
				public void onClick(ClickEvent event) {
					loginService.logout(new AsyncCallback<?>(){
						@Override
						public void onFailure(Throwable caught) {
							DialogBox todoDialogBox1 = GuiFactory.getInstance().createSystemErrorBox("LogInController" + caught.getMessage());
							todoDialogBox1.center();	
						}

						@Override
						public void onSuccess(Object result) {
							DendrytAA.start();
						}
					});
				}
				
			});
			hp.add(new Label("Zalogowany jako " + login + "  |  "));
			hp.add(h);
			RootPanel.get().add(hp);
		}
		
	};
	public void setLogInCallback(AsyncCallback<Function> as){
		logInCallback=as;
	}
	LogInController() {
		loginService=(IAuthenticateUserAsync) GWT.create(IAuthenticateUser.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) loginService;
		endpoint.setServiceEntryPoint(GWT.getModuleBaseURL() + "AuthenticationServlet");
	}

	public void authenticate(String login, String password) {
		this.login = login;
		loginService.authenticate(new LoginDTO(login, password), logInCallback);
	}
}
