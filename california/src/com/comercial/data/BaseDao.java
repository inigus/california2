package com.comercial.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseDao {

//	 private EntityManagerFactory factory = Persistence
//             .createEntityManagerFactory("comercial");
	 
	 protected EntityManager em;// = factory.createEntityManager();
	 
	 
	 public BaseDao(EntityManager em) {
		 this.em = em;
	 }
	 
	 
	 
/* 
	 protected void initTransaction() {
		 em.getTransaction().begin();
		 
	 }
	 
	 
	 
	 protected void finishTransaction() {
		 em.getTransaction().commit(); 
	 }
*/	 

}
