package com.dendrytdev.org.server.dao.intf;

import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.server.dao.DendrytDAOException;

public interface IProductDAO {

	public boolean create(Product p) throws DendrytDAOException;
	public void delete(Product c) throws DendrytDAOException;
	public Product read(Long id) throws DendrytDAOException;
	public Product[] readAll();
	public boolean update(Product c);
}
