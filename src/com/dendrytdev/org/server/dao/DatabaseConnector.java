package com.dendrytdev.org.server.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Group;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;

/*
 *                                            _____________                
                                  ..---:::::::-----------. ::::;;.         
                               .'""""""                  ;;   \  ":.       
                            .''                          ;     \   "\__.   
                          .'                            ;;      ;   \\";   
                        .'                              ;   _____;   \\/   
                      .'                               :; ;"     \ ___:'.  
                    .'--...........................    : =   ____:"    \ \ 
               ..-""                               """'  o"""     ;     ; :
          .--""  .----- ..----...    _.-    --.  ..-"     ;       ;     ; ;
       .""_-     "--""-----'""    _-"        .-""         ;        ;    .-.
    .'  .'                      ."         ."              ;       ;   /. |
   /-./'                      ."          /           _..  ;       ;   ;;;|
  :  ;-.______               /       _________==.    /_  \ ;       ;   ;;;;
  ;  / |      """"""""""".---."""""""          :    /" ". |;       ; _; ;;;
 /"-/  |                /   /                  /   /     ;|;      ;-" | ;';
:-  :   """----______  /   /              ____.   .  ."'. ;;   .-"..T"   . 
'. "  ___            "":   '""""""""""""""    .   ; ;    ;; ;." ."   '--"  
 ",   __ """  ""---... :- - - - - - - - - ' '  ; ;  ;    ;;"  ."           
  /. ;  """---___                             ;  ; ;     ;|.""             
 :  ":           """----.    .-------.       ;   ; ;     ;:                
  \  '--__               \   \        \     /    | ;     ;;                
   '-..   """"---___      :   .______..\ __/..-""|  ;   ; ;                
       ""--..       """--"        m l s         .   ". . ;                 
             ""------...                  ..--""      " :                  
                        """"""""""""""""""    \        /                   
                                               "------"     
 */
public class DatabaseConnector {

	static Logger _tracer = Logger.getLogger(DatabaseConnector.class.getName());
	
	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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
					if (p.getFunction()!=null && p.getFunction() != Function.CLIENT) {
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

	@SuppressWarnings("unchecked")
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


	@SuppressWarnings("unchecked")
	public static synchronized Boolean addPerson(Person person) {
		_tracer.info(person.getLogin() + "/" + person.getPassword() + "/" + person.getFunction());
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
			_tracer.warning(t.getMessage());
		} finally {
			pm.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
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
			person.setAddress(p.getAddress());
			
			pm.makePersistent(person);
		} finally {
			pm.close();
		}
	}
	@SuppressWarnings("unchecked")
	public static synchronized Boolean addGroup(Group g){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Boolean result=false;
		try{
			Query q=pm.newQuery(Group.class);
			q.setFilter("name==n");
			q.declareParameters("String n");
			List<Group> groups=(List<Group>) q.execute(g.getName());
			if(groups !=null && groups.size()>0){
				result=false;
			}else{
				result=true;
				pm.makePersistent(g);
			}
		}catch(Throwable t){
			t.printStackTrace();
		}
		finally{
			pm.close();
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	public static synchronized Boolean addProduct(Product p){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Boolean result=false;
		try{
			Query q=pm.newQuery(Product.class);
			q.setFilter("name==n && version==v");
			q.declareParameters("String n, String v");
			List<Product> products=(List<Product>) q.execute(p.getName(),p.getVersion());
			if(products!=null && products.size()>0){
				result=false;
			}else{
				result=true;
				pm.makePersistent(p);
			}
			
			
		}catch(Throwable t){
			t.printStackTrace();
		}
		finally{
			pm.close();
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	public static synchronized void removeGroup(Group g){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			Query q=pm.newQuery(Group.class);
			q.setFilter("name==n");
			q.declareParameters("String n");
			List<Group> groups=(List<Group>) q.execute(g.getName());
			pm.deletePersistentAll(groups);

		}catch(Throwable t){
			t.printStackTrace();
		}
		finally{
			pm.close();
		}
	}
	@SuppressWarnings("unchecked")
	public static synchronized void removeProduct(Product p){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			Query q=pm.newQuery(Product.class);
			q.setFilter("name==n && version==v");
			q.declareParameters("String n, String v");
			List<Product> products=(List<Product>) q.execute(p.getName(),p.getVersion());
			if(products!=null && products.size()>0){
				pm.deletePersistentAll(products);
			}
		}catch(Throwable t){
			t.printStackTrace();
		}
		finally{
			pm.close();
		}
	}
	@SuppressWarnings("unchecked")
	public static synchronized List<Group> getAllGroups(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Group> result=new ArrayList<Group>();
		try{
			Query q=pm.newQuery(Group.class);
			List<Group> groups=(List<Group>) q.execute();
			Iterator<Group> it=groups.iterator();
			while(it.hasNext()){
				result.add(it.next());
			}
			
		}catch(Throwable t){
			t.printStackTrace();
		}
		finally{
			pm.close();
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	public static synchronized List<Product> getAllProducts(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Product> result=new ArrayList<Product>();
		try{
			Query q=pm.newQuery(Product.class);
			List<Product> products=(List<Product>) q.execute();
			Iterator<Product> it=products.iterator();
			while(it.hasNext()){
				result.add(it.next());
			}
		}catch(Throwable t){
			t.printStackTrace();
		}
		finally{
			pm.close();
		}
		return result;
	}

	public static void addProblem(Problem problem) {
		Calendar c=Calendar.getInstance();
		problem.setProblemDate(c.getTime());
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			
			pm.makePersistent(problem);
		}catch(Throwable t){
			t.printStackTrace();
		}finally{
			pm.close();
		}
	}
	@SuppressWarnings("unchecked")
	public static List<Problem> getAllProblems(){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Problem> result=new ArrayList<Problem>();
		try{
			Query q=pm.newQuery(Problem.class);
			List<Problem> pr=(List<Problem>) q.execute();
			Iterator<Problem> it=pr.iterator();
			while(it.hasNext()){
				result.add(it.next());
			}
			
			
		}catch(Throwable t){
			t.printStackTrace();
		}finally{
			pm.close();
		}
		return result;
	}
	
	
	
	 
	
	@SuppressWarnings("unchecked")
	public static Person readPerson(String login) throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Person com = null;
		try{
			Query q = pm.newQuery(Person.class);
			q.setFilter("login == " + login);
			Collection<Person> col = (Collection<Person>) q.execute();
			if(col.size() > 1){
				throw new DendrytDAOException("For Person with login=" + login + " there are " + col.size() + " instances in DB!");
			}else if(col.size() == 1){
				com = (Person) col.toArray()[0];
			}
		}catch(DendrytDAOException de){
			throw de;			
		}catch(Throwable t){
			throw new DendrytDAOException(t);
		}finally{
			pm.close();			
		}
		return com;
	}
}


























