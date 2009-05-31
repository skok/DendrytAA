package com.dendrytdev.org.server;

import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.Product;
import com.dendrytdev.org.client.problemSubmiting.ProblemSubmitingService;
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
			if(prod.readAll().length == 0){
				//fill the base
				Product p;
				p = new Product();
				p.setName("Dendryt");
				prod.create(p);
				
				p = new Product();
				p.setName("GoogleWave");
				prod.create(p);
				
				p = new Product();
				p.setName("CyfronWIWI");
				prod.create(p);
				
				p = new Product();
				p.setName("Eclipse");
				prod.create(p);
				
				p = new Product();
				p.setName("Gmail");
				prod.create(p);
				
			}
		}catch(Throwable t){
			t.printStackTrace();
		}
		
		return prod.readAll();
		
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
