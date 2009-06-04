package com.dendrytdev.org.client.login;

import com.dendrytdev.org.client.bean.Function;
import com.google.gwt.user.client.rpc.RemoteService;

public interface IAuthenticateUser extends RemoteService {
	Function authenticate(LoginDTO person);
	void logout();
}
