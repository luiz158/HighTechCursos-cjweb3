package cjweb3;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.UsuarioDAO;
import com.htcursos.model.entity.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class TestUsuarioDAO {
	
	@Autowired
	UsuarioDAO usuarioDAO;

	@Test
	public void testSalvar() throws DAOException {
		Usuario usuario = new Usuario();
		usuario.setNome("Teste");
		usuario.setSenha("123");
		usuario.setEmail("test@user.net");
		
		usuarioDAO.salvar(usuario);
	}
	
	@Test
	@Ignore
	public void testExcluir() {
		Usuario usuario = usuarioDAO.buscarPorId(11L);
		
		usuarioDAO.excluir(usuario);
	}
	
	@Test
	@Ignore
	public void testBuscarPorId() {
		Usuario usuario = usuarioDAO.buscarPorId(3L);
		
		assertTrue(usuario != null);
	}
	
	@Test
	@Ignore
	public void testBuscarTodos() {
		List<Usuario> lista = usuarioDAO.buscarTodos();
		
		assertTrue(lista.size() > 0);
	}

}
