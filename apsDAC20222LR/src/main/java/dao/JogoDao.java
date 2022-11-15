package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogo;
import util.JPAUtil;

public class JogoDao {

	public static void salvar(Jogo j) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(j);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Jogo j) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		Jogo j2 = em.merge(j);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void remover(Jogo j) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		j = em.find(Jogo.class, j.getId());
		em.remove(j);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Jogo> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select j from Jogo j");
		List<Jogo> lista = q.getResultList();
		em.close();
		return lista;
	}
	
	public static Jogo acharPorId(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Jogo j = em.find(Jogo.class, id);
		em.close();
		return j;
	}
	
}
