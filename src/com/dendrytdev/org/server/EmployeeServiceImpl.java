package com.dendrytdev.org.server;

import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.usersAddition.EmployeeService; //import com.google.gwt.dev.js.rhino.ObjToIntMap.Iterator;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.Query;

public class EmployeeServiceImpl extends RemoteServiceServlet implements
		EmployeeService {

	public EmployeeServiceImpl() {
		super();
	}

	@Override
	public String myMethod(String s) {
		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query query = pm.newQuery(Problem.class);

		s = "";
		try {
			List<Problem> results = (List<Problem>) query.execute();
			if (results.iterator().hasNext()) {
				for (Problem e : results) {
//					if (e.getClient() != null) {
//						s = e.getClient().getLogin() + " "
//								+ e.getClient().getFunction();
//					}
					if (e.getComments() != null) {
						Iterator<Comment> ic =  e.getComments().iterator();
						while (ic.hasNext()) {
							s += " , komentarz: "
									+ ic.next().getMessage();
						}
					}
				}
			} else {
				s = "nic";
			}
		} finally {
			query.closeAll();
		}

		// Person e1=new Person();
		// e1.setLogin("wojtek");
		// e1.setFunction(Function.KLIENT);
		//		
//		 Comment c1=new Comment();
//		 c1.setMessage("komentarz 1");
//			
//		 Comment c2=new Comment();
//		 c2.setMessage("komentarz 2");
//				
//				
//				
//				
//				
//		 Problem p1=new Problem();
//		// p1.setClient(e1);
//		 p1.addComment(c1);
//		 p1.addComment(c2);
//				
//		 try {
//		 pm.makePersistent(p1);
//		 }catch(Exception e){
//		 s=e.toString();
//		 } finally {
//		 pm.close();
//		 }

		return s;
	}

}
