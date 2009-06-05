package com.dendrytdev.org.client.usersOverview;

import java.util.Iterator;
import java.util.List;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.usersAddition.EmployeeService;
import com.dendrytdev.org.client.usersAddition.EmployeeServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class EmployeeOverviewController implements IEmployeeOverviewController {
	EmployeeServiceAsync service = (EmployeeServiceAsync) GWT
			.create(EmployeeService.class);
	List<Person> persons;
	Person employee;
	EmpOverview eo;

	public EmployeeOverviewController(final EmpOverview eo) {
		this.eo = eo;

		reload();

	}

	@Override
	public void saveChanges() {
		if (eo.ptbPassword.getText().equals(eo.ptbPassword2.getText())
				&& eo.ptbPassword.getText().length() > 2) {
			Person p = new Person();
			p.setEmail(eo.tbEmail.getText());
			p.setFirstName(eo.tbName.getText());
			if (eo.rbDesigner.getValue()) {
				p.setFunction(Function.DESIGNER);
			} else if (eo.rbProgrammer.getValue()) {
				p.setFunction(Function.PROGRAMMER);
			} else if (eo.rbService.getValue()) {
				p.setFunction(Function.SERVICE);
			} else if (eo.rbTest.getValue()) {
				p.setFunction(Function.TESTER);
			}
			p.setLogin(eo.tbLogin.getText());
			p.setSurname(eo.tbSurname.getText());
			p.setTelephone(eo.tbTelephone.getText());
			p.setPassword(eo.ptbPassword.getText());
			service.setChanges(p, new AsyncCallback<Object>() {

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Blad przy edycji");

				}

				@Override
				public void onSuccess(Object result) {
					reload();

				}
			});

		} else {
			Window
					.alert("Hasla musza byc rowne i zawierac co najmniej 3 znaki");
			eo.ptbPassword.setText("");
			eo.ptbPassword2.setText("");
		}
	}

	@Override
	public void setEmployee() {
		String login = eo.listBoxEmployees.getItemText(eo.listBoxEmployees
				.getSelectedIndex());
		Iterator<Person> it = persons.iterator();
		employee = null;
		while (it.hasNext() && employee == null) {
			employee = it.next();
			if (employee.getLogin().equals(login)) {
				eo.tbLogin.setText(employee.getLogin());
				eo.tbName.setText(employee.getFirstName());
				eo.tbSurname.setText(employee.getSurname());
				eo.tbTelephone.setText(employee.getTelephone());
				eo.tbEmail.setText(employee.getEmail());
				eo.ptbPassword.setText(employee.getPassword());
				eo.ptbPassword2.setText(employee.getPassword());
				if (employee.getFunction() == Function.SERVICE) {
					eo.rbService.setValue(true);
				} else if (employee.getFunction() == Function.DESIGNER) {
					eo.rbDesigner.setValue(true);
				} else if (employee.getFunction() == Function.PROGRAMMER) {
					eo.rbProgrammer.setValue(true);
				} else if (employee.getFunction() == Function.TESTER) {
					eo.rbTest.setValue(true);
				} else {
					eo.rbService.setValue(false);
					eo.rbDesigner.setValue(false);
					eo.rbProgrammer.setValue(false);
					eo.rbTest.setValue(false);
				}

			} else {
				employee = null;
			}
		}
		if (employee == null) {
			Window.alert("Nie znaleziono: " + login);
		}

	}

	@Override
	public void setAnyEmployee() {
		if (persons == null || persons.size() == 0) {
			eo.tbLogin.setText("");
			eo.tbName.setText("");
			eo.tbSurname.setText("");
			eo.tbTelephone.setText("");
			eo.tbEmail.setText("");
			eo.rbService.setValue(false);
			eo.rbDesigner.setValue(false);
			eo.rbProgrammer.setValue(false);
			eo.rbTest.setValue(false);
			eo.ptbPassword.setText("");
			eo.ptbPassword2.setText("");
		} else {
			
			Iterator<Person> it = persons.iterator();
			while (it.hasNext()) {
				eo.listBoxEmployees.addItem(it.next().getLogin());
			}
			
			employee = persons.get(0);
			eo.listBoxEmployees.setSelectedIndex(0);

			eo.tbLogin.setText(employee.getLogin());
			eo.tbName.setText(employee.getFirstName());
			eo.tbSurname.setText(employee.getSurname());
			eo.tbTelephone.setText(employee.getTelephone());
			eo.tbEmail.setText(employee.getEmail());
			eo.ptbPassword.setText(employee.getPassword());
			eo.ptbPassword2.setText(employee.getPassword());
			if (employee.getFunction() == Function.SERVICE) {
				eo.rbService.setValue(true);
			} else if (employee.getFunction() == Function.DESIGNER) {
				eo.rbDesigner.setValue(true);
			} else if (employee.getFunction() == Function.PROGRAMMER) {
				eo.rbProgrammer.setValue(true);
			} else if (employee.getFunction() == Function.TESTER) {
				eo.rbTest.setValue(true);
			} else {
				eo.rbService.setValue(false);
				eo.rbDesigner.setValue(false);
				eo.rbProgrammer.setValue(false);
				eo.rbTest.setValue(false);
			}

		}

	}

	public void reload() {
		service.getEmployees(new AsyncCallback<List<Person>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Blad odczytu pracownikow");
			}

			@Override
			public void onSuccess(List<Person> result) {
				while (eo.listBoxEmployees.getItemCount() > 0) {
					eo.listBoxEmployees.removeItem(0);
				}
				persons = result;
				setAnyEmployee();

			}
		});

	}

	@Override
	public void deleteEmployee() {
		String login = eo.listBoxEmployees.getItemText(eo.listBoxEmployees
				.getSelectedIndex());
		eo.listBoxEmployees.removeItem(eo.listBoxEmployees.getSelectedIndex());

		Person p = new Person();
		p.setLogin(login);

		for (int i = 0; i < persons.size(); i++) {
			if (persons.get(i).getLogin().equals(login)) {
				p = persons.get(i);
				persons.remove(i);
			}
		}
		service.deletePerson(p, new AsyncCallback<Object>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("blad przy usuwaniu");

			}

			@Override
			public void onSuccess(Object result) {
				setAnyEmployee();

			}
		});

	}

}
