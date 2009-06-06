package com.dendrytdev.org.server.client;

import java.util.logging.Logger;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.client.problemSubmiting.ProblemSubmitingService;
import com.dendrytdev.org.server.dao.DendrytDAOException;
import com.dendrytdev.org.server.dao.ProblemDAO;
import com.dendrytdev.org.server.dao.ProductDAO;
import com.dendrytdev.org.server.dao.intf.IProblemDAO;
import com.dendrytdev.org.server.dao.intf.IProductDAO;



public class ProblemSubmitingServiceImpl implements ProblemSubmitingService{
	
	IProductDAO prod = new ProductDAO();
	IProblemDAO prob = new ProblemDAO();



	@Override
	public Product[] getAllProducts() {
		// TODO: product imitation = before there is no product adding
		// it will add a few product for testing purposes
		try{
			Product[] arr = prod.readAll();
			if(arr.length == 0){
				//fill the base
				Product p;
				p = new Product();
				p.setName("Dendryt");
				p.setVersion("1");
				prod.create(p);
				
				p = new Product();
				p.setName("GoogleWave");
				p.setVersion("1");
				prod.create(p);
				
				p = new Product();
				p.setName("CyfronWIWI");
				p.setVersion("1");
				prod.create(p);
				
				p = new Product();
				p.setName("Eclipse");
				p.setVersion("1");
				prod.create(p);
				
				p = new Product();
				p.setName("Gmail");
				p.setVersion("1");
				prod.create(p);
				
				arr = prod.readAll();
			}
			return arr;
		}catch(Throwable t){
			Logger l = Logger.getLogger(ProblemSubmitingServiceImpl.class.getName());
			
			StackTraceElement[] arr = t.getStackTrace();
			StringBuilder s = new StringBuilder();
			for(StackTraceElement e : arr){
				s.append(e.toString() + "\n");
			}
			
			l.warning(s.toString());
			Product p = new Product();
			p.setName(s.toString());
			return new Product[]{p};
		}
	}

	@Override
	public boolean submitProblem(Problem p) {
		try {
			return prob.create(p);
		} catch (DendrytDAOException e) {
			return false;
		}
	}
	

	

}
