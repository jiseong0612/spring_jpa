package joinColumn;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "TEAM_ID")
	private Long teamId;
	private String name;

	/* - 누구를 연관관계의 주인??
	 * 외래 키가 있는 곳을 주인으로 정해라
	 * 따라서 Member가 teamId(FK)를 가지고 있으므로 주인
	 */
	@OneToMany(mappedBy = "team")
	private List<Member> members = new ArrayList<Member>();
		
	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", members=" + members + "]";
	}
}
