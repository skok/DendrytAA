package com.dendrytdev.org.client.login;



import com.dendrytdev.org.client.ClientUIFactory;
import com.dendrytdev.org.client.DesignerUIFactory;
import com.dendrytdev.org.client.IUserInterface;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.RootPanel;

public class LogInController {
	private IAuthenticateUserAsync loginService;
	private String login;
	
	
	private AsyncCallback<Integer> logInCallback=new AsyncCallback<Integer>(){

		public void onFailure(Throwable caught) {
			Window.alert("Error"+caught.toString());
			 
		}

		public void onSuccess(Integer result) {
			IUserInterface userInterface = null;
			
			//TODO - tylko na czas testowania, poki nie ma kont klienckich
//			if(DebugModeSetting.ALWAYS_LOGIN_CLIENT){
//				result = IFunkcje.KLIENT;				
//			}
			
			RootPanel.get().clear();
			
			switch(result) {
			case -1:
				userInterface = new LogInInterface();
				//TODO sprawdzic kolejnosc
				//(new LogInInterface()).mainInterface();
				Window.alert("Niepoprawny login lub haslo!");
				userInterface.mainInterface();
				break;
//			case IFunkcje.SERWISANT:
//				userInterface = new ServiceInterface(login);
//				break;
//				
			case IFunkcje.DESIGNER:
//				userInterface = new DesignerInterface(login);
				//REFACTOR THIS CRAP!!!!!!!!!!!!!!!!!!!!!!!!! TODO:
				RootPanel.get().add(new DesignerUIFactory().generateMainUI());
				break;
				
			case IFunkcje.CLIENT:
//				userInterface = new ClientInterface();
				RootPanel.get().add(new ClientUIFactory().generateMainUI());
				break;
				
//			case IFunkcje.PROGRAMISTA:
//				userInterface = new ProgrammerInterface(login);
//				break;
//				
//			case IFunkcje.TESTER:
//				userInterface = new TesterInterface(login);
//				break;
				
			default:
				System.err.println(result);
				Window.alert("Nieobsluzony typ uzytkownika!");
				return;
			}
//			userInterface.mainInterface();
			
		}
		
	};
	public void setLogInCallback(AsyncCallback<Integer> as){
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
