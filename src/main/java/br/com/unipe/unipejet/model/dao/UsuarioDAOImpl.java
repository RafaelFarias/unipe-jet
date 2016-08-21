package br.com.unipe.unipejet.model.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import br.com.unipe.unipejet.model.util.EntityManagerUtil;
import br.com.unipe.unipejet.model.vo.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	public void create(Usuario usuario) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			if(!isMaiorIdade(usuario))
				throw new Exception("Menor de 18 anos!");
			em.getTransaction().begin();
			em.persist(usuario);
			this.gerarNumCartaoMilhas(em, usuario);
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

	public void update(Usuario usuario) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			if(!isMaiorIdade(usuario))
				throw new Exception("Menor de 18 anos!");
			
			Usuario usuarioPersistido = this.findById(usuario.getId());
			if (!usuario.getNumCartaoMilha().equals(
					usuarioPersistido.getNumCartaoMilha())) {
				throw new Exception("Não é possível alterar o cartão de milhas");
			}
			
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

	public void delete(Usuario usuario) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.contains(usuario) ? usuario : em.merge(usuario));
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
	
	public Usuario login(String login, String senha) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			return (Usuario) em.createQuery("From Usuario a Where a.login='" + login + 
					"' and a.senha='" + senha + "'").getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	public List<Usuario> listAll() {
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
	public Usuario findById(Long id) {
		EntityManager em = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			return em.find(Usuario.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}
	
	private void gerarNumCartaoMilhas(EntityManager em, Usuario u){

			Calendar calendar = Calendar.getInstance();
			int ano = calendar.get(Calendar.YEAR);
			
			String numCartaoMilha = ano + "/0000" + u.getId();
			u.setNumCartaoMilha(numCartaoMilha);
			em.merge(u);
	}
	
	private boolean isMaiorIdade(Usuario usuario){
		
		Calendar dtNascimento = usuario.getDataNascimento();
		Calendar dtAtual = Calendar.getInstance();
		
		int anoNascimento = dtNascimento.get(Calendar.YEAR);
		int anoAtual = dtAtual.get(Calendar.YEAR);
		if(anoAtual - anoNascimento > 18)
			return true;
		return false;
	}
	
}
