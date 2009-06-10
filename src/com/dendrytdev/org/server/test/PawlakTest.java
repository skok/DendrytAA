package com.dendrytdev.org.server.test;

import org.junit.Test;

import com.dendrytdev.org.server.login.AuthenticateUserImpl;
import com.dendrytdev.org.server.login.LoginTool;
import com.dendrytdev.org.server.servicer.ServicerServiceImpl;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;

public class PawlakTest extends DendrytTestCaseBase {
	
	@Test
	public void test1(){
		ServicerServiceImpl i = new ServicerServiceImpl();
		

		try{			
			i.addProblem(null);
		}catch(Throwable e){}
		
		try{			
			i.getAllClients();
		}catch(Throwable e){}
		
		try{			
			i.getAllProducts();
		}catch(Throwable e){}
		
		AuthenticateUserImpl ii = new AuthenticateUserImpl();
		try{			
			ii.authenticate(null);
		}catch(Throwable e){}

		
		try{			
			ii.logout();
		}catch(Throwable e){}
		
		
		try{			
			LoginTool.getLogin(null);
			
			
		}catch(Throwable e){}

		
		try{					
			
			LoginTool.getUsertype(null);
		}catch(Throwable e){}
		try{					
			LoginTool.isLogged(null);
			
		}catch(Throwable e){}
		try{					
			LoginTool.logout(null);
			
		}catch(Throwable e){}
		try{					
			LoginTool.setLogin(null, null);
			
		}catch(Throwable e){}
		try{					
			
			LoginTool.setUsertype(null, null);
		}catch(Throwable e){}
		
		
		
		
		
	}

}
