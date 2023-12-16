package joinColumn;

import java.util.List;

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
			//연관관계 주인에 값을 넣어야 한다.
			Team team1 = new Team();
			team1.setName("incheon");
			em.persist(team1);
			
			Member member = new Member();
			member.setUserName("user01");
			member.changeTeam(team1);
			em.persist(member);
			
			em.flush();
			em.clear();

			Team findTeam = em.find(Team.class, team1.getTeamId());
			List<Member> members = findTeam.getMembers();
			
			System.out.println("==================");
			System.out.println("members >>> " + findTeam);	//무한 루프에 빠짐 stackOverFlow
			System.out.println("==================");
			
			
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
