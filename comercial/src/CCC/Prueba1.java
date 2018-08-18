package CCC;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Prueba1 {

	private static EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("comercial");
	 
	protected static EntityManager em = factory.createEntityManager();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		
		 em.getTransaction().begin();
		
		
//		crear();
		
		modificar();
		 
//		 Producto p1 = em.find(Producto.class, 1);
//		 Producto p2 = em.find(Producto.class, 2);
//		 Cliente c1 = em.find(Cliente.class, 1);
//		 
//		 Factura f1 = em.find(Factura.class, 1);
//		 		 
//		 LineaFactura l3 = new LineaFactura(f1,f1.getLineas().size(),p1,14);
//		 f1.getLineas().add(l3);
//		 
//		 em.merge(f1);
		
		 em.getTransaction().commit();
		 
		 
		 
		} catch (Throwable t) {
			
			t.printStackTrace();
		} finally {
			if (em.getTransaction().isActive()) {
		        em.getTransaction().rollback();
			}
			em.close();
		}
		
	}
	
	
	private static void modificar() {
		
		Factura fac = em.find(Factura.class, 2);
		Producto p3 = em.find(Producto.class, 3); 
		
		Cliente c3 = em.find(Cliente.class, 3);
		
		fac.setCliente(c3);
		
//		LineaFactura linea = new LineaFactura(fac, 5, p3, 55);
//		fac.getLineas().add(linea);
//		linea.setFactura(fac);
		
		fac.getLineas().remove(0);
		
		//em.detach(fac);
		//em.merge(fac);
		em.persist(fac);

//		for ( LineaFactura lin : fac.getLineas() ) {
//			 em.persist(lin);
//		 }
		
		
	}

	
	private static void crear() {
		
		 Cliente c1 = new Cliente(null, "Inigo");
		 em.persist(c1);
		 
		 Producto p1 = new Producto(null,"pan");
		 Producto p2 = new Producto(null,"leche");
		 em.persist(p1);
		 em.persist(p2);
		 
		 Factura fac = new Factura();
		 fac.setCliente(c1);
		 
		 LineaFactura l1 = new LineaFactura(fac,1,p1,2 );
		 LineaFactura l2 = new LineaFactura(fac,2,p2,34 );
		 
		 fac.getLineas().add(l1);
		 fac.getLineas().add(l2);
		 
		 em.persist(fac);
		 
		 for ( LineaFactura linea : fac.getLineas() ) {
			 em.persist(linea);
		 }
		 
	}
	
	
	
}
