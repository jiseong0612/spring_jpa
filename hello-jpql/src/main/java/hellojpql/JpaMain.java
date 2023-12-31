package hellojpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpql.domain.Member;
import hellojpql.domain.Team;

public class JpaMain {
	public static void main(String[] args) {// 하나만 생성해서 애플리케이션 전체에서 공유
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		// 스레드간에 공유X (사용하고 제거)
		EntityManager em = emf.createEntityManager();

		// JPA의 모든 데이터 변경은 트렌젝션 안에서 실행
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {
			Team team = new Team();
			team.setName("powerTeam");
			em.persist(team);
			
			Member member = new Member();
			member.setUsername("aaaa");
			member.setTeam(team);
			em.persist(member);
			
			Member member2 = new Member();
			member2.setUsername("bbbb");
			member2.setTeam(team);
			em.persist(member2);

			em.flush();
			em.clear();

			Team findTeam = em.find(Team.class, team.getId());
			List<Member> memberList = findTeam.getMembers();
			
			for(Member teamMember : memberList) {
				System.out.println(teamMember.getUsername());
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.clear();
		}

		emf.close(); // emf는 하나만 생성해서 애플리케이션 전체에서 공유, main이 끝나기에 close();
	}
}