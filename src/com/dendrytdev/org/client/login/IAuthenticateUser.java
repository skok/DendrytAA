package com.dendrytdev.org.client.login;

import com.google.gwt.user.client.rpc.RemoteService;

public interface IAuthenticateUser extends RemoteService {
	int authenticate(LoginDTO person);
}
