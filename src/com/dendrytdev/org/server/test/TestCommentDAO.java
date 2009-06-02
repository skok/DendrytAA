package com.dendrytdev.org.server.test;

import static org.junit.Assert.*;

import org.junit.*;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.server.dao.CommentDAO;
import com.dendrytdev.org.server.dao.DendrytDAOException;
import com.dendrytdev.org.server.dao.intf.ICommentDAO;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;

public class TestCommentDAO extends DendrytTestCaseBase {
		
	@Test
	public void stestComboReadInsertDelete() throws DendrytDAOException {
		ICommentDAO i = new CommentDAO();
		assertEquals(0, i.readAll().length); //empty at start
		i.create(new Comment());
		assertEquals(1, i.readAll().length); 
		i.create(new Comment());
		
		// after adding two objects
		Comment[] c = i.readAll();
		assertEquals(2, c.length); 
		
		// get inx of first and check if read(ID) will method return it
		Long id = c[0].getId();		
		Comment com = i.read(id);
		assertNotNull(com);
		
		//now delete it, and check if it was deleted
		i.delete(com);
		com = i.read(id);
		assertNull(com);
		
		c = i.readAll();
		for(Comment ccc : c){
			i.delete(ccc);
		}
		
		c = i.readAll();
		assertEquals(0, c.length); // empty at the end
	}
	
	
	@Test
	public void testDelete() throws DendrytDAOException {
		final int NO = 10;
		ICommentDAO i = new CommentDAO();
		Comment[] arr = new Comment[NO];
		
		// add 10 (==NO) comments
		for(int j = 0; j < arr.length; j++){
			arr[j] = new Comment();
		}
		
		assertEquals(i.readAll().length, 0); // empty at start
		
		for(Comment c : arr){
			i.create(c);
		}
		
		//check if all have been added
		arr = i.readAll();
		assertEquals(NO, arr.length);

		//delete all, one-by-one
		//after each deletion check if it has been succesfully
		int cnt = NO;
		for(Comment c : arr){
			i.delete(c);
			assertEquals(--cnt, i.readAll().length);
		}	
	}
	
	


}
