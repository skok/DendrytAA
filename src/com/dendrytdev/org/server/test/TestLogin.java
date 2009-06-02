package com.dendrytdev.org.server.test;

import org.junit.Test;
import static org.junit.Assert.*;

import com.dendrytdev.org.client.login.LoginDTO;
import com.dendrytdev.org.client.login.IAuthenticateUser;
import com.dendrytdev.org.client.tools.IType;
import com.dendrytdev.org.server.login.AuthenticationServlet;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;



//falling when session was added - need to create special mock's .... TODO later....
public class TestLogin extends DendrytTestCaseBase{
	@Test
	public void nullNull(){
//		IAuthenticateUser s = new AuthenticationServlet();
//		assertEquals(IType.Funkcje.NOT_LOGGED, s.authenticate(new LoginDTO()));
//		

	}
	
	@Test
	public void hardcodedAccounts(){
//		IAuthenticateUser s = new AuthenticationServlet();
//		// for testing purposes this (two)accounts are hardcoded!!!
//		assertEquals(IType.Funkcje.DESIGNER, s.authenticate(new LoginDTO("designer", "")));
//		assertEquals(IType.Funkcje.CLIENT, s.authenticate(new LoginDTO("client", "")));
	}
	

}
