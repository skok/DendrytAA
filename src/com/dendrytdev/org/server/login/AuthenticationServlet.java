package com.dendrytdev.org.server.login;



import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.login.LoginDTO;
import com.dendrytdev.org.client.login.IAuthenticateUser;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AuthenticationServlet extends RemoteServiceServlet implements IAuthenticateUser, IHttpSessionProvider {

	private static final long serialVersionUID = 1L;
	AuthenticateUserImpl impl = new AuthenticateUserImpl();
	Logger _tracer = Logger.getLogger(this.getClass().getName());
	
	public AuthenticationServlet() {
	}
	
	public void updateSessionState(Function userType, String login){
		HttpSession h = getHttpSession();
		LoginTool.setUsertype(h, userType);
		if(userType == Function.NOT_A_USER){
			_tracer.info("attempt to login as [" + login + "] failed.");
			logoutInternal();		
		}else{
			_tracer.info("user [" + login + ";" + userType + "] loged in.");
			LoginTool.setLogin(h, login);			
		}
	}
	
	@Override
	public Function authenticate(LoginDTO person) {
		Function userType = impl.authenticate(person);
		updateSessionState(userType, person.getLogin());			
		return userType;
	}
	
	public HttpSession getHttpSession(){
		return getThreadLocalRequest().getSession();
	}

	@Override
	public void logout() {
		//TODO: refactor
		HttpSession h = getHttpSession();
		_tracer.info("user [" + LoginTool.getLogin(h) + "] loged off.");
		logoutInternal();
	}
	
	/**
	 * splited into internal impl for tracing purposes only
	 */
	void logoutInternal(){
		HttpSession h = getHttpSession();
		LoginTool.logout(h);				
	}
	
	
	
}
