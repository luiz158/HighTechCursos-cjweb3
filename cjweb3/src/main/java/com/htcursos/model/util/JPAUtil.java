package com.htcursos.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

		private static EntityManagerFactory entityManagerFactory;
		private static EntityManager em;
		
		static {
			entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
			em = entityManagerFactory.createEntityManager();
		}
		
		/**
		 * Método que retorna um objeto EntityManager
		 * @return
		 */
		public static EntityManager abreConexao() {
			return em;
		}
}
