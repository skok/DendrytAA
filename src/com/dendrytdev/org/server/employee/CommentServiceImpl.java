package com.dendrytdev.org.server.employee;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.employee.CommentService;
import com.dendrytdev.org.server.dao.DatabaseConnector;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CommentServiceImpl extends RemoteServiceServlet implements CommentService {

	@Override
	public void addComment(Long problemId, Function function,
			Boolean direction, String content) {
		DatabaseConnector.addComment(problemId, function, direction, content);
		
	}

}
