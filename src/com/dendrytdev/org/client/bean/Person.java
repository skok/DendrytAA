package com.dendrytdev.org.client.bean;


import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.gwt.user.client.rpc.IsSerializable;



@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Person implements IsSerializable{
	@Persistent
	@PrimaryKey
	private String login;
	@Persistent
	private String companyName;
	@Persistent
	private String firstName;
	@Persistent
	private String surname;
	@Persistent
	private String password;
	@Persistent
	private String email;
	@Persistent
	private String telephone;
	@Persistent
	private Function function;
	
	//address,policy-only for clients
	@Persistent
	private Boolean policy;
	@Persistent
	private String address;
	@Persistent
	private String city;
	
	
	public Person(){
		super();
		login="";
		firstName="";
		surname="";
		password="";
		email="";
		telephone="";
		
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Function getFunction() {
		return function;
	}


	public void setFunction(Function function) {
		this.function = function;
	}


	public Boolean getPolicy() {
		return policy;
	}


	public void setPolicy(Boolean policy) {
		this.policy = policy;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString(){
		return getFirstName() + " " + getSurname() + " [" + getLogin() + "]";
	}
	
}
