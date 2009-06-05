package com.dendrytdev.org.server.test2;

import org.junit.*;
import static org.junit.Assert.*;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.server.DatabaseConnector;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;

public class TestUserAddition extends DendrytTestCaseBase{
	
	@Test
	public void testAdditionEmployee(){
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
		
		Person emp2=new Person();//second
		emp2.setFunction(Function.SERVICE);
		emp2.setLogin("drugi");
		
		assertEquals(true, DatabaseConnector.addPerson(emp2));
		
		assertEquals(2, DatabaseConnector.getAllEmployees().size());
		
		Person emp3=new Person();//third- login exist in database!
		emp2.setLogin("drugi");
		
		assertEquals(false, DatabaseConnector.addPerson(emp2));
		
		assertEquals(2, DatabaseConnector.getAllEmployees().size());
		
		assertEquals(2, DatabaseConnector.getAllPerson().size());// only employees
		
		assertEquals(0, DatabaseConnector.getAllClients().size());//no clients
	}
	@Test
	public void testAdditionClient(){
		assertEquals(0, DatabaseConnector.getAllClients().size());//0 at first
		
		Person client1=new Person();
		client1.setLogin("pierwszy");
		client1.setFunction(Function.CLIENT);
		client1.setPassword("abc");
		
		assertEquals(true, DatabaseConnector.addPerson(client1));// first login, must be available and user added
		
		
		assertEquals("pierwszy", DatabaseConnector.getAllClients().get(0).getLogin());// exist
		
		Person client2=new Person();//second
		client2.setLogin("drugi");
		
		assertEquals(true, DatabaseConnector.addPerson(client2));
		
		assertEquals(2, DatabaseConnector.getAllPerson().size());// only clients
		
		assertEquals(0, DatabaseConnector.getAllEmployees().size()); //no employees
	}
}
