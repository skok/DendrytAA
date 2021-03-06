package com.dendrytdev.org.client.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


import com.google.gwt.user.client.rpc.IsSerializable;

/*
                                    _
                               _ooOoo_
                              o8888888o
                              88" . "88
                              (| -_- |)
                              O\  =  /O
                           ____/`---'\____
                         .'  \\|     |//  `.
                        /  \\|||  :  |||//  \
                       /  _||||| -:- |||||_  \
                       |   | \\\  -  /'| |   |
                       | \_|  `\`---'//  |_/ |
                       \  .-\__ `-. -'__/-.  /
                     ___`. .'  /--.--\  `. .'___
                  ."" '<  `.___\_<|>_/___.' _> \"".
                 | | :  `- \`. ;`. _/; .'/ /  .' ; |
                 \  \ `-.   \_\_`. _.'_/_/  -' _.' /
       ===========`-.`___`-.__\ \___  /__.-'_.'_.-'================
                               `=--=-'                   
 */

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Problem implements IsSerializable{
    
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @PrimaryKey
    private Long id;


	@Persistent
	private String product;
	@Persistent
	private String clientImportance;
	@Persistent
	private Date problemDate;
	@Persistent
	private String client;
	@Persistent
	private String service;
	@Persistent
	private String designer;
	@Persistent
	private String programmer;
	@Persistent
	private String tester;
	@Persistent
	private String description;
	@Persistent
	private List<Long> comments;
	

	@Persistent
	private String currentWorker;


	/**
	 * WARNING: does not persist the comment in DB, only adds the reference
	 * to the comments' list
	 * You must make the added comment persistent before adding it here!!!
	 * @param comment
	 */
	public void addComment(Long commentId){
		if(comments==null){
			comments=new ArrayList<Long>();
		}
		comments.add(commentId);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getClientImportance() {
		return clientImportance;
	}
	public void setClientImportance(String clientImportance) {
		this.clientImportance = clientImportance;
	}
	public Date getProblemDate() {
		return problemDate;
	}
	public void setProblemDate(Date problemDate) {
		this.problemDate = problemDate;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getDesigner() {
		return designer;
	}
	public void setDesigner(String designer) {
		this.designer = designer;
	}
	public String getProgrammer() {
		return programmer;
	}
	public void setProgrammer(String programmer) {
		this.programmer = programmer;
	}
	public String getTester() {
		return tester;
	}
	public void setTester(String tester) {
		this.tester = tester;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Long> getComments() {
		return comments;
	}
	
	public void setComments(List<Long> comments) {
		this.comments = comments;
	}
	
	public String getCurrentWorker() {
		return currentWorker;
	}

	public void setCurrentWorker(String currentWorker) {
		this.currentWorker = currentWorker;
	}
	
	public void fill(Problem p){
		product = p.product;
		clientImportance = p.clientImportance;
		problemDate = p.problemDate;
		client = p.client;
		service = p.service;
		designer = p.designer;
		programmer = p.programmer;
		tester = p.tester;
		description = p.description;	
		comments = p.comments;
		currentWorker = p.currentWorker;
	}


	
	
}
