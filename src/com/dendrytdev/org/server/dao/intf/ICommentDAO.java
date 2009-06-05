package com.dendrytdev.org.server.dao.intf;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.server.dao.DendrytDAOException;

public interface ICommentDAO {
	boolean create(Comment c) throws DendrytDAOException;
	Comment[] readAll() throws DendrytDAOException;
	Comment read(Long id) throws DendrytDAOException;
	boolean update(Comment c) throws DendrytDAOException;
	void delete(Comment c) throws DendrytDAOException;
}
