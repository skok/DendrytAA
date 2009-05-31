package com.dendrytdev.org.server.dao;

import java.util.Collection;
import java.util.Iterator;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;


import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.server.PMF;
import com.dendrytdev.org.server.dao.intf.IProblemDAO;

public class ProblemDAO implements IProblemDAO{
	
	public ProblemDAO(){
	}
//		pm = PMF.get().getPersistenceManagerProxy()		 
//		TODO: rozkminic to - good shit
		
	
	@SuppressWarnings("unchecked")
	@Override
	public Problem[] read() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Problem.class);
		Collection<Problem> col = (Collection<Problem>) q.execute();
		pm.close();
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean create(Problem p) throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean result = false;
		try {
			Query q = pm.newQuery(Problem.class);
			pm.makePersistent(p);
			result = true;
		} catch (Throwable e) {
			throw new DendrytDAOException(e);
		} finally {
			pm.close();
		}
		return result;
	}


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
		return arr;
	}


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
		return com;
	}


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
}
