package AAA.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class TestBook3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("comercial");
	        EntityManager em = factory.createEntityManager();
	        
	        em.getTransaction().begin();
	        
	        Book bookA = em.find(Book.class, 24);
	        
	        for(BookPublisher bPublisher : bookA.getBookPublishers()){
	        	
	        	System.out.println( bPublisher.getPublisher().getName() + "-" + bPublisher.getPublishedDate().toString()  );
	        }
	        
	        Publisher pubC = new Publisher();
	        pubC.setName("Publicador CCC");
	        
	        em.persist(pubC);
	        
	        BookPublisher bpCC = new BookPublisher();
	        bpCC.setPublisher(pubC);
	        //bpCC.setBook(bookA);
	        bpCC.setPublishedDate(new Date());
	        
	        bookA.getBookPublishers().add(bpCC);
	        
	        em.merge(bookA);
	        
	        em.getTransaction().commit();
	        //System.out.println(bookA);
        
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
