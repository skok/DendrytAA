package com.dendrytdev.org.client.designer.raportOverview;


import com.dendrytdev.org.client.bean.dto.RaportDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RaportOverviewServiceAsync{
	public void getCommentsWithPeople(Long problemID, AsyncCallback<RaportDTO> a);
}
