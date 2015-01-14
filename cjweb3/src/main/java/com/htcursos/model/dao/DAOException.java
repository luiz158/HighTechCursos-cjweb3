package com.htcursos.model.dao;

@SuppressWarnings("serial")
public class DAOException extends Exception {

	public DAOException(String mensagem, Exception e) {
		super(mensagem, e);
	}

}
