package com.dendrytdev.org.server.login;


import javax.servlet.http.HttpSession;
import com.dendrytdev.org.client.login.Data;
import com.dendrytdev.org.client.login.IAuthenticateUser;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AuthenticationServlet extends RemoteServiceServlet implements IAuthenticateUser {

	private static final long serialVersionUID = 1L;
	AuthenticateUserImpl impl = new AuthenticateUserImpl();

	public AuthenticationServlet() {
	}
	@Override
	public int authenticate(Data person) {
		impl.setHttpSession(getHttpSession());
		int authenticate = impl.authenticate(person);

		return authenticate;
	}
	
	private HttpSession getHttpSession(){
		return getThreadLocalRequest().getSession();
	}
}
