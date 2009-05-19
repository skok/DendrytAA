package com.dendrytdev.org.client.bean;
//
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
//@Unique(name="UNIQUE_GROUP_NAME", members={"name"})
//public class Group {
//    @PrimaryKey
//    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//    private Key key;
//    @Persistent
//    private String name;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//}
