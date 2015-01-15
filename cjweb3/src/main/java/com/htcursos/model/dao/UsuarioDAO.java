package com.htcursos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.entity.Usuario;

@Repository
public class UsuarioDAO {
	
	// Habilitando uma Injeção de Dependência do Entity Manager
	@PersistenceContext
	EntityManager em;
	
	public UsuarioDAO() {
		
	}
	
	@Transactional
	public void salvar(Usuario usuario) throws DAOException {
		try {
			em.merge(usuario);
		} catch (Exception e) {
			throw new DAOException("Não foi possivel salvar!", e);
		}
	}

	@Transactional
	public void excluir(Usuario usuario) {
		usuario = buscarPorId(usuario.getId());
		em.remove(usuario);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos() {
		// JPQL
		Query consulta = em.createQuery("select u from Usuario u");		
		return consulta.getResultList();
	}
	
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}

}
