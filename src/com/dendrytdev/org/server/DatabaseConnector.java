package com.dendrytdev.org.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;

public class DatabaseConnector {

	public static synchronized List<Person> getAllPerson() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Person> result = new ArrayList<Person>();

		try {
			Query q = pm.newQuery(Person.class);
			List<Person> qresult = (List<Person>) q.execute();
			if (qresult != null) {
				Iterator<Person> it = qresult.iterator();
				while (it.hasNext()) {
					result.add(it.next());
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();

		} finally {

		}
		return result;
	}

	public static synchronized List<Person> getAllEmployees() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Person> result = new ArrayList<Person>();

		try {
			Query q = pm.newQuery(Person.class);

			List<Person> qresult = (List<Person>) q.execute();
			if (qresult != null) {
				Iterator<Person> it = qresult.iterator();
				Person p;
				while (it.hasNext()) {
					p = it.next();
					if (p.getFunction() != Function.CLIENT) {
						result.add(p);
					}
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			pm.close();
		}
		return result;
	}

	public static synchronized List<Person> getAllClients() {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Person> result = new ArrayList<Person>();
		try {
			Query q = pm.newQuery(Person.class);

			List<Person> qresult = (List<Person>) q.execute();
			if (qresult != null) {
				Iterator<Person> it = qresult.iterator();

				Person p;
				while (it.hasNext()) {
					p = it.next();
					if (p.getFunction() == Function.CLIENT) {
						result.add(p);
					}
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			pm.close();
		}

		return result;
	}

	public static synchronized Boolean addPerson(Person person) {
		Boolean result = false;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query q = pm.newQuery(Person.class);
			q.declareParameters("String pLogin");
			q.setFilter("login==pLogin");
			Collection<Person> p = (Collection<Person>) q.execute(person
					.getLogin());
			if (p != null && p.size() > 0) {
				result = false;
			} else {
				result = true;
				pm.makePersistent(person);
			}
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			pm.close();
		}
		return result;
	}

	public static synchronized void remove(Person p) {
		String l = p.getLogin();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query q = pm.newQuery(Person.class);
			q.declareParameters("String l");
			q.setFilter("login==l");
			List<Person> result = (List<Person>) q.execute(l);

			pm.deletePersistentAll(result);
		} finally {
			pm.close();
		}
	}

	public static synchronized void setChanges(Person p) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Person person = new Person();
			person.setLogin(p.getLogin());
			person.setEmail(p.getEmail());
			person.setFirstName(p.getFirstName());
			person.setFunction(p.getFunction());
			person.setSurname(p.getSurname());
			person.setTelephone(p.getTelephone());
			person.setCity(p.getCity());
			person.setPassword(p.getPassword());

			pm.makePersistent(person);
		} finally {
			pm.close();
		}
	}

}
