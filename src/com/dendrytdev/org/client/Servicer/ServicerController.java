package com.dendrytdev.org.client.Servicer;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ServicerController {
	Services s;
	ServicerServiceAsync service = (ServicerServiceAsync) GWT
			.create(ServicerService.class);
	List<Product> products;
	List<Person> clients;

	public ServicerController(final Services s) {
		this.s = s;
		
		s._productListbox.clear();
		s.lbClients.clear();
		
		
	
		
		service.getAllClients(new AsyncCallback<List<Person>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad odczytu klientow");

			}

			@Override
			public void onSuccess(List<Person> result) {
				clients = result;
				
				
				if (clients != null && clients.size() > 0) {
					Iterator<Person> itp = clients.iterator();
					Person p;
					while (itp.hasNext()) {
						p = itp.next();
						s.lbClients.addItem(p.getCompanyName() + ", POLICY: "
								+ p.getPolicy(), p.getLogin());
					}
				}

			}
		});
		service.getAllProducts(new AsyncCallback<List<Product>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad odczytu produktow");

			}

			@Override
			public void onSuccess(List<Product> result) {
				products = result;
				
				if (products != null && products.size() > 0) {
					Iterator<Product> itproduct = products.iterator();
					Product prod;
					while (itproduct.hasNext()) {
						prod = itproduct.next();
						s._productListbox.addItem(prod.getName() + " "
								+ prod.getVersion(), prod.getId().toString());
					}
				}

			}
		});
		
		
	

	}

	public void addProblem() {
	
		Problem p = new Problem();
		p.setClient(s.lbClients.getValue(s.lbClients.getSelectedIndex()));
		p.setDescription(s._descriptionTextArea.getText());
		p.setProduct(s._productListbox.getValue(s._productListbox
				.getSelectedIndex()));
		p.setClientImportance(s._importanceTextBox
				.getItemText(s._importanceTextBox.getSelectedIndex()));

		service.addProblem(p, new AsyncCallback<Object>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad przy dodawaniu problemu");

			}

			@Override
			public void onSuccess(Object result) {
				s._descriptionTextArea.setText("");
				Window.alert("Dodano problem");
			}
		});

	}

}
