package hellojpql.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
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
	
	@Embedded
	private Address homeAddress;
	
	//값 타입 컬렉션
	@ElementCollection
	@CollectionTable(name = "FAVORITE_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
	private Set<String> favoriteFoods = new HashSet<String>();
	
	//값 타입 컬렉션
	@ElementCollection
	@CollectionTable(name = "ADRRESS")
	private List<Address> addressHistory = new ArrayList<Address>();
	
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