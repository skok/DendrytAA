package com.dendrytdev.org.server.test;

import java.util.Calendar;

import javax.jdo.PersistenceManager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Function;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.server.dao.DatabaseConnector;
import com.dendrytdev.org.server.dao.PMF;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;



public class TestCommentsAddition extends DendrytTestCaseBase{
	@Test
	public void addComment(){	
		assertEquals(0, DatabaseConnector.getAllEmployees().size());//0 employees at first
		
		Person designer=new Person();
		designer.setFunction(Function.DESIGNER);
		designer.setLogin("designer");
		designer.setFirstName("Waldemar");
		designer.setSurname("Pawlak");
		
		Person programmer=new Person();
		programmer.setFunction(Function.PROGRAMMER);
		programmer.setLogin("programmer");
		programmer.setFirstName("Krzysztof");
		programmer.setSurname("Jarzyna");
		
		Person tester=new Person();
		tester.setFunction(Function.TESTER);
		tester.setLogin("tester");
		tester.setFirstName("Pawel");
		tester.setSurname("Rakowiecki");
		
		Person service=new Person();
		service.setFunction(Function.SERVICE);
		service.setLogin("service");
		service.setFirstName("Rafal");
		service.setSurname("Baranowicz");
		
		
		DatabaseConnector.addPerson(designer);
		DatabaseConnector.addPerson(programmer);
		DatabaseConnector.addPerson(tester);
		DatabaseConnector.addPerson(service);
		
		assertEquals(4, DatabaseConnector.getAllEmployees().size());//4 employees now
		
		
		assertEquals(0, DatabaseConnector.getAllProblems().size());//0 problems at first
		
		Problem p=new Problem();
		p.setDesigner(designer.getLogin());
		p.setProgrammer(programmer.getLogin());
		p.setTester(tester.getLogin());
		p.setService(service.getLogin());
		
		DatabaseConnector.addProblem(p);
		
		assertEquals(1, DatabaseConnector.getAllProblems().size());//1 problem now
	
		assertEquals("service", DatabaseConnector.getAllProblems().get(0).getService());	//service correct
		
		assertEquals(null, DatabaseConnector.getAllProblems().get(0).getComments());//zero comments
		

		
		DatabaseConnector.addComment(DatabaseConnector.getAllProblems().get(0).getId(), Function.DESIGNER, true, "do roboty programisci!");
		
		assertEquals(1, DatabaseConnector.getAllProblems().get(0).getComments().size());//one comments in problem
		
		assertEquals(1, DatabaseConnector.getAllComments().size());//one comment in BigTable
		
		assertEquals(DatabaseConnector.getAllComments().get(0).getUser(), designer.getLogin());//author comment
		
		assertEquals(programmer.getLogin(), DatabaseConnector.getAllProblems().get(0).getCurrentWorker());//now programmer is current worker
		
		assertEquals("do roboty programisci!", DatabaseConnector.getAllComments().get(0).getContent());//content
		
		DatabaseConnector.addComment(DatabaseConnector.getAllProblems().get(0).getId(), Function.PROGRAMMER, false, "co mam zrobic?");
		
		assertEquals(2, DatabaseConnector.getAllComments().size());//two comment in BigTable
		assertEquals(2, DatabaseConnector.getAllProblems().get(0).getComments().size());//two comments in problem
		
		assertEquals(designer.getLogin(), DatabaseConnector.getAllProblems().get(0).getCurrentWorker());//now designer is current worker
		
	}
}

















