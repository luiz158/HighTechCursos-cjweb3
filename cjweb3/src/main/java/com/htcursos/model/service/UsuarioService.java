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
		// Validação de Regras de Negócio
		if(usuario.getNome() == null) {
			throw new ServiceException("Campos Nome vázio!");
		}
		
		try {
			usuarioDAO.salvar(usuario);
		} catch (DAOException e) {
			throw new ServiceException("Não foi possivel salvar!", e);
		}
	}
}
