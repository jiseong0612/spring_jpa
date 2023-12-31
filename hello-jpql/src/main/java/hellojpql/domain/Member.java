package hellojpql.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {
	@Id @GeneratedValue
	private Long id;
	private String username;
	private int age;
	
	@ManyToOne
	@JoinColumn(name="TEAM_ID")
	private Team team;
	
//	@OneToMany
//	private List<Order> orderList = new ArrayList();
	
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Member() {
	}

	public Member(Long id, String username, int age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public List<Order> getOrderList() {
//		return orderList;
//	}
//
//	public void setOrderList(List<Order> orderList) {
//		this.orderList = orderList;
//	}
}