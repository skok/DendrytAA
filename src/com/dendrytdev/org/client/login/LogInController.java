package com.dendrytdev.org.client.login;



import com.dendrytdev.org.client.ClientUIFactory;
import com.dendrytdev.org.client.DesignerUIFactory;
import com.dendrytdev.org.client.IUserInterface;
import com.dendrytdev.org.client.Servicer.Services;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.tools.IType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootPanel;

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
			
			if(result == Function.NOT_A_USER){
				userInterface = new LogInInterface();
				//TODO sprawdzic kolejnosc
				//(new LogInInterface()).mainInterface();
				Window.alert("Niepoprawny login lub haslo!");
				userInterface.mainInterface();
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
				
			
//			userInterface.mainInterface();
			RootPanel.get().add(new LogoutButton());
			
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
