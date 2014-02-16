package phantom.lancer.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestDB {
	
	private static final String PERSISTENCE_UNIT_NAME = "myapp";
	private static EntityManagerFactory factory;

	  public static void main(String[] args) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    // read the existing entries and write to console
	    Query q = em.createQuery("select u from User u");
	    List<User> todoList = q.getResultList();
	    for (User todo : todoList) {
	      System.out.println(todo);
	    }
	    System.out.println("Size: " + todoList.size());

	    // create new todo
	    em.getTransaction().begin();
	    User todo = new User();
	    todo.setUsername("This is a test");
	    todo.setEmail("This is a test");
	    em.persist(todo);
	    em.getTransaction().commit();

	    em.close();
	  }
}
