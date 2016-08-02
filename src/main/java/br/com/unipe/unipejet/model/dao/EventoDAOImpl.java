package br.com.unipe.unipejet.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.unipe.unipejet.model.util.EntityManagerUtil;
import br.com.unipe.unipejet.model.vo.Voo;

@Repository
public class EventoDAOImpl implements EventoDAO{

	public void create(Voo evento) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(evento);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void update(Voo evento) {
		EntityManager em = EntityManagerUtil.
				getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(evento);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public void delete(Voo evento) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(evento);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public Voo findById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			return em.find(Voo.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	public List<Voo> listAll() {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			return em.createQuery("From Evento a").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

}
