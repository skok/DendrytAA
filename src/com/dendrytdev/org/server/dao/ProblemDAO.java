package com.dendrytdev.org.server.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.server.dao.intf.IProblemDAO;

public class ProblemDAO implements IProblemDAO{
	Logger _tracer = Logger.getLogger(this.getClass().getName());
	public ProblemDAO(){
	}
//		pm = PMF.get().getPersistenceManagerProxy()		 
//		TODO: rozkminic to - good shit
		
	
//	@SuppressWarnings("unchecked")
	@Override
	public Problem[] read() {
//		PersistenceManager pm = PMF.get().getPersistenceManager();
//		Query q = pm.newQuery(Problem.class);
//		Collection<Problem> col = (Collection<Problem>) q.execute();
//		pm.close();
//		return null;
		// TODO: !!!
		throw new RuntimeException("not implementet yet!");
	}


	@Override
	public boolean create(Problem p) throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean result = false;
		try {
			pm.makePersistent(p);
			result = true;
		} catch (Throwable e) {
			throw new DendrytDAOException(e);
		} finally {
			pm.close();
		}
		return result;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Problem[] readAll() throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Problem.class);
		Collection<Problem> col = (Collection<Problem>) q.execute();
		Problem[] arr = new Problem[col.size()];
		Iterator<Problem> it = col.iterator();
		for(int i = 0; i < arr.length; i++){
			arr[i] = it.next();
		}
		pm.close();
		return cureDendrytProblemArray(arr);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Problem read(Long id) throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Problem com = null;
		try{
			Query q = pm.newQuery(Problem.class);
			q.setFilter("id == " + id);
			Collection<Problem> col = (Collection<Problem>) q.execute();
			if(col.size() > 1){
				throw new DendrytDAOException("For Problem with id=" + id + " there are " + col.size() + " instances in DB!");
			}else if(col.size() == 1){
				com = (Problem) col.toArray()[0];
			}
		}catch(DendrytDAOException de){
			throw de;			
		}catch(Throwable t){
			throw new DendrytDAOException(t);
		}finally{
			pm.close();			
		}
		return cureOneDendrytProblemKurwa(com);
	}


	@SuppressWarnings("unchecked")
	@Override
	public void delete(Problem c) throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Problem com = null;
		try{
			Query q = pm.newQuery(Problem.class);
			q.setFilter("id == " + c.getId());
			Collection<Problem> col = (Collection<Problem>) q.execute();
			if(col.size() == 1){
				com = (Problem) col.toArray()[0];
			}
			pm.deletePersistent(com);
		}catch(Throwable t){
			throw new DendrytDAOException(t);
		}finally{
			pm.close();			
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void update(Problem p) throws DendrytDAOException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Problem com = null;
		try{
			Query q = pm.newQuery(Problem.class);
			q.setFilter("id == " + p.getId());
			Collection<Problem> col = (Collection<Problem>) q.execute();
			if(col.size() > 1){
				throw new DendrytDAOException("For Problem with id=" + p.getId() + " there are " + col.size() + " instances in DB!");
			}else if(col.size() == 1){
				com = (Problem) col.toArray()[0];
			}
			com.fill(p);			
		}catch(DendrytDAOException de){
			throw de;			
		}catch(Throwable t){
			throw new DendrytDAOException(t);
		}finally{
			pm.close();			
		}
	}
	
	
	
	private Problem[] cureDendrytProblemArray(Problem[] in){
		if(in == null){
			return null;
		}
		Problem[] out = new Problem[in.length];
		Problem p;
		List<Long> list;
		List<Long> listNew;
		for(int i = 0; i < out.length; i++){
			out[i] = cureOneDendrytProblemKurwa(in[i]);
		}
		return out; //kdps		
	}
	
	private Problem cureOneDendrytProblemKurwa(Problem p){
		if(p == null){
			return null;
		}
		List<Long> list = p.getComments();
		if(list != null){
			List<Long> listNew = new ArrayList<Long>();
			for(Long l : list){
				listNew.add(l);
			}
			p.setComments(listNew);				
		}
		return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Problem[] read(String currentWorkerLogin) throws DendrytDAOException {
		_tracer.info("currentWorkerLogin=" + currentWorkerLogin);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Collection<Problem> col = null;
		Problem[] arr = null;
		try{
			Query q = pm.newQuery(Problem.class);
			q.setFilter("currentWorker == \"" + currentWorkerLogin +"\"");
			col = (Collection<Problem>) q.execute();
			
			arr = new Problem[col.size()];
			Iterator<Problem> it = col.iterator();
			for(int i = 0; i < arr.length; i++){
				arr[i] = it.next();
			}

		}catch(Throwable t){
			throw new DendrytDAOException(t);
		}finally{
			pm.close();			
		}
		_tracer.info("arr.size=" + arr.length);
		return cureDendrytProblemArray(arr);
	}
	

}
