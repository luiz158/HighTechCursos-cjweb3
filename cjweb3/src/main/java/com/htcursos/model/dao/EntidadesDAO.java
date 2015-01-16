package com.htcursos.model.dao;

import java.util.List;

public interface EntidadesDAO {
	void salvar(Object obj);
	void excluir(Object obj);
	List<Object> buscarTodos();
	Object buscarPorId(Long id);
}
