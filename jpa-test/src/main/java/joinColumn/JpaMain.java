package joinColumn;

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
			//정상 CASE
			//연관관계 주인에 값을 넣어야 한다.
			Team team1 = new Team();
			team1.setName("incheon");
			em.persist(team1);
			
			Member member = new Member();
			member.setUserName("user01");
			member.setTeam(team1);
			em.persist(member);
			
			//에러 CASE
			//주인이 아닌 것에 넣으면 null
			Member member2 = new Member();
			member2.setUserName("user02");
			em.persist(member2);
			
			Team team2 = new Team();
			team2.setName("seoul");
			team2.getMembers().add(member2);
			em.persist(team2);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
