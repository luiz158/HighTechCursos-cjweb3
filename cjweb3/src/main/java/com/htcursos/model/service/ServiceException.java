package com.htcursos.model.service;

import com.htcursos.model.dao.DAOException;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	public ServiceException(String mensagem) {
		super(mensagem);
	}

	public ServiceException(String mensagem, DAOException e) {
		super(mensagem, e);
	}

}
