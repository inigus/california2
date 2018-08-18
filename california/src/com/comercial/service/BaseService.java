package com.comercial.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseService {

	
	private EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("comercial");
	 
	 protected EntityManager em = factory.createEntityManager();
	 

	 protected void initTransaction() {
		 em.getTransaction().begin();
		 
	 }	 
	 
	 protected void finishTransaction() {
		 em.getTransaction().commit(); 
	 }
	 
	 protected void finishTransaction(Throwable t){
		 
		 if (em.getTransaction().isActive()) {
		        em.getTransaction().rollback();
		 }
		em.close();
	 }
	 
	 
}
	 
	 

