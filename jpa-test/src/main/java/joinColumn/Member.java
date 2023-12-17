package joinColumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "MEMBER_ID")
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String userName;
	
	@ManyToOne
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
	/*
	 * 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정하자.
	 * 디비를 조회하고 온다면(flush(), clean()) JPA가 알아서 연관관계를 세팅해 주겠지만 
	 * 그렇지 않은경우 순수 코드 상에선 한쪽 만 연관관계가 맺혀지기 때문에 코드 상에서도 한쪽 관계를 맺을때 다른 한쪽도 관계가 맺게 해줘라.
	 * changeTeam(); 단순 get/set이 아닌 로직이 들어간 함수의 경우 이름을 바꿔 해당 함수의 중요성을 높힌다.
	 */
	public void changeTeam(Team team) {
		this.team = team;
		team.getMembers().add(this); //  <- 팀을 세팅하는경우, 팀의 맴버(this)도 세팅하게 작업(양뱡향)
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", userName=" + userName + ", team=" + team + "]";
	}
	
}
