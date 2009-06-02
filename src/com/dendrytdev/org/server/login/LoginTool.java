package com.dendrytdev.org.server.login;

import javax.servlet.http.HttpSession;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.tools.IType;

/**
 * Static helper in user/login management
 *
 */
public class LoginTool {
	public static String getLogin(HttpSession h){
		return (String) h.getAttribute(IType.SESSION_LOGIN);	
	}
	
	public static void setLogin(HttpSession h, String login){
		h.setAttribute(IType.SESSION_LOGIN, login);
	}
	
	public static Function getUsertype(HttpSession h){
		return (Function) h.getAttribute(IType.SESSION_USERTYPE);	
	}
	
	public static void setUsertype(HttpSession h, Function usertype){
		h.setAttribute(IType.SESSION_USERTYPE, usertype);
	}

	public static boolean isLogged(HttpSession h){
		return (h.getAttribute(IType.SESSION_USERTYPE) != null
				&& h.getAttribute(IType.SESSION_LOGIN) != null);
	}
	
	
	public static void logout(HttpSession h){
		h.setAttribute(IType.SESSION_USERTYPE, null);
		h.setAttribute(IType.SESSION_LOGIN, null);
	}
	
	
}
