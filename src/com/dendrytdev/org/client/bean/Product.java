package com.dendrytdev.org.client.bean;
//import javax.jdo.annotations.IdGeneratorStrategy;
//import javax.jdo.annotations.IdentityType;
//import javax.jdo.annotations.PersistenceCapable;
//import javax.jdo.annotations.Persistent;
//import javax.jdo.annotations.PrimaryKey;
//import javax.jdo.annotations.Unique;
//
//import com.google.appengine.api.datastore.Key;
//
//@PersistenceCapable(identityType = IdentityType.APPLICATION)
//@Unique(name="UNIQUE_NAME_VERSION_OF_PRODUCT", members={"name", "version"})
//public class Product {
//    @PrimaryKey
//    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//    private Key key;
//    
//    @Persistent
//	private Group group;
//	@Persistent
//	private String name;
//	@Persistent
//	private Double version;
//    
//
//
//	public Group getGroup() {
//		return group;
//	}
//	public void setGroup(Group group) {
//		this.group = group;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Double getVersion() {
//		return version;
//	}
//	public void setVersion(Double version) {
//		this.version = version;
//	}
//	
//	
//}
