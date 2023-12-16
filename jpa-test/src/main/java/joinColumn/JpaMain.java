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
			// code;
			Team team1 = new Team();
			team1.setName("incheon");
			em.persist(team1);

			Member member = new Member();
			member.setUserName("won ders");
			member.setTeam(team1);
			em.persist(member);

			//영속성 컨텍스트 날리고 쿼리 조회하고 싶을때
			em.flush();
			em.clear();
			
			Member findMember = em.find(Member.class, member.getId());
			System.out.println(findMember.getTeam().getName());
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
