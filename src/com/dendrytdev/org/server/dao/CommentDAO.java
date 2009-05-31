package com.dendrytdev.org.server.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.server.PMF;
import com.dendrytdev.org.server.dao.intf.ICommentDAO;

public class CommentDAO implements ICommentDAO{
	
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean create(Comment p) throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean result = false;
		try {
			Query q = pm.newQuery(Comment.class);
			q.setFilter("id == " + p.getId());
			Collection<Comment> pp = (Collection<Comment>) q.execute();
			if (pp.size() == 0) {
				result = true;
				pm.makePersistent(p);
			} //else return false(default value)
		} catch (Throwable e) {
			throw new DendrytDAOException(e);
		} finally {
			pm.close();
		}
		return result;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Comment c) throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Comment com = null;
		try{
			Query q = pm.newQuery(Comment.class);
			q.setFilter("id == " + c.getId());
			Collection<Comment> col = (Collection<Comment>) q.execute();
			if(col.size() == 1){
				com = (Comment) col.toArray()[0];
			}
			pm.deletePersistent(com);
		}catch(Throwable t){
			throw new DendrytDAOException(t);
		}finally{
			pm.close();			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Comment read(Long id) throws DendrytDAOException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Comment com = null;
		try{
			Query q = pm.newQuery(Comment.class);
			q.setFilter("id == " + id);
			Collection<Comment> col = (Collection<Comment>) q.execute();
			if(col.size() > 1){
				throw new DendrytDAOException("For Comment with id=" + id + " there are " + col.size() + " instances in DB!");
			}else if(col.size() == 1){
				com = (Comment) col.toArray()[0];
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

	/* 
	 * TODO : refactor the shit later !!! (throw dendrytEx)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Comment[] readAll() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Comment.class);
		Collection<Comment> col = (Collection<Comment>) q.execute();
		Comment[] arr = new Comment[col.size()];
		Iterator<Comment> it = col.iterator();
		for(int i = 0; i < arr.length; i++){
			arr[i] = it.next();
		}
		pm.close();
		return arr;
	}

	@Override
	public boolean update(Comment c) {
		// TODO Auto-generated method stub
		return false;
	}


}
