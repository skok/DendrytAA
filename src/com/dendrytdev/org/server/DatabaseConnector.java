package com.dendrytdev.org.server;

import java.util.Collection;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;

public class DatabaseConnector {
	
	public static Collection<Person> getAllPerson(){
		PersistenceManager pm=PMF.get().getPersistenceManager();
		Query q=pm.newQuery(Person.class);		
		return (Collection<Person>) q.execute();
	}
	
	public static Collection<Person> getAllDesigners(){
		PersistenceManager pm=PMF.get().getPersistenceManager();
		Query q=pm.newQuery(Person.class);	
		String arg="function ==" + Function.DESIGNER;
		q.setFilter(arg);
		pm.close();
		return (Collection<Person>) q.execute();
	}
	
	public static Boolean addPerson(Person person){
		Boolean result;
		PersistenceManager pm=PMF.get().getPersistenceManager();
		Query q=pm.newQuery(Person.class);	
		q.declareParameters("String pLogin");
		q.setFilter("login==pLogin");
		Collection<Person> p=(Collection<Person>) q.execute(person.getLogin());
		if(p.size()>0){
			result=false;
		}else{
			result =true;
			pm.makePersistent(person);
		}
		pm.close();
		return result;	
	}
	
	
}
