package com.dendrytdev.org.client.employee;

import com.dendrytdev.org.client.bean.Function;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CommentServiceAsync {
	void addComment(Long problemId,Function function,Boolean direction, String content, AsyncCallback<Object> asyncCallback);
}
