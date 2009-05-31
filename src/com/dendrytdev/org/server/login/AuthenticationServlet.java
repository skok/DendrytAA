package com.dendrytdev.org.server.login;


import javax.servlet.http.HttpSession;
import com.dendrytdev.org.client.login.LoginDTO;
import com.dendrytdev.org.client.login.IAuthenticateUser;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AuthenticationServlet extends RemoteServiceServlet implements IAuthenticateUser, IHttpSessionProvider {

	private static final long serialVersionUID = 1L;
	AuthenticateUserImpl impl = new AuthenticateUserImpl();

	public AuthenticationServlet() {
	}
	@Override
	public int authenticate(LoginDTO person) {
		int authenticate = impl.authenticate(person, this);
		return authenticate;
	}
	
	public HttpSession getHttpSession(){
		return getThreadLocalRequest().getSession();
	}
	
}
