package com.dendrytdev.org.server.dao;

import java.util.Collection;
import java.util.Iterator;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.server.PMF;
import com.dendrytdev.org.server.dao.intf.IProductDAO;

public class ProductDAO implements IProductDAO{

	@SuppressWarnings("unchecked")
	@Override
	public boolean create(Product p) throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean result = false;
		try {
			Query q = pm.newQuery(Product.class);
			q.setFilter("id == " + p.getId());
			Collection<Product> pp = (Collection<Product>) q.execute();
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
	public void delete(Product c) throws DendrytDAOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Product com = null;
		try{
			Query q = pm.newQuery(Product.class);
			q.setFilter("id == " + c.getId());
			Collection<Product> col = (Collection<Product>) q.execute();
			if(col.size() == 1){
				com = (Product) col.toArray()[0];
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
	public Product read(Long id) throws DendrytDAOException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Product com = null;
		try{
			Query q = pm.newQuery(Product.class);
			q.setFilter("id == " + id);
			Collection<Product> col = (Collection<Product>) q.execute();
			if(col.size() > 1){
				throw new DendrytDAOException("For Product with id=" + id + " there are " + col.size() + " instances in DB!");
			}else if(col.size() == 1){
				com = (Product) col.toArray()[0];
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
	public Product[] readAll() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Product.class);
		Collection<Product> col = (Collection<Product>) q.execute();
		Product[] arr = new Product[col.size()];
		Iterator<Product> it = col.iterator();
		for(int i = 0; i < arr.length; i++){
			arr[i] = it.next();
		}
		pm.close();
		return arr;
	}

	@Override
	public boolean update(Product c) {
		// TODO Auto-generated method stub
		return false;
	}
}
