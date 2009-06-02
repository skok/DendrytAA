package com.dendrytdev.org.server.login;

import java.util.List;

import javax.servlet.http.HttpSession;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.login.LoginDTO;
import com.dendrytdev.org.client.login.IAuthenticateUser;
import com.dendrytdev.org.server.DatabaseConnector;

public class AuthenticateUserImpl implements IAuthenticateUser {
	public static final String HARDCODED_CLIENT_ACCOUNT_LOGIN = "client";
	public static final String HARDCODED_DESIGNER_ACCOUNT_LOGIN = "designer";

	private HttpSession httpSession;


	@Override
	public Function authenticate(LoginDTO person) {

		String login = person.getLogin();
		if (login == null) {
			login = "";
		}

		// TODO: hardcoded!!!
		if (HARDCODED_CLIENT_ACCOUNT_LOGIN.equals(login)) {
			return Function.CLIENT;
		} else if (HARDCODED_DESIGNER_ACCOUNT_LOGIN.equals(login)) {
			return Function.DESIGNER;
		} else {
			return getUserFromDB(person);
		}
	}
	
	Function getUserFromDB(LoginDTO person){
		if(person == null || person.getLogin() == null || person.getPassword() == null){
			throw new RuntimeException("not implemented handling yet");
		}
		// TODO: refactor later, get it by direct GQL-querry
		List<Person> list = DatabaseConnector.getAllPerson();
		
		String login = person.getLogin();
		String pass = person.getPassword();
		for(Person p : list){
			if(login.equals(p.getLogin())){
				if(pass.equals(p.getPassword())){
					return p.getFunction();
				}else{
					return Function.NOT_A_USER;
				}
			}
		}
		return Function.NOT_A_USER;		
	}
	

	@Override
	public void logout() {
		throw new RuntimeException("not implemented yet!");
	}

}
