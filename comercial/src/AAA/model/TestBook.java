package AAA.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("comercial");
	        EntityManager em = factory.createEntityManager();
			
			Book bookA = new Book("Book A");
	
	        
			Publisher publisherA = em.find(Publisher.class, 22);
			Publisher publisherB = em.find(Publisher.class, 23);
			
			
	        BookPublisher bookPublisher = new BookPublisher();
	        bookPublisher.setBook(bookA);
	        bookPublisher.setPublisher(publisherA);
	        bookPublisher.setPublishedDate(new Date());
	        
	        bookA.getBookPublishers().add(bookPublisher);
	
	        BookPublisher bookPublisher2 = new BookPublisher();
	        bookPublisher2.setBook(bookA);
	        bookPublisher2.setPublisher(publisherB);
	        bookPublisher2.setPublishedDate(new Date());
	        
	        bookA.getBookPublishers().add(bookPublisher);
	        bookA.getBookPublishers().add(bookPublisher2);
	        
	        em.getTransaction().begin();
	        
//	        em.persist(publisherA);
//	        em.persist(publisherB);
	        em.persist(bookA);
	        
	        
	//        publisherRepository.save(publisherA);
	//        bookRepository.save(bookA);
	
	        // test
	        System.out.println(bookA.getBookPublishers().size());
	
	        // update
	//        bookA.getBookPublishers().remove(bookPublisher);
	//        bookRepository.save(bookA);
	        
	        em.getTransaction().commit();
	
	        // test
	        System.out.println(bookA.getBookPublishers().size());
        
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
