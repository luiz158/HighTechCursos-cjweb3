package com.htcursos.model.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.CidadeDAO;
import com.htcursos.model.entity.Cidade;
import com.htcursos.model.entity.Estado;

@Service
public class CidadeService {
	@Inject
	CidadeDAO cidadeDAO;
	
	public void salvar(Cidade cidade) throws ServiceException {
		try {
			cidadeDAO.salvar(cidade);
		} catch (DAOException e) {
			throw new ServiceException("Não foi possivel salvar!", e);
		}
	}
	
	public Cidade buscarPorId(Long id) {
		return cidadeDAO.buscarPorId(id);
	}
	
	public List<Cidade> buscarTodos() {
		List<Cidade> lista = cidadeDAO.buscarTodos();
		return lista;
	}

	public void excluir(Cidade cidade) {
		cidadeDAO.excluir(cidade);
		
	}

	public List<Cidade> buscarCidades(Estado estado) {
		return cidadeDAO.buscarCidade(estado);
	}
	
}
