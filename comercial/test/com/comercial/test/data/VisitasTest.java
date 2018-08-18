package com.comercial.test.data;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.comercial.model.Customer;
import com.comercial.model.Property;
import com.comercial.model.Visit;
import com.comercial.model.VisitProperty;

import com.comercial.service.VisitService;
import com.comercial.service.VisitServiceImpl;

public class VisitasTest {

	
	public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("comercial");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
	
	
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	
	@Test
	public void createVisit() {
		
		EntityManager em = VisitasTest.getEntityManager();
		
		Customer cliente = new Customer();
		cliente.setIdCliente(1);
		
		Visit visita = new Visit();
		
		//visita.setIdVisita(1);
		visita.setCliente(cliente);
		visita.setCompra("1");
		visita.setDescripcion("descripcion de la visita");
		visita.setFecha(new Date());
		visita.setFechaProxima(new Date(System.currentTimeMillis() + 10000000));
		
		em.getTransaction().begin();
		em.persist(visita);
		
		Property pMuestra = new Property(1, "muestras" , "visita");
		VisitProperty muestra1 = new VisitProperty(visita, pMuestra, "muestra_1", 1);
		VisitProperty muestra2 = new VisitProperty(visita, pMuestra, "muestra_2", 2);
		
		Property pPresentado = new Property(2, "presentado" , "visita" );
		VisitProperty presen1 = new VisitProperty(visita, pPresentado, "producto_1", 1);
		VisitProperty presen2 = new VisitProperty(visita, pPresentado, "producto_2", 2);
		
		em.persist(muestra1);
		em.persist(muestra2);
		em.persist(presen1);
		em.persist(presen2);
		
//		visita.getPropiedadesVisita().add(muestra1);
//		visita.getPropiedadesVisita().add(muestra2);
//		visita.getPropiedadesVisita().add(presen1);
//		visita.getPropiedadesVisita().add(presen2);
		
		
		em.getTransaction().commit();
		
		
		assertTrue(true);
		
	}
	
	
	@Test
	public void obtenerListaVisitas() {
		EntityManager em = VisitasTest.getEntityManager();
		
		VisitService ser = new VisitServiceImpl();
		
		List<Visit> lista = ser.getVisitsFiltered(null);
		
		System.out.println("------ LISTA VISITAS ------");
		for (Visit visit : lista) {
			
			System.out.println( visit.toString() );
		}
		System.out.println("------ FIN LISTA VISITAS ------");
		assertTrue(true);

	}
	
	@Test
	public void obtenerVisitaCompleta() {
		
		EntityManager em = VisitasTest.getEntityManager();
		
		Visit visita = em.find(Visit.class, 9);
		
		System.out.println("------ VISITA COMPLETA ------");
		System.out.println( visita);
		for (VisitProperty vp : visita.getPropiedadesVisita()) {
			System.out.println("--" + vp );
		}
		System.out.println("------FIN  VISITA COMPLETA ------");
		assertTrue(true);
		
	}
	
	
	
	
}
