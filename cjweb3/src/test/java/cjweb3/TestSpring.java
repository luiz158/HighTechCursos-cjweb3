package cjweb3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.htcursos.model.dao.DAOException;
import com.htcursos.model.dao.UsuarioDAO;
import com.htcursos.model.entity.Usuario;

public class TestSpring {

	@Test
	public void testSpring() throws DAOException {
		@SuppressWarnings("resource")
		ApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsuarioDAO usuarioDAO = contexto.getBean(UsuarioDAO.class);
		
		Usuario usuario = new Usuario();
		usuario.setNome("Test Spring");
		usuario.setSenha("123456");
		usuario.setEmail("testspring@test.net");
		
		usuarioDAO.salvar(usuario);
	}
}
