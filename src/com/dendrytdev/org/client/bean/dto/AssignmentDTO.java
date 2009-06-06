package com.dendrytdev.org.client.bean.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

/*
                                            _.oo.                    
                 _.u[[/;:,.         .odMMMMMM'                    
              .o888UU[[[/;:-.  .o@P^    MMM^                      
             oN88888UU[[[/;::-.        dP^                        
            dNMMNN888UU[[[/;:--.   .o@P^                          
           ,MMMMMMN888UU[[/;::-. o@^                              
           NNMMMNN888UU[[[/~.o@P^                                 
           888888888UU[[[/o@^-..                                  
          oI8888UU[[[/o@P^:--..                                   
       .@^  YUU[[[/o@^;::---..                                    
     oMP     ^/o@P^;:::---..     
  .dMMM    .o@^ ^;::---...                                        
 dMMMMMMM@^`       `^^^^                                          
YMMMUP^                                                           
 ^^   
 
 */
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
