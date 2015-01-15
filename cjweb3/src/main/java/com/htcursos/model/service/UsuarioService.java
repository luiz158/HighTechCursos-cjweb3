package com.htcursos.model.service;

import java.util.List;

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
		try {
			// Valida��o de Regras de Neg�cio
			if (usuario.getNome() == null || usuario.getNome() == "") {
				throw new ServiceException("Campo Nome v�zio!");
			}
			usuarioDAO.salvar(usuario);
		} catch (DAOException e) {
			throw new ServiceException("N�o foi possivel salvar!", e);
		}
	}

	public List<Usuario> buscarTodos() {
		List<Usuario> lista = usuarioDAO.buscarTodos();
		return lista;
	}

	public void excluir(Usuario usuario) {
		usuarioDAO.excluir(usuario);
		
	}
	
}
