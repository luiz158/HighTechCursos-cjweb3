package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Cidade;
import com.htcursos.model.entity.Estado;

@Repository
public class CidadeDAO {

	// Habilitando uma Injeção de Dependência do Entity Manager
	@PersistenceContext
	EntityManager em;

	public CidadeDAO() {

	}

	@Transactional
	public void salvar(Cidade cidade) throws DAOException {
		try {
			em.merge(cidade);
		} catch (Exception e) {
			throw new DAOException("Não foi possivel salvar!", e);
		}
	}

	@Transactional
	public void excluir(Cidade cidade) {
		cidade = buscarPorId(cidade.getId());
		em.remove(cidade);
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> buscarTodos() {
		// JPQL
		Query consulta = em.createQuery("select c from Cidade c");
		return consulta.getResultList();
	}

	public Cidade buscarPorId(Long id) {
		return em.find(Cidade.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> buscarCidade(Estado estado) {
		Query consulta = em.createQuery("select c from Cidade c.estado=:est");
		consulta.setParameter("est", estado);
		return consulta.getResultList();
	}
}
