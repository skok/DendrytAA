package com.dendrytdev.org.server.dao;

public class DendrytDAOException extends Exception{
	public DendrytDAOException(String string) {
		super(string);
	}

	public DendrytDAOException(Throwable t) {
		super(t);
	}

	private static final long serialVersionUID = 1L;
}
