package com.dendrytdev.org.client.bean.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class AssignmentDTO implements IsSerializable{
	String servicerLogin;
	String designerLogin;
	String programmerLogin;
	String testerLogin;
	Long problemId;
	public String getServicerLogin() {
		return servicerLogin;
	}
	public void setServicerLogin(String servicerLogin) {
		this.servicerLogin = servicerLogin;
	}
	public String getDesignerLogin() {
		return designerLogin;
	}
	public void setDesignerLogin(String designerLogin) {
		this.designerLogin = designerLogin;
	}
	public String getProgrammerLogin() {
		return programmerLogin;
	}
	public void setProgrammerLogin(String programmerLogin) {
		this.programmerLogin = programmerLogin;
	}
	public String getTesterLogin() {
		return testerLogin;
	}
	public void setTesterLogin(String testerLogin) {
		this.testerLogin = testerLogin;
	}
	public Long getProblemId() {
		return problemId;
	}
	public void setProblemId(Long problemId) {
		this.problemId = problemId;
	}

}
