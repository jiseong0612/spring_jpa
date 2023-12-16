package hellojpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		 createMember();
//		findMember();
	}

	/**
	 * JPA를 이용하여 멤버 DB inset
	 */
	public static void createMember() {
		//하나만 생성해서 애플리케이션 전체에서 공유
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		//스레드간에 공유X (사용하고 제거)
		EntityManager em = emf.createEntityManager();

		//JPA의 모든 데이터 변경은 트렌젝션 안에서 실행
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
				Member member = new Member();
				member.setUsername("C");
				
				em.persist(member);
				System.out.println("id >>>>> " + member.getId());
				System.out.println("id >>>>> " + member.getId());
				
			tx.commit();
			System.out.println("id >>>>> " + member.getId());
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.clear();
		}

		emf.close();	//emf는 하나만 생성해서 애플리케이션 전체에서 공유, main이 끝나기에  close();
	}

	/**
	 * JPA를 이용하여 멤버 DB select
	 */
	public static void findMember() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			// 1건 검색
			Member findMember = em.find(Member.class, 2L);
			System.out.println("findMember = " + findMember);
			em.flush();
			// 페이징 검색(객체 중심으로 쿼리 작성한다)
			List<Member> memberList = em.createQuery("select m from Member as m", Member.class)
				.setFirstResult(30)
				.setMaxResults(10)
				.getResultList();
			
			System.out.println(memberList);
//			findMember.setName("helloJPA"); // update
//			em.remove(findMember);			// delete
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.clear();
		}

		emf.close();
	}
}
