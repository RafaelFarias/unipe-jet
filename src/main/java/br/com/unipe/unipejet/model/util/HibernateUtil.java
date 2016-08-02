package br.com.unipe.unipejet.model.util;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.unipe.unipejet.model.vo.Autorizacao;
import br.com.unipe.unipejet.model.vo.Passageiro;
import br.com.unipe.unipejet.model.vo.Voo;

public class HibernateUtil implements Serializable {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
					.addAnnotatedClass(Autorizacao.class)
					.addAnnotatedClass(Passageiro.class)
					.addAnnotatedClass(Voo.class).
					configure().buildSessionFactory();
		}

		return sessionFactory;
	}

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
	}
}
