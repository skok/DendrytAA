package com.dendrytdev.org.client.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Problem {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;


	//	@Persistent
//	private Product product;
	@Persistent
	Person client;
	@Persistent
	private String wagaKlienta;
	@Persistent
	private Date dataZgloszenia;
//	@Persistent
//	private Person serwice;
//	@Persistent
//	private Person designer;
//	@Persistent
//	private Person programmer;
//	@Persistent
//	private Person tester;
	@Persistent
	private String description;
	/*
	Persistent
	private Set<Comment> comments;

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment c) {
		if (comments == null) {
			comments = new HashSet<Comment>();
		}
		comments.add(c);
	}
*/
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	public Person getClient() {
		return client;
	}

	public void setClient(Person client) {
		this.client = client;
	}

	public String getWagaKlienta() {
		return wagaKlienta;
	}

	public void setWagaKlienta(String wagaKlienta) {
		this.wagaKlienta = wagaKlienta;
	}

	public Date getDataZgloszenia() {
		return dataZgloszenia;
	}

	public void setDataZgloszenia(Date dataZgloszenia) {
		this.dataZgloszenia = dataZgloszenia;
	}

//	public Person getSerwice() {
//		return serwice;
//	}
//
//	public void setSerwice(Person serwice) {
//		this.serwice = serwice;
//	}

//	public Person getDesigner() {
//		return designer;
//	}
//
//	public void setDesigner(Person designer) {
//		this.designer = designer;
//	}
//
//	public Person getProgrammer() {
//		return programmer;
//	}
//
//	public void setProgrammer(Person programmer) {
//		this.programmer = programmer;
//	}
//
//	public Person getTester() {
//		return tester;
//	}
//
//	public void setTester(Person tester) {
//		this.tester = tester;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	

}
