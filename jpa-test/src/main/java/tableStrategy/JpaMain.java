package tableStrategy;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Movie movie = new Movie();
			movie.setDirector("aaa");
			movie.setActor("bbb");
			movie.setName("바람과 함께 사라지다");
			movie.setPrice(10000);
			movie.setCreatedBy("jiseong");
			movie.setCreatedDate(LocalDateTime.now());
			em.persist(movie);
			
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		
		emf.close();
	}
}
