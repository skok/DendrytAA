package com.dendrytdev.org.client.usersAddition;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ClientAdditionController implements IClientAdditionController {
	ClientAdditionOverviewServiceAsync service=(ClientAdditionOverviewServiceAsync)GWT.create(ClientAdditionOverviewService.class);
	ClientsAddition ca;
	
	public ClientAdditionController(ClientsAddition ca) {
		this.ca=ca;
	}
	
	@Override
	public void addClient() {
		if(ca.tbLogin.getText()!="" && ca.ptbHaslo.getText().equals(ca.ptbPowtHaslo.getText()) && ca.ptbHaslo.getText().length()>2){
			Person p=new Person();
			p.setAddress(ca.tbAddress.getText());
			p.setCity(ca.tbCity.getText());
			p.setEmail(ca.tbCity.getText());
			p.setCompanyName(ca.tbNazwa.getText());
			p.setFunction(Function.CLIENT);
			p.setLogin(ca.tbLogin.getText());
			p.setPassword(ca.ptbHaslo.getText());
			p.setPolicy(ca.cbPolisa.getValue());
			p.setTelephone(ca.tbTelefon.getText());
			
			service.addClient(p, new AsyncCallback<Boolean>(){

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Blad przy dodawaniu klienta");
					
				}

				@Override
				public void onSuccess(Boolean result) {
					ca.tbAddress.setText("");
					ca.tbCity.setText("");
					ca.tbEmail.setText("");
					ca.tbLogin.setText("");
					ca.tbNazwa.setText("");
					ca.tbTelefon.setText("");
					ca.ptbHaslo.setText("");
					ca.ptbPowtHaslo.setText("");
					ca.cbPolisa.setValue(false);
					Window.alert("Klienta dodano");
					
				}});
			
		}else{
			Window.alert("Pola login, haslo, powtorz haslo musza byc uzupelnione. Haslo musi miec co najmniej 3 znaki");
			ca.tbLogin.setText("");
			ca.ptbHaslo.setText("");
			ca.ptbPowtHaslo.setText("");
			
		}
		

		
	}

}
