package br.com.unipe.unipejet.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.unipe.unipejet.model.util.EntityManagerUtil;
import br.com.unipe.unipejet.model.vo.Voo;

@Repository
public class VooDAOImpl implements VooDAO {

	public void create(Voo voo) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(voo);
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

	public void update(Voo voo) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(voo);
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

	public void delete(Voo voo) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(voo) ? voo : em.merge(voo));
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

	public List<Voo> listAll() {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			return em.createQuery("From Voo a").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
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
	
	public List<Voo> searchVoo(Voo voo) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			
			String query = "From Voo v Where 1=1";
			
			if(voo.getCidadeOrigem() != null && !voo.getCidadeOrigem().isEmpty()){
				query = query + " and v.cidadeOrigem = '" + voo.getCidadeOrigem() + "'";
			}			
			
			if(voo.getCidadeDestino() != null && !voo.getCidadeDestino().isEmpty()){
				query = query + " and v.cidadeDestino = '" + voo.getCidadeDestino() + "'";
			}			
			
			if(voo.getDataStr() != null && !voo.getDataStr().isEmpty()){
				query = query + " and v.data = '" + voo.getDataStr() + "'";
			}			
			
			List<Voo> result = em.createQuery(query).getResultList();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

}
