package AAA;

 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
/**
 * @author Oscar Blancarte
 */
public class EntityManagerUtil {
    
    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("comercial");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
    
    public static void main(String[] args) {
        EntityManager manager = EntityManagerUtil.getEntityManager();
        System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
    }
}