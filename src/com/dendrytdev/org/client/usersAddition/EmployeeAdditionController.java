package com.dendrytdev.org.client.usersAddition;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class EmployeeAdditionController implements IEmployeeAdditionController{
	EmployeeServiceAsync service = (EmployeeServiceAsync) GWT.create(EmployeeService.class);
	EmpAddition ea;
	public EmployeeAdditionController(EmpAddition ea){
		this.ea=ea;
	}
	
	@Override
	public void addEmployee() {
		if (ea.tbLogin.getText() != "") {
			if ((ea.ptbPassword.getText().equals(ea.ptbPassword2.getText()) 
					|| ea.ptbPassword.getText().length() < 3 ) && (ea.rbDesigner.getValue() || ea.rbProgrammer.getValue() || ea.rbService.getValue() || ea.rbTest.getValue())) {
				Person p = new Person();
				p.setLogin(ea.tbLogin.getText());
				p.setEmail(ea.tbEmail.getText());
				p.setFirstName(ea.tbName.getText());
				p.setPassword(ea.ptbPassword.getText());
				p.setSurname(ea.tbSurname.getText());
				p.setTelephone(ea.tbTelephone.getText());
				if(ea.rbDesigner.getValue()){
					p.setFunction(com.dendrytdev.org.client.bean.Function.DESIGNER);
				}else if(ea.rbProgrammer.getValue()){
					p.setFunction(com.dendrytdev.org.client.bean.Function.PROGRAMMER);
				}else if(ea.rbService.getValue()){
					p.setFunction(Function.SERVICE);
				}else if(ea.rbTest.getValue()){
					p.setFunction(Function.TESTER);
				}
				
				service.addPerson(p, new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Blad przy dodawaniu");
						Window.alert(caught.getMessage());
					}

					@Override
					public void onSuccess(Boolean result) {
						if (result == true) {
							ea.tbLogin.setText("");
							ea.tbName.setText("");
							ea.tbEmail.setName("");
							ea.tbSurname.setText("");
							ea.tbTelephone.setText("");
							ea.ptbPassword.setText("");
							ea.ptbPassword2.setText("");
							ea.tbEmail.setText("");
							ea.rbDesigner.setValue(false);
							ea.rbService.setValue(false);
							ea.rbProgrammer.setValue(false);
							ea.rbTest.setValue(false);
							Window.alert("Uzytkownik dodany");
						} else {
							ea.tbLogin.setText("");
							Window.alert("Login zajety");
						}

					}
				});
			} else {
				ea.ptbPassword.setText("");
				ea.ptbPassword2.setText("");
				Window.alert("Haslo musi zawierac conajmniej 3 znaki, pola \"haslo\" i \"powtorz\" haslo musza byc rowne. Funkcja musi byc wybrana");
			}
		} else {
			Window.alert("Wpisz login!");
		}
		
	}

}
