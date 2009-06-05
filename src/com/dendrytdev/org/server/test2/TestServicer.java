package com.dendrytdev.org.server.test2;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.server.DatabaseConnector;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;

public class TestServicer extends DendrytTestCaseBase{
	@Test
	public void testAddProblems(){

		
		Problem p=new Problem();
		p.setClient("klient");
		p.setClientImportance("1");
		p.setDescription("straszny blad");

		p.setProgrammer("programista");
		
		
		assertEquals(0, DatabaseConnector.getAllProblems().size());
		
		DatabaseConnector.addProblem(p);
		
		assertEquals(1, DatabaseConnector.getAllProblems().size());
		
		assertEquals("klient", DatabaseConnector.getAllProblems().get(0).getClient());
		
		assertEquals("1", DatabaseConnector.getAllProblems().get(0).getClientImportance());
		
		assertEquals("straszny blad", DatabaseConnector.getAllProblems().get(0).getDescription());
		
		assertEquals("programista", DatabaseConnector.getAllProblems().get(0).getProgrammer());
		
	}

}
