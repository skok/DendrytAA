package com.dendrytdev.org.client.designer.productsAndGroupsAddition;

import java.util.List;

import com.dendrytdev.org.client.bean.Product;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ProductsService")
public interface ProductsService extends RemoteService{
	public Boolean addProduct(Product p);
	public void removeProduct(Product p);
	public List<Product> getAllProducts();
}
