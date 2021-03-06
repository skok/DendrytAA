package com.dendrytdev.org.client.bean;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

/*
 *                        ____,-----'      (              
                          )'                \              
                         |                   |             
                         |                   |             
                        |                     |            
                        |+++++++++++++++++++++|            
                       |++++++++++++++++++++++ |_          
                   __,-|+++++++++;"""""""""""""  `--._     
            ___,--'     ~~~~~~~~~    _______________ _`-.  
          ,'          ________,-----'~~~~~~~~~~~~~~######-.
          `---._____,-'~~~~~~~                __     ~~~~~~
               ~~~~~       ____      ____,---' \\          
                          /::::\    /::::\      ||         
                         |::::::|==|::::::|                
                          \::::/    \:::::/                
                           ~~~~      ~~~~~                 
                                                           
                            ,---------------.              
                          ,'(___________ )  ;`.            
                         /  \           /  ,'  `.          
                     _/ `._  \_        /  ,'     `.        
                   _/      `.  \       / ,                 
                  /         `. (########)     _/           
                 |           `-.\######/'    /             
|"""""""""""""""""""":        | `----':   _/               
|                    :        | : * * :  /                 
|    GASS FACE       :         | : *  : /                  
|                    :          | *    /                   
|                    |   
 */

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Comment implements IsSerializable{
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @PrimaryKey
    private Long id;
    
    /**
     * date when the comment was added to the system
     */
    @Persistent
    Date date;
    
    /**
     * login of user that added the comment (foreign key from Person entity)
     */
    @Persistent
    String user;
    
    /**
     * content of the comment - simply: text describing the problem
     */
    @Persistent
    String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
