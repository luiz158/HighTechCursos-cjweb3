package com.htcursos.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.UsuarioDAO;
import com.htcursos.model.entity.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public void salvar(Usuario usuario) throws ServiceException {
		// Valida��o de Regras de Neg�cio
		if(usuario.getNome() == null) {
			throw new ServiceException("Campos Nome v�zio!");
		}
		
		try {
			usuarioDAO.salvar(usuario);
		} catch (DAOException e) {
			throw new ServiceException("N�o foi possivel salvar!", e);
		}
	}
}
