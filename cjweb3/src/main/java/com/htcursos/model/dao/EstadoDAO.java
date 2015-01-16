package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Estado;

@Repository
public class EstadoDAO {

	// Habilitando uma Injeção de Dependência do Entity Manager
	@PersistenceContext
	EntityManager em;

	public EstadoDAO() {

	}

	@Transactional
	public void salvar(Estado estado) throws DAOException {
		try {
			em.merge(estado);
		} catch (Exception e) {
			throw new DAOException("Não foi possivel salvar!", e);
		}
	}

	@Transactional
	public void excluir(Estado estado) {
		estado = buscarPorId(estado.getId());
		em.remove(estado);
	}

	@SuppressWarnings("unchecked")
	public List<Estado> buscarTodos() {
		// JPQL
		Query consulta = em.createQuery("select e from Estado e");
		return consulta.getResultList();
	}

	public Estado buscarPorId(Long id) {
		return em.find(Estado.class, id);
	}
}
