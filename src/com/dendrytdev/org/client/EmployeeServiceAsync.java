package com.dendrytdev.org.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmployeeServiceAsync {
	public void myMethod(String s, AsyncCallback<String> callback);
}
