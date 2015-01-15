package com.htcursos.model.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.UsuarioDAO;
import com.htcursos.model.entity.Usuario;

@Service // Ser� carregado pelo Spring
public class UsuarioService {
	
	@Inject
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
