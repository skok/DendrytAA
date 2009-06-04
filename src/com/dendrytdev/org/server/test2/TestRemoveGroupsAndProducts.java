package com.dendrytdev.org.server.test2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.dendrytdev.org.client.bean.Group;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.server.DatabaseConnector;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;

public class TestRemoveGroupsAndProducts extends DendrytTestCaseBase{
	@Test
	public void removeGroups(){
		assertEquals(0, DatabaseConnector.getAllGroups().size());	//empty at first
		
		Group g=new Group();
		g.setName("systemy operacyjne");
		
		assertEquals(true, DatabaseConnector.addGroup(g));
		
		assertEquals("systemy operacyjne", DatabaseConnector.getAllGroups().get(0).getName());
		
		DatabaseConnector.removeGroup(g);
		
		
		
		assertEquals(0, DatabaseConnector.getAllGroups().size()); //after remove should be 0
		
		Group g2=new Group();
		g2.setName("systemy operacyjne");
		
		assertEquals(true, DatabaseConnector.addGroup(g2));
		
		
		assertEquals(1, DatabaseConnector.getAllGroups().size());
		
		Group g3=new Group();
		g3.setName("programy biurowe");
		
		assertEquals(true, DatabaseConnector.addGroup(g3));
		
		assertEquals(2, DatabaseConnector.getAllGroups().size());
	
		DatabaseConnector.removeGroup(g3);
	
		assertEquals(1, DatabaseConnector.getAllGroups().size());
	
	}
	@Test
	public void removeProducts(){
		assertEquals(0, DatabaseConnector.getAllProducts().size());//empty at first
		
		Product p1=new Product();
		
		p1.setName("excel");
		p1.setVersion("1.0");
		p1.setGroup("programy biurowe");
		
		assertEquals(true, DatabaseConnector.addProduct(p1));
		
		assertEquals(1, DatabaseConnector.getAllProducts().size());
		
		DatabaseConnector.removeProduct(p1);
		
		assertEquals(0, DatabaseConnector.getAllProducts().size());//empty
		
		Product p2=new Product();
		
		p2.setName("excel");
		p2.setVersion("1.0");
		p2.setGroup("programy biurowe");
		
		assertEquals(true, DatabaseConnector.addProduct(p2));
	
		Product p3=new Product();
		
		p3.setName("windows");
		p3.setVersion("1.0");
		p3.setGroup("systemy operacyjne");
		
		assertEquals(true, DatabaseConnector.addProduct(p3));
		
		assertEquals(2, DatabaseConnector.getAllProducts().size());
		
		DatabaseConnector.removeProduct(p2);
		DatabaseConnector.removeProduct(p3);
		assertEquals(0, DatabaseConnector.getAllProducts().size());//empty
	}
	
}
