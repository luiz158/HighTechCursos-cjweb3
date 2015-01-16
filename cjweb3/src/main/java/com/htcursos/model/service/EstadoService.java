package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.EstadoDAO;
import com.htcursos.model.entity.Estado;

@Service
public class EstadoService {
	@Inject
	EstadoDAO estadoDAO;
	
	public void salvar(Estado estado) throws ServiceException {
		try {
			estadoDAO.salvar(estado);
		} catch (DAOException e) {
			throw new ServiceException("Não foi possivel salvar!", e);
		}
	}
	
	public Estado buscarPorId(Long id) {
		return estadoDAO.buscarPorId(id);
	}
	
	public List<Estado> buscarTodos() {
		List<Estado> lista = estadoDAO.buscarTodos();
		return lista;
	}

	public void excluir(Estado estado) {
		estadoDAO.excluir(estado);
		
	}
	
}
