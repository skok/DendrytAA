package com.dendrytdev.org.client.tools;

public interface IType {
	public interface Funkcje {
		byte NOT_A_USER = -1;
		byte SERVICEMAN = 0;
		byte DESIGNER = 1;
		byte PROGRAMMER = 2;
		byte TESTER = 3;
		byte CLIENT = 4;
	}
	
	String SESSION_USERTYPE = "usertype";
	String SESSION_LOGIN = "login";
	String EMPTY_STRING = "";
}
