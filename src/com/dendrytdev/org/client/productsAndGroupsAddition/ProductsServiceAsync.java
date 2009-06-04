package com.dendrytdev.org.client.productsAndGroupsAddition;

import java.util.List;

import com.dendrytdev.org.client.bean.Product;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProductsServiceAsync {
	public void addProduct(Product p,AsyncCallback<Boolean> asyncCallback);
	public void removeProduct(Product p,AsyncCallback<Object> asyncCallback);
	public void getAllProducts(AsyncCallback<List<Product>> asyncCallback);

}
