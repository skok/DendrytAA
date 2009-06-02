package com.dendrytdev.org.client.login;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IAuthenticateUserAsync {
	void authenticate(LoginDTO person, AsyncCallback<Integer> callback);
	void logout(AsyncCallback a);
}
