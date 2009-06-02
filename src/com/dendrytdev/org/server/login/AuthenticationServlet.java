package com.dendrytdev.org.server.login;



import javax.servlet.http.HttpSession;
import com.dendrytdev.org.client.login.LoginDTO;
import com.dendrytdev.org.client.login.IAuthenticateUser;
import com.dendrytdev.org.client.tools.IType;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AuthenticationServlet extends RemoteServiceServlet implements IAuthenticateUser, IHttpSessionProvider {

	private static final long serialVersionUID = 1L;
	AuthenticateUserImpl impl = new AuthenticateUserImpl();

	public AuthenticationServlet() {
	}
	
	public void fillUserIntoSession(int userType, String login){
		HttpSession h = getHttpSession();
		LoginTool.setUsertype(h, userType);
		if(userType == IType.Funkcje.NOT_A_USER){
			LoginTool.setLogin(h, "");			
		}else{
			LoginTool.setLogin(h, login);			
		}
		System.out.println("filled, user logedin: " + userType + " login:" + login);
	}
	
	@Override
	public int authenticate(LoginDTO person) {
		int userType = impl.authenticate(person);
		if(userType != IType.Funkcje.NOT_A_USER){ // handle successful login
			fillUserIntoSession(userType, person.getLogin());			
		}
		return userType;
	}
	
	public HttpSession getHttpSession(){
		return getThreadLocalRequest().getSession();
	}

	@Override
	public void logout() {
		LoginTool.logout(getHttpSession());		
	}
	
	
	
}
