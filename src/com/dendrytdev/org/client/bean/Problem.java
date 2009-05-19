package com.dendrytdev.org.client.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;



@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Problem implements IsSerializable{
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


	
	
	
	
	////////////// TMP!!! refactor the shit
	@Persistent
	String produkt;
	
	
	public String getProdukt() {
		return produkt;
	}

	public void setProdukt(String produkt) {
		this.produkt = produkt;
	}

	public String getImieZglaszajacego() {
		return imieZglaszajacego;
	}

	public void setImieZglaszajacego(String imieZglaszajacego) {
		this.imieZglaszajacego = imieZglaszajacego;
	}

	public String getNazwiskoZglaszajacego() {
		return nazwiskoZglaszajacego;
	}

	public void setNazwiskoZglaszajacego(String nazwiskoZglaszajacego) {
		this.nazwiskoZglaszajacego = nazwiskoZglaszajacego;
	}

	public String getTelefonZglaszajacego() {
		return telefonZglaszajacego;
	}

	public void setTelefonZglaszajacego(String telefonZglaszajacego) {
		this.telefonZglaszajacego = telefonZglaszajacego;
	}

	public String getSerwisant() {
		return serwisant;
	}

	public void setSerwisant(String serwisant) {
		this.serwisant = serwisant;
	}

	public String getProjektant() {
		return projektant;
	}

	public void setProjektant(String projektant) {
		this.projektant = projektant;
	}

	public String getProgramista() {
		return programista;
	}

	public void setProgramista(String programista) {
		this.programista = programista;
	}

	public String getTester() {
		return tester;
	}

	public void setTester(String tester) {
		this.tester = tester;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}






	@Persistent
	String imieZglaszajacego;
	
	
	@Persistent
	String nazwiskoZglaszajacego;
	
	
	@Persistent
	String telefonZglaszajacego;
	
	
	@Persistent
	String serwisant;
	
	
	@Persistent
	String projektant;
	
	
	@Persistent
	String programista;
	
	
	@Persistent
	String tester;
	
	
	@Persistent
	String opis;
	
	

	

}
