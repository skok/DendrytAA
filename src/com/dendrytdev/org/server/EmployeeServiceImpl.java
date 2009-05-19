package com.dendrytdev.org.server;


import java.util.List;

import javax.jdo.PersistenceManager;

import com.dendrytdev.org.client.EmployeeService;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import javax.jdo.Query;

public class EmployeeServiceImpl extends RemoteServiceServlet implements
		EmployeeService {
	
	public EmployeeServiceImpl(){
		super();
	}
	
	@Override
	public String myMethod(String s) {
		PersistenceManager pm=PMF.get().getPersistenceManager();
		
		Query query = pm.newQuery(Problem.class);
		
		s="";
	    try {
	        List<Problem> results = (List<Problem>) query.execute();
	        if (results.iterator().hasNext()) {
	            for (Problem e : results) {
	                s=e.getClient().getLogin()+" "+e.getClient().getFunction();
	            }
	        } else {
	            s="nic";
	        }
	    } finally {
	        query.closeAll();
	    }
		
		
//		Person e1=new Person();
//		e1.setLogin("wojtek");
//		e1.setFunction(Function.KLIENT);
//		
//	
//		
//		Problem p1=new Problem();
//		p1.setClient(e1);
//	
//
//	
//		
//		
//        try {
////            pm.makePersistent(e1);
//            pm.makePersistent(p1);
//        }catch(Exception e){
//        	s=e.toString();
//        } finally {
//            pm.close();
//        }
		
		return s;
	}

}
