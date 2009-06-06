package com.dendrytdev.org.client.bean;


import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

/*
 *               |
          \   |   /
     .     \  |  /    .
      `-.__|\/_\/|_.-'
    .__  \ /     `./
       `-</        \
    ----<|         _|
     _.-<|    _    o(
    '    /   (.      >
      .-'`.   `     -
     '     `     __.'
           _)___(
          //    \\
         | |    | \
         | |    |  \

 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Group implements IsSerializable{
	
	@Persistent
	@PrimaryKey
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
