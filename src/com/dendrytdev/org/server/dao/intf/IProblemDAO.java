package com.dendrytdev.org.server.dao.intf;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.server.dao.DendrytDAOException;

public interface IProblemDAO {
	boolean create(Problem p) throws DendrytDAOException;;
	Problem[] read() throws DendrytDAOException;;
	Problem read(Long id) throws DendrytDAOException;
	Problem[] readAll() throws DendrytDAOException;
	void delete(Problem c) throws DendrytDAOException;
}
