package com.dendrytdev.org.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.problemOverview.ProblemOverviewService;
import com.dendrytdev.org.server.dao.DendrytDAOException;
import com.dendrytdev.org.server.dao.ProblemDAO;
import com.dendrytdev.org.server.dao.intf.IProblemDAO;

public class ProblemOverviewServiceImpl implements ProblemOverviewService{
	
	static List<Problem> testingList = new ArrayList<Problem>();
	IProblemDAO i = new ProblemDAO();

	
	/**
	 * for mega fucking testing purposes only ;>
	 */
	Problem generateOneProblem(String[] s){
		Problem p = new Problem();
		p.setProduct(s[0]);
		p.setClient(s[1]);
		p.setClientImportance(s[2]);
		p.setProblemDate(new Date());
		p.setService(s[3]);
		p.setDesigner(s[4]);
		p.setProgrammer(s[5]);
		p.setTester(s[6]);
		p.setDescription(s[7]);
	
		return p;
	}
	
		
	@Override
	public List<Problem> getProblemList(int lastListHashCode) {
//		List<Problem> list = generateTestingValues(); // TODO: take it from DB!!!
//		int hash = list.hashCode();
//		System.out.println("hash" + hash);
//		System.out.println("lastListHashCode" + lastListHashCode);
//		if(lastListHashCode == hash){
//			return null; //no changes on server side, no need to send the data
//		}else{
//			lastListHashCode = hash;
//			return list;
//		}
		try {
			return Arrays.asList(i.readAll());
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Map<Long, List<Comment>> getMapOfCommentList(List<Long> problemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
