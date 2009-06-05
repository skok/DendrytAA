package com.dendrytdev.org.client.usersOverview;

import java.util.Iterator;
import java.util.List;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.usersAddition.ClientAdditionOverviewService;
import com.dendrytdev.org.client.usersAddition.ClientAdditionOverviewServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ClientsOverviewController implements IClientOverviewController {
	ClientAdditionOverviewServiceAsync service = (ClientAdditionOverviewServiceAsync) GWT
			.create(ClientAdditionOverviewService.class);

	ClientsOverview co;
	List<Person> clients;
	
	public ClientsOverviewController(ClientsOverview co) {
		this.co = co;
		reload();
	}

	@Override
	public void deleteClient() {
		Person p = new Person();
		p.setLogin(co.tbLogin.getText());
		service.deletePerson(p, new AsyncCallback<Object>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad przy usuwaniu");

			}

			@Override
			public void onSuccess(Object result) {
				reload();

			}
		});

	}

	@Override
	public void reload() {
		service.getClients(new AsyncCallback<List<Person>>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad odczytu klientow");
				
			}

			@Override
			public void onSuccess(List<Person> result) {
				while(co.lbClients.getItemCount()>0){
					co.lbClients.removeItem(0);
				}
			
				clients=result;
			
				setAnyClient();
				
			}});
	

	}

	@Override
	public void saveChanges() {
		if (co.ptbHaslo.getText().equals(co.ptbPowtHaslo.getText())
				&& co.ptbHaslo.getText().length() > 2) {
			Person p = new Person();
			p.setAddress(co.tbAddress.getText());
			p.setCity(co.tbCity.getText());
			p.setEmail(co.tbEmail.getText());
			p.setCompanyName(co.tbNazwa.getName());
			p.setFunction(Function.CLIENT);
			p.setLogin(co.tbLogin.getText());
			p.setPassword(co.ptbHaslo.getText());
			p.setPolicy(co.cbPolisa.getValue());
			p.setTelephone(co.tbTelefon.getText());
		} else {
			Window.alert("Hasla musza byc rowne i zawierac co najmniej 3 znaki");
			co.ptbHaslo.setText("");
			co.ptbPowtHaslo.setText("");
		}
	}

	@Override
	public void setAnyClient() {
		if(clients!=null && clients.size()>0){
			Iterator<Person> it=clients.iterator();
			
			while(it.hasNext()){
				co.lbClients.addItem(it.next().getLogin());
			}
			Person p=clients.get(0);
			co.lbClients.setSelectedIndex(0);
			
			co.tbAddress.setText(p.getAddress());
			co.tbCity.setText(p.getCity());
			co.tbEmail.setText(p.getEmail());
			co.tbLogin.setText(p.getLogin());
			co.tbNazwa.setText(p.getCompanyName());
			co.tbTelefon.setText(p.getTelephone());
			co.cbPolisa.setValue(p.getPolicy());
			co.ptbHaslo.setText(p.getPassword());
			co.ptbPowtHaslo.setText(p.getPassword());
		}else{
			co.tbAddress.setText("");
			co.tbCity.setText("");
			co.tbEmail.setText("");
			co.tbLogin.setText("");
			co.tbNazwa.setText("");
			co.tbTelefon.setText("");
			co.ptbHaslo.setText("");
			co.ptbPowtHaslo.setText("");
			co.cbPolisa.setValue(false);
		}

	}

	@Override
	public void setClient() {
		if(clients.size()>0){
			Iterator<Person> it=clients.iterator();
			Person p=new Person();
			Boolean koniec=false;
			while(it.hasNext() && !koniec){
				p=it.next();
				if(p.getLogin().equals(co.lbClients.getItemText(co.lbClients.getSelectedIndex()))){
					koniec=true;
				}
			}
			
			co.tbAddress.setText(p.getAddress());
			co.tbCity.setText(p.getCity());
			co.tbEmail.setText(p.getEmail());
			co.tbLogin.setText(p.getLogin());
			co.tbNazwa.setText(p.getCompanyName());
			co.tbTelefon.setText(p.getTelephone());
			co.cbPolisa.setValue(p.getPolicy());
		}else{
			co.tbAddress.setText("");
			co.tbCity.setText("");
			co.tbEmail.setText("");
			co.tbLogin.setText("");
			co.tbNazwa.setText("");
			co.tbTelefon.setText("");
			co.cbPolisa.setValue(false);
		}

	}

}
