package loadingType;

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
			//code
			Team team = new Team();
			team.setName("power Team");
			em.persist(team);
			
			Member member = new Member();
			member.setUserName("jiseong");
			member.setTeam(team);
			
			em.persist(member);
			
			em.flush();
			em.clear();
			
			Member findMember = em.find(Member.class, member.getId());

			System.out.println("class = " + findMember.getTeam().getClass());
			
			System.out.println("member name : " + findMember.getUserName());
			
			System.out.println("==========================================");
			System.out.println("team name : "  + findMember.getTeam().getName());
			System.out.println("==========================================");
			
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
