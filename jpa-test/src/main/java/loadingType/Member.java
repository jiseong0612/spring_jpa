package loadingType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {

	@Id @GeneratedValue
	private Long id;
	
	private String userName;
	
	/*
	 * fetch에서 EAGER 는 default, 하지만 가급적 지연 로딩만 사용(특히 실무에서)
	 * 즉시 로딩을 적용하면 예상하지 못 한 SQL 발생(ex: 나는 Member 만 쓰는데 Team이 무조건 join !!) 
	 * EAGER로 두고 사용시 JPQL에서 n + 1 문제 발생 (ex: 멤버 목록을 조회했더니 Team이 EAGER? 그러면 모든 Team도 다시 조회!!)
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
