package com.dendrytdev.org.server;

import java.util.List;

import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.designer.productsAndGroupsAddition.ProductsService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ProductsServiceImpl extends RemoteServiceServlet implements ProductsService{
	private static final long serialVersionUID = 1L;

	public ProductsServiceImpl(){
		super();
	}
	
	@Override
	public Boolean addProduct(Product p) {
		return DatabaseConnector.addProduct(p);
	}

	@Override
	public void removeProduct(Product p) {
		DatabaseConnector.removeProduct(p);
		
	}

	@Override
	public List<Product> getAllProducts() {
		return DatabaseConnector.getAllProducts();
	}

}
