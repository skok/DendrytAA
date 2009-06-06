package com.dendrytdev.org.client.designer.raportOverview;

import com.dendrytdev.org.client.bean.dto.RaportDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("RaportOverviewServlet")
public interface RaportOverviewService extends RemoteService{
	
	/**
	 * method-name sounds really ugly ... ;)
	 */
	public RaportDTO getCommentsWithPeople(Long problemID);
}
