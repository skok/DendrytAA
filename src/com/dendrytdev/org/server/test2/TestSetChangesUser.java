package com.dendrytdev.org.server.test2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.server.DatabaseConnector;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;

public class TestSetChangesUser extends DendrytTestCaseBase{
	@Test
	public void testEmployee(){
		assertEquals(0, DatabaseConnector.getAllEmployees().size()); //0 at first
		
		Person emp1=new Person();
		emp1.setLogin("pierwszy");
		emp1.setFunction(Function.DESIGNER);
		emp1.setPassword("abc");
		
		assertEquals(true, DatabaseConnector.addPerson(emp1));// first login, must be available and user added
		
		
		assertEquals(1, DatabaseConnector.getAllEmployees().size()); //count all employees
		
		assertEquals("pierwszy",DatabaseConnector.getAllEmployees().get(0).getLogin()); //login
		assertEquals(Function.DESIGNER, DatabaseConnector.getAllEmployees().get(0).getFunction()); //function
		assertEquals("abc", DatabaseConnector.getAllEmployees().get(0).getPassword());//password
		
		
		Person emp1_1=DatabaseConnector.getAllEmployees().get(0);
		
		emp1_1.setFunction(Function.PROGRAMMER);
		emp1_1.setPassword("zxc");
	
		DatabaseConnector.setChanges(emp1_1);
		
		assertEquals(1, DatabaseConnector.getAllEmployees().size());//still only one
		
		assertEquals("pierwszy",DatabaseConnector.getAllEmployees().get(0).getLogin()); //login
		assertEquals(Function.PROGRAMMER, DatabaseConnector.getAllEmployees().get(0).getFunction()); //function
		assertEquals("zxc", DatabaseConnector.getAllEmployees().get(0).getPassword());//password
	}
	@Test
	public void testClients(){
		assertEquals(0, DatabaseConnector.getAllClients().size());//0 at first
		
		Person client1=new Person();
		client1.setLogin("pierwszy");
		client1.setFunction(Function.CLIENT);
		client1.setPassword("abc");
		
		assertEquals(true, DatabaseConnector.addPerson(client1));// first login, must be available and user added
		
		
		assertEquals("pierwszy", DatabaseConnector.getAllClients().get(0).getLogin());// exist
		
		Person client1_1=DatabaseConnector.getAllClients().get(0);
		client1_1.setAddress("Parkowa");
		client1_1.setPassword("qwe");
		DatabaseConnector.setChanges(client1_1);
		
		assertEquals("Parkowa", DatabaseConnector.getAllClients().get(0).getAddress());
		assertEquals("qwe", DatabaseConnector.getAllClients().get(0).getPassword());
		assertEquals("pierwszy", DatabaseConnector.getAllClients().get(0).getLogin());
		
		
		
	}
	
}
