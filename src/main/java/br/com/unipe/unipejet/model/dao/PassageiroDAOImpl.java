package br.com.unipe.unipejet.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.unipe.unipejet.model.util.EntityManagerUtil;
import br.com.unipe.unipejet.model.vo.Passageiro;

@Repository
public class PassageiroDAOImpl implements PassageiroDAO {

	public void create(Passageiro passageiro) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(passageiro);
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

	public void update(Passageiro usuario) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(usuario);
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

	public void delete(Passageiro usuario) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(usuario);
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

	public List<Passageiro> listAll() {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			return em.createQuery("From Usuario a").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public Passageiro findById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			return em.find(Passageiro.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;

	}

}
