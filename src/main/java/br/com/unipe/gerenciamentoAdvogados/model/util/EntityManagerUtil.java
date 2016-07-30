package br.com.unipe.gerenciamentoAdvogados.model.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static EntityManagerFactory entityManagerFactory;

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("GerenciamentoDeAdvogados");
		}

		return entityManagerFactory;
	}

	public static void main(String[] args) {
		EntityManagerUtil.getEntityManagerFactory();
	}

}
