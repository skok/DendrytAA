package com.dendrytdev.org.server;

import javax.jdo.PersistenceManager;

import com.dendrytdev.org.client.bean.*;

public class AdderSampleEntities {
	public static String addSampleEntities() {
		String result="ok";
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Person service1=new Person();
		
		Person designer1=new Person();
		designer1.setLogin("lma");
		
		Person programmer1=new Person();
		Person client1=new Person();
		
		Product project1=new Product();
		project1.setName("dendryt");
		project1.setVersion("1.0");
		
		Group group1=new Group();
		group1.setName("szpitale");
		
		Problem problem1=new Problem();
		problem1.setDescription("nic nie dziala!");
		
		
		try {
			pm.makePersistent(service1);
			pm.makePersistent(designer1);
			pm.makePersistent(programmer1);
			pm.makePersistent(project1);
			pm.makePersistent(group1);
			pm.makePersistent(problem1);
		} catch (Exception e) {
			result=e.toString();
		} finally {
			pm.close();
		}
		return result;
	}
}
