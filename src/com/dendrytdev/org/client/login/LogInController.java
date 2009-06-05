package com.dendrytdev.org.client.login;



import com.dendrytdev.org.client.ClientUIFactory;
import com.dendrytdev.org.client.DendrytAA;
import com.dendrytdev.org.client.DesignerUIFactory;
import com.dendrytdev.org.client.IUserInterface;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.tools.GuiFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
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
			Window.alert("Error"+caught.toString());
			 
		}

		//REFACTOR THIS CRAP!!!!!!!!!!!!!!!!!!!!!!!!! TODO:
		public void onSuccess(Function result) {
			
			
			
			IUserInterface userInterface = null;
			
			RootPanel.get().clear();
			
//			userInterface.mainInterface();
		
			
			
			
			if(result == Function.NOT_A_USER){
				userInterface = new LogInInterface();
				//TODO sprawdzic kolejnosc
				//(new LogInInterface()).mainInterface();
				Window.alert("Niepoprawny login lub haslo!");
//				userInterface.mainInterface();
				DendrytAA.start();
				return;
			}else if(result == Function.SERVICE){
//				userInterface = new ServiceInterface(login);		
			}else if(result == Function.DESIGNER){
//				userInterface = new DesignerInterface(login);
				RootPanel.get().add(new DesignerUIFactory().generateMainUI());
			}else if(result == Function.CLIENT){
//				userInterface = new ClientInterface();
				RootPanel.get().add(new ClientUIFactory().generateMainUI());
			}else if(result == Function.PROGRAMMER){
//				userInterface = new ProgrammerInterface(login);
			}else if(result == Function.TESTER){
//				userInterface = new TesterInterface(login);
			}else{
				Window.alert("Nieobsluzony typ uzytkownika: " + result);
				return;
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
							// TODO Auto-generated method stub	
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
