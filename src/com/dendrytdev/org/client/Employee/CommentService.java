package com.dendrytdev.org.client.employee;

import com.dendrytdev.org.client.bean.Function;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("CommentService")
public interface CommentService extends RemoteService{
	void addComment(Long problemId,Function function,Boolean direction, String content);
}
