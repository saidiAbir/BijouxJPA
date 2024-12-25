package com.abir.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.abir.entities.Bijoux;
import com.abir.util.JPAutil;

public class BijouxDao {
	private EntityManager entityManager = JPAutil.getEntityManager("Bijoux_JPA");

	public void ajouter(Bijoux b) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(b);
		tx.commit();

	}

	public void modifier(Bijoux b) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(b);
		tx.commit();

	}

	public void supprimer(Bijoux b) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		b = entityManager.merge(b); // important
		entityManager.remove(b);
		tx.commit();
	}

	public Bijoux consulter(Bijoux b, Object id) {
		return entityManager.find(b.getClass(), id);
	}

	public List<Bijoux> listerTous() {
		List<Bijoux> Bij = entityManager.createQuery("select b from Bijoux b").getResultList();
		return Bij;
	}

	public List<Bijoux> listerParNom(String nom) {
		List<Bijoux> Bij = entityManager.createQuery("select b from Bijoux b where b.NOM_Bijoux like :nom").setParameter("nom", "%" + nom + "%").getResultList();
		return Bij;
	}
}