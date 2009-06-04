package com.dendrytdev.org.client.productsAndGroupsOverview;

import java.util.Iterator;
import java.util.List;

import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.productsAndGroupsAddition.ProductsService;
import com.dendrytdev.org.client.productsAndGroupsAddition.ProductsServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ProductsOverviewController {
	ProductsOverview po;
	ProductsServiceAsync service = (ProductsServiceAsync) GWT
			.create(ProductsService.class);
	List<Product> products;

	public ProductsOverviewController(ProductsOverview po) {
		this.po = po;
		refresh();

	}

	public void refresh() {

		service.getAllProducts(new AsyncCallback<List<Product>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad przy odczycie produktow");

			}

			@Override
			public void onSuccess(List<Product> result) {

				po.lbProducts.clear();
				products = result;

				Iterator<Product> it = products.iterator();
				Product p;
				while (it.hasNext()) {
					p = it.next();
					po.lbProducts.addItem(p.getName(), p.getVersion());
				}
				if (products != null && products.size() > 0) {
					po.lbProducts.setSelectedIndex(0);
					po.tbProduct.setText(products.get(0).getName());
					po.tbVersion.setText(products.get(0).getVersion());
					po.tbgroup.setText(products.get(0).getGroup());
				} else {
					po.tbProduct.setText("");
					po.tbVersion.setText("");
					po.tbgroup.setText("");
				}
			}
		});

	}

	public void setProduct() {
		Product p = new Product();
		p.setVersion(po.lbProducts.getValue(po.lbProducts.getSelectedIndex()));
		p.setName(po.lbProducts.getItemText(po.lbProducts.getSelectedIndex()));

		Product p2;
		Iterator<Product> it = products.iterator();
		Boolean koniec = false;
		while (it.hasNext() && !koniec) {
			p2 = it.next();
			if (p2.getName().equals(p.getName())
					&& p2.getVersion().equals(p2.getVersion())) {
				koniec = true;
				po.tbgroup.setText(p2.getGroup());
				po.tbVersion.setText(p2.getVersion());
				po.tbProduct.setText(p2.getName());
			}
		}

	}

	public void remove() {
		Product p = new Product();
		p.setVersion(po.tbVersion.getText());
		p.setName(po.tbProduct.getText());

		service.removeProduct(p, new AsyncCallback<Object>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad przy usuwaniu");

			}

			@Override
			public void onSuccess(Object result) {
				refresh();

			}
		});

	}
}
