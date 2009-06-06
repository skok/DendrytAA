package com.dendrytdev.org.server.designer;

import java.util.LinkedList;
import java.util.List;
import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Person;
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
			System.out.println("!!!&&**");

			ProblemDAO pDAO = new ProblemDAO();
			CommentDAO cDAO = new CommentDAO();
			List<Long> commentsID = pDAO.read(problemID).getComments();
			if(commentsID == null){
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
					for (Person p : pList) {
						if (login.equals(p.getLogin())) {
							peopleOut.add(p);
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
