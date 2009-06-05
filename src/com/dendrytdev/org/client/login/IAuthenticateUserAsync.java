package com.dendrytdev.org.client.login;

import com.dendrytdev.org.client.bean.Function;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IAuthenticateUserAsync {
	void authenticate(LoginDTO person, AsyncCallback<Function> callback);
	void logout(AsyncCallback<?> a);
}
