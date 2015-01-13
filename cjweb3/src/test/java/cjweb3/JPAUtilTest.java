package cjweb3;

import javax.persistence.EntityManager;

import com.htcursos.model.entity.Usuario;
import com.htcursos.model.util.JPAUtil;

public class JPAUtilTest {
	
	public static void main(String[] args) {
		
		// Instância do Gerenciador de Entidades
		EntityManager em = JPAUtil.abreConexao();
		
		// Objeto a ser persistido
		Usuario usuario = new Usuario();
		usuario.setNome("Marcelo");
		usuario.setSenha("123456");
		usuario.setEmail("marcelostadtlober@gmail.com");
		
		// Abertura de transação com o BD
		em.getTransaction().begin();
		em.persist(usuario);
		// Executa no BD o SQL
		em.getTransaction().commit();
		
	}
}
