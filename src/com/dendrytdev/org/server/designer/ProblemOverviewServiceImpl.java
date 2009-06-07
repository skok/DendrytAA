package com.dendrytdev.org.server.designer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.dto.AssignmentDTO;
import com.dendrytdev.org.client.bean.dto.RaportDTO;
import com.dendrytdev.org.client.designer.problemOverview.ProblemOverviewService;
import com.dendrytdev.org.server.dao.CommentDAO;
import com.dendrytdev.org.server.dao.DatabaseConnector;
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


	@Override
	public Person[] getAllPeople() {
		return DatabaseConnector.getAllPerson().toArray(new Person[0]);
	}


	@Override
	public void setAssignment(AssignmentDTO a) {
		try {
			ProblemDAO dao = new ProblemDAO();
			Problem p = dao.read(a.getProblemId());
			p.setService(a.getServicerLogin());
			p.setDesigner(a.getDesignerLogin());
			p.setProgrammer(a.getProgrammerLogin());
			p.setTester(a.getTesterLogin());
			dao.update(p);
		} catch (DendrytDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public RaportDTO getRaport(Long problemID) {
		RaportDTO dto = new RaportDTO();
		try {
			ProblemDAO pDAO = new ProblemDAO();
			CommentDAO coDAO = new CommentDAO();
			Problem p = pDAO.read(problemID);
			
			List<Comment> list = new LinkedList<Comment>();
			List<Person> personList = new LinkedList<Person>();
			
			for(Long commentID : p.getComments()){
				Comment c = coDAO.read(commentID);
				list.add(c);	
				personList.add(DatabaseConnector.readPerson(c.getUser()));
			}
			
			dto.setCommentArray(list.toArray(new Comment[0]));
			dto.setPersonList(personList.toArray(new Person[0]));
		} catch (DendrytDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return dto;
	}


	String _currentLogin;
	
	
	public void set_currentLogin(String login) {
		_currentLogin = login;
	}


	@Override
	public List<Problem> getMyProblemList() {
		List<Problem> out = null;
		try {
			out = Arrays.asList(i.read(_currentLogin));
		} catch (DendrytDAOException e) {
			System.out.println("!!!!!!!!!!!!!!:)");
			e.printStackTrace();
		}
		return out;
	}


	@Override
	public void assignMeAsDesigner(Long problemID) {
		try {
			ProblemDAO dao = new ProblemDAO();
			Problem p = dao.read(problemID);
			p.setDesigner(_currentLogin);
			p.setCurrentWorker(_currentLogin);
			dao.update(p);
		} catch (DendrytDAOException e) {
			e.printStackTrace();
		}
	}
	


}
