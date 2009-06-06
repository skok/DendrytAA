package com.dendrytdev.org.client.bean.dto;

import com.dendrytdev.org.client.bean.Comment;
import com.dendrytdev.org.client.bean.Person;
import com.google.gwt.user.client.rpc.IsSerializable;

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
