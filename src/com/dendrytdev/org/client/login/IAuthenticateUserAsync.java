package com.dendrytdev.org.client.login;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IAuthenticateUserAsync {
	void authenticate(Data person, AsyncCallback<Integer> callback);
}
