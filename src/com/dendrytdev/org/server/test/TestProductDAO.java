package com.dendrytdev.org.server.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.problemSubmiting.ProblemSubmitingService;
import com.dendrytdev.org.server.ProblemSubmitingServiceImpl;
import com.dendrytdev.org.server.dao.CommentDAO;
import com.dendrytdev.org.server.dao.DendrytDAOException;
import com.dendrytdev.org.server.dao.ProductDAO;
import com.dendrytdev.org.server.dao.intf.ICommentDAO;
import com.dendrytdev.org.server.dao.intf.IProductDAO;
import com.dendrytdev.org.server.test.base.DendrytTestCaseBase;

public class TestProductDAO extends DendrytTestCaseBase {

	@Test
	public void stestComboReadInsertDelete() throws DendrytDAOException {
		IProductDAO i = new ProductDAO();
		assertEquals(0, i.readAll().length); // empty at start
		i.create(new Product());
		assertEquals(1, i.readAll().length);
		i.create(new Product());

		// after adding two objects
		Product[] c = i.readAll();
		assertEquals(2, c.length);

		// get inx of first and check if read(ID) will method return it
		Long id = c[0].getId();
		Product com = i.read(id);
		assertNotNull(com);

		// now delete it, and check if it was deleted
		i.delete(com);
		com = i.read(id);
		assertNull(com);

		c = i.readAll();
		for (Product ccc : c) {
			i.delete(ccc);
		}

		c = i.readAll();
		assertEquals(0, c.length); // empty at the end
	}

	@Test
	public void testDelete() throws DendrytDAOException {
		final int NO = 10;
		IProductDAO i = new ProductDAO();
		Product[] arr = new Product[NO];

		// add 10 (==NO) Products
		for (int j = 0; j < arr.length; j++) {
			arr[j] = new Product();
		}

		assertEquals(i.readAll().length, 0); // empty at start

		for (Product c : arr) {
			i.create(c);
		}

		// check if all have been added
		arr = i.readAll();
		assertEquals(NO, arr.length);

		// delete all, one-by-one
		// after each deletion check if it has been succesfully
		int cnt = NO;
		for (Product c : arr) {
			i.delete(c);
			assertEquals(--cnt, i.readAll().length);
		}
	}
	
	@Test
	public void parkowa42test(){
		ProblemSubmitingService i = new ProblemSubmitingServiceImpl();
		Product[] arr = i.getAllProducts();
		assertEquals(5, arr.length);
		
		arr = i.getAllProducts();
		assertEquals(5, arr.length);
		

		
	}

}