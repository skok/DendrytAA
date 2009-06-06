package com.dendrytdev.org.server.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.login.LoginDTO;
import com.dendrytdev.org.client.login.IAuthenticateUser;
import com.dendrytdev.org.server.dao.DatabaseConnector;

public class AuthenticateUserImpl implements IAuthenticateUser {
	public static final String HARDCODED_DESIGNER_ACCOUNT_LOGIN = "d";
	public static final String HARDCODED_PROGRAMMER_ACCOUNT_LOGIN = "p";
	public static final String HARDCODED_SERVICE_ACCOUNT_LOGIN = "s";
	public static final String HARDCODED_TESTER_ACCOUNT_LOGIN = "t";
	public static final String HARDCODED_CLIENT_ACCOUNT_LOGIN = "c";
	
	static final Map<String, Function> _mapHardcodedLoginInFunction;
	static{
		_mapHardcodedLoginInFunction = new HashMap<String, Function>();
		_mapHardcodedLoginInFunction.put(HARDCODED_DESIGNER_ACCOUNT_LOGIN, Function.DESIGNER);	
		_mapHardcodedLoginInFunction.put(HARDCODED_PROGRAMMER_ACCOUNT_LOGIN, Function.PROGRAMMER);	
		_mapHardcodedLoginInFunction.put(HARDCODED_SERVICE_ACCOUNT_LOGIN, Function.SERVICE);	
		_mapHardcodedLoginInFunction.put(HARDCODED_TESTER_ACCOUNT_LOGIN, Function.TESTER);	
		_mapHardcodedLoginInFunction.put(HARDCODED_CLIENT_ACCOUNT_LOGIN, Function.CLIENT);	
	}

	@Override
	public Function authenticate(LoginDTO person) {
		String login = person.getLogin();
		if (login == null) {
			login = "";
		}
		// TODO: hardcoded!!! NOT FOR PRODUCTION SYSTEM!
		Function f = _mapHardcodedLoginInFunction.get(login); //check if this user is not a hardcoded user:)
		if (f == null) { // normal user handling
			return getUserFromDB(person);
		}else{ // hardcoded, predefined user
			return f;
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
