package com.dendrytdev.org.server.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.login.LoginDTO;
import com.dendrytdev.org.client.login.IAuthenticateUser;
import com.dendrytdev.org.server.dao.DatabaseConnector;

public class AuthenticateUserImpl implements IAuthenticateUser {
	Logger _tracer = Logger.getLogger(this.getClass().getName());
	public static final String HARDCODED_DESIGNER_ACCOUNT_LOGIN = "des";
	public static final String HARDCODED_PROGRAMMER_ACCOUNT_LOGIN = "pro";
	public static final String HARDCODED_SERVICE_ACCOUNT_LOGIN = "ser";
	public static final String HARDCODED_TESTER_ACCOUNT_LOGIN = "tes";
	public static final String HARDCODED_CLIENT_ACCOUNT_LOGIN = "cli";
	
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
		_tracer.info(person.getLogin() + "/" + person.getPassword());
		String login = person.getLogin();
		if (login == null) {
			login = "";
		}
		// TODO: hardcoded!!! NOT FOR PRODUCTION SYSTEM!
//		Function f = _mapHardcodedLoginInFunction.get(login); //check if this user is not a hardcoded user:)
//		if (f == null) { // normal user handling
			return getUserFromDB(person);
//		}else{ // hardcoded, predefined user
//			return f;
//		}
	}
	
	
	private boolean checkIfAlreadyFilled(List<Person> l){
		boolean ok = false;
		for(String login : _mapHardcodedLoginInFunction.keySet()){
			ok = false;
			for(Person p: l){
				if(p.getLogin().equals(login)){
					ok = true;
				}
			}
			if(!ok){
				_tracer.info(login + " not in DB!");
				return false;
			}else{
				_tracer.info(login + " already in DB");
			}
		}
		return true;
	}
	
	
	final static String[] ARRRRRR_FIRST = {
		"Maciek",
		"Waldek",
		"Piotrek",
		"Olga",
		"Pawel"
	}; 
	
	final static String[] ARRRRRR_SND = {
		"Lubicz",
		"Chrzastawa",
		"Plaza",
		"Awerjanovv",
		"Rakowiecki"
	}; 
	
	private void fillForTestingPurposesONLY_DELETE_IT_ON_PRODUCTION_SYSTEM(List<Person> l){
		int i = 0;
		if(!checkIfAlreadyFilled(l)){
			for(String login : _mapHardcodedLoginInFunction.keySet()){
				Person p = new Person();
				p.setLogin(login);
				p.setPassword(login + "123");
				p.setFunction(_mapHardcodedLoginInFunction.get(login));
				p.setFirstName(ARRRRRR_FIRST[i]);
				p.setSurname(ARRRRRR_SND[i++]);
				DatabaseConnector.addPerson(p);
			}
		}	
	}
	
	Function getUserFromDB(LoginDTO person){
		if(person == null || person.getLogin() == null || person.getPassword() == null){
			throw new RuntimeException("not implemented handling yet");
		}
		// TODO: refactor later, get it by direct GQL-querry
		List<Person> list = DatabaseConnector.getAllPerson();
		_tracer.info("already in DB:" + list);
		fillForTestingPurposesONLY_DELETE_IT_ON_PRODUCTION_SYSTEM(list);

		
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
