package com.dendrytdev.org.server.login;


import javax.servlet.http.HttpSession;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import com.dendrytdev.org.client.login.LoginDTO;
import com.dendrytdev.org.client.login.IAuthenticateUser;
import com.dendrytdev.org.client.tools.IType;


public class AuthenticateUserImpl implements IAuthenticateUser{
	
	private HttpSession httpSession;
	
	public AuthenticateUserImpl(){	
	}


	private static final String AUTHENTICATE = "AuthenticateUserImpl.authenticate()";
	/**
	 * return:
	 * -1 - niepoprawny login / haslo
	 * 0 - serwisant
	 * 1 - projektant
	 * 2 - programista
	 * 3 - tester
	 * 4 - klient
	 */
	@Override
	public int authenticate(LoginDTO person) {
	
		String login = person.getLogin();
		if(login == null){
			login = "";
		}
		
		
		// TODO: hardcoded!!!
		if (login.equals("client")){
			return IType.Funkcje.CLIENT;
		}else if(login.equals("designer")){
			return IType.Funkcje.DESIGNER;
		}else{
			return IType.Funkcje.NOT_A_USER;
		}
		
		

//		
//		int result;
//		result = IFunkcje.PROJEKTANT;
		/*try {
			IUserSession session =    DatabaseSession.openSession(person.getLogin(), person.getPassword());
			result = session.getSessionTypes()[0];
			
			httpSession.setAttribute(IType.USERNAME, person.getLogin());
			httpSession.setAttribute(IType.USER_SESSION, session);
			logger.info("User has loged-in successfully, login=" + person.getLogin() + "  password=" + person.getPassword() + " userType=" + result);
			
			
			
			StringBuilder b = new StringBuilder();
			
//			IClientSession s = ((IClientSession) session);
//			List l = s.listZgloszenie();
//			
//			s.insertObject(new Zgloszenie().setImieZglaszajacego("SKOK").se);
//			logger.debug("listPracownik.size=" + l.size());
//			
//			for(Object o : l){
//				logger.debug(o.toString());
//			}
			
		} catch (LoginException e) {
			logger.info("Exception on user's attempt to login the dendryt, login=" + person.getLogin() + "  password=" + person.getPassword());
			httpSession.setAttribute(IType.USERNAME, person.getLogin());
			httpSession.setAttribute(IType.USER_SESSION, null);
			
			result = -1;
		}
		
		logger.info("RETURN");*/
//		return result;

	}
	@Override
	public void logout() {
		throw new RuntimeException("not implemented yet!");
	}

	
	
	
	

}
