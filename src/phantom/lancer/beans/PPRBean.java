package phantom.lancer.beans;

import java.io.Serializable;  



import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import phantom.lancer.model.User;


@ManagedBean(name="pprBean")
@SessionScoped
public class PPRBean implements Serializable {  
  
    private String firstname; 
    private static final String PERSISTENCE_UNIT_NAME = "myapp";
	private static EntityManagerFactory factory;
    
      
    public String getFirstname() {  
    	test();
        return firstname;  
    }  
  
    public void setFirstname(String firstname) {  
        this.firstname = firstname;  
    }  
    
    public void test() {
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