package br.com.unipe.gerenciamentoAdvogados.model.util;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.unipe.gerenciamentoAdvogados.model.vo.Advogado;
import br.com.unipe.gerenciamentoAdvogados.model.vo.Anuidade;
import br.com.unipe.gerenciamentoAdvogados.model.vo.Autorizacao;
import br.com.unipe.gerenciamentoAdvogados.model.vo.Evento;
import br.com.unipe.gerenciamentoAdvogados.model.vo.Usuario;

public class HibernateUtil implements Serializable {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
					.addAnnotatedClass(Autorizacao.class)
					.addAnnotatedClass(Usuario.class)
					.addAnnotatedClass(Advogado.class)
					.addAnnotatedClass(Anuidade.class)
					.addAnnotatedClass(Evento.class).
					configure().buildSessionFactory();
		}

		return sessionFactory;
	}

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
	}
}
