package com.dendrytdev.org.server.login;

import javax.servlet.http.HttpSession;

public interface IHttpSessionProvider{
	HttpSession getHttpSession();
}
