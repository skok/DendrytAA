package com.dendrytdev.org.client.bean.dto;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.user.client.rpc.IsSerializable;

/*
    .,,,.           ...           .,,,.        
   ((o o))        (`@ @`)        ((6 6))       
 ___\ - /___    ___\ o /___    ___\ v /___     
($_   &   _$)  ($_   %   _$)  ($_   &   _$)    
   |  %  |        |  &  |        |  %  |       
   |  &  |        |  %  |        |  &  |       
   /  %  \        /  &  \        /  %  \       
 _/  / \  \_    _/  / \  \_    _/  / \  \_     
($__/   \__$)  ($__/   \__$)  ($__/   \__$) ldb

 */
public class RaportDTO implements IsSerializable {
	private Comment[] commentArray;
	private Person[] personList;
	public Comment[] getCommentArray() {
		return commentArray;
	}
	public void setCommentArray(Comment[] commentArray) {
		this.commentArray = commentArray;
	}
	public Person[] getPersonList() {
		return personList;
	}
	public void setPersonList(Person[] personList) {
		this.personList = personList;
	}


}
