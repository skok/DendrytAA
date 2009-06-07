package com.dendrytdev.org.server.designer;

import java.util.LinkedList;
import java.util.List;
import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Person;
import com.dendrytdev.org.client.bean.Problem;
import com.dendrytdev.org.client.bean.dto.RaportDTO;
import com.dendrytdev.org.client.designer.raportOverview.RaportOverviewService;
import com.dendrytdev.org.server.dao.CommentDAO;
import com.dendrytdev.org.server.dao.DatabaseConnector;
import com.dendrytdev.org.server.dao.DendrytDAOException;
import com.dendrytdev.org.server.dao.ProblemDAO;
import com.dendrytdev.org.server.dao.intf.ICommentDAO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RaportOverviewServlet extends RemoteServiceServlet implements
		RaportOverviewService {

	private static final long serialVersionUID = 1L;

	@Override
	public RaportDTO getCommentsWithPeople(Long problemID) {
		RaportDTO dto = new RaportDTO();
		try {
			System.out.println("!!!&&**" + problemID);

			ProblemDAO pDAO = new ProblemDAO();
			CommentDAO cDAO = new CommentDAO();
			Problem p = pDAO.read(problemID);
			//get current worker ///// refactor the shit!!!
			List<Person> lp = DatabaseConnector.getAllPerson();
			for(Person pp : lp){
				if(pp.getLogin().equals(p.getCurrentWorker())){
					dto.setCurrentWorker(pp.getFirstName() + " " + pp.getSurname() + " ["
							+ pp.getLogin() + "]");
					break;
				}
			}
			
			List<Long> commentsID = p.getComments();
			if(commentsID == null){
				dto.setCommentArray(new Comment[0]);
				dto.setPersonList(new Person[0]);
				return dto;
			}

			List<Person> pList = DatabaseConnector.getAllPerson();
			
			List<Person> peopleOut = new LinkedList<Person>();
			List<Comment> commentsOut = new LinkedList<Comment>();

			for (Long cID : commentsID) {
				Comment c = cDAO.read(cID);
				commentsOut.add(c);
				if (c != null) {
					String login = c.getUser();
					for (Person pp : pList) {
						if (login.equals(pp.getLogin())) {
							peopleOut.add(pp);
						}
					}
				}
			}

			dto.setPersonList(peopleOut.toArray(new Person[0]));
			dto.setCommentArray(commentsOut.toArray(new Comment[0]));
		} catch (DendrytDAOException e) {
			e.printStackTrace();
		}
		return dto;

	}

}
