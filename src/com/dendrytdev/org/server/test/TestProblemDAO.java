package com.dendrytdev.org.server.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.server.dao.DendrytDAOException;
import com.dendrytdev.org.server.dao.ProblemDAO;
import com.dendrytdev.org.server.dao.intf.IProblemDAO;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;

public class TestProblemDAO extends DendrytTestCaseBase{
	
	/**
	 * initialy there should be no Problems, etc. (sounds like a joke ;)
	 * @throws DendrytDAOException 
	 */
	@Test
	public void stestComboReadInsertDelete() throws DendrytDAOException {
		IProblemDAO i = new ProblemDAO();
		assertEquals(0, i.readAll().length); //empty at start
		i.create(new Problem());
		assertEquals(1, i.readAll().length); 
		i.create(new Problem());
		
		// after adding two objects
		Problem[] c = i.readAll();
		assertEquals(2, c.length); 
		
		// get inx of first and check if read(ID) will method return it
		Long id = c[0].getId();		
		Problem com = i.read(id);
		assertNotNull(com);
		
		//now delete it, and check if it was deleted
		i.delete(com);
		com = i.read(id);
		assertNull(com);
		
		c = i.readAll();
		for(Problem ccc : c){
			i.delete(ccc);
		}
		
		c = i.readAll();
		assertEquals(0, c.length); // empty at the end
	}
	
	
	@Test
	public void testDelete() throws DendrytDAOException {
		final int NO = 10;
		IProblemDAO i = new ProblemDAO();
		Problem[] arr = new Problem[NO];
		
		// add 10 (==NO) comments
		for(int j = 0; j < arr.length; j++){
			arr[j] = new Problem();
		}
		
		assertEquals(i.readAll().length, 0); // empty at start
		
		for(Problem c : arr){
			i.create(c);
		}
		
		//check if all have been added
		arr = i.readAll();
		assertEquals(NO, arr.length);

		//delete all, one-by-one
		//after each deletion check if it has been succesfully
		int cnt = NO;
		for(Problem c : arr){
			i.delete(c);
			assertEquals(--cnt, i.readAll().length);
		}	
	}
	
	@Test
	public void addingCommentsToProblem(){
		
	}
	
	

}
