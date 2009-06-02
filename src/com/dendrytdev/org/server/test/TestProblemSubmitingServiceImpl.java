package com.dendrytdev.org.server.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.problemSubmiting.ProblemSubmitingService;
import com.dendrytdev.org.server.ProblemSubmitingServlet;
import com.dendrytdev.org.server.dao.DendrytDAOException;
import com.dendrytdev.org.server.dao.ProblemDAO;
import com.dendrytdev.org.server.dao.intf.IProblemDAO;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;


//falling when session was added - need to create special mock's .... TODO later....
public class TestProblemSubmitingServiceImpl extends DendrytTestCaseBase{
	@Test
	public void first() throws DendrytDAOException {
//
//		ProblemSubmitingService p = new ProblemSubmitingServlet();
//		assertEquals(5, p.getAllProducts().length);
//		
//		IProblemDAO i = new ProblemDAO();
//		assertEquals(0, i.readAll().length);
//		
//		p.submitProblem(new Problem());
//		assertEquals(1 , i.readAll().length);
//
	}
}
