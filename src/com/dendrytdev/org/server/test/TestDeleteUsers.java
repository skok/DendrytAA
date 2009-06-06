package com.dendrytdev.org.server.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.server.dao.DatabaseConnector;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;

public class TestDeleteUsers extends DendrytTestCaseBase{
	@Test
	public void DeleteEmployees(){
		assertEquals(0, DatabaseConnector.getAllEmployees().size()); //0 at first
		
		Person emp1=new Person();
		emp1.setLogin("pierwszy");
		emp1.setFunction(Function.DESIGNER);
		emp1.setPassword("abc");
		
		assertEquals(true, DatabaseConnector.addPerson(emp1));// first login, must be available and user added
		
		
		assertEquals(1, DatabaseConnector.getAllEmployees().size()); //count all employees
		
		DatabaseConnector.remove(emp1); //remove
		
		assertEquals(0, DatabaseConnector.getAllEmployees().size()); //count all employees
		
	
		assertEquals(true, DatabaseConnector.addPerson(emp1));// first login, must be available and user added
		
		Person emp2=new Person();//second
		emp2.setFunction(Function.SERVICE);
		emp2.setLogin("drugi");
		assertEquals(true, DatabaseConnector.addPerson(emp2)); //second login
		
		assertEquals(2, DatabaseConnector.getAllEmployees().size());
		
		DatabaseConnector.remove(emp1);//remove all 
		DatabaseConnector.remove(emp2); 
		
		
		assertEquals(0, DatabaseConnector.getAllEmployees().size());
		
	}
	@Test
	public void DeleteClients(){
		assertEquals(0, DatabaseConnector.getAllClients().size()); //0 at first
		
		Person client1=new Person();
		client1.setLogin("pierwszy");
		client1.setFunction(Function.CLIENT);
		client1.setPassword("abc");
		
		assertEquals(true, DatabaseConnector.addPerson(client1));// first login, must be available and user added
		
		assertEquals(1, DatabaseConnector.getAllClients().size());
		
		DatabaseConnector.remove(client1);
		
		
		assertEquals(0, DatabaseConnector.getAllClients().size());
		
	}
	
	
	
}
