package hellojpa;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/*
 * JPA를 사용해서 테이블과 매핑할 클래스는 @Entity 필수
 * 기본 생성자 필수!
 * final 클래스, enum, interface, inner 클래스 사용X
 * 저장할 필드에 final 사용X
 */
@Entity
@Table(name = "member") // 테이블명과 객체명이 다를경우 사용, 같다면 생략 가능
public class Member {
	
	@Id
	private Long id;
	
	@Column(name = "name")
	private String username; 
	
	private Integer age;
	
	@Enumerated(EnumType.STRING)	//EnumType.ORDINAL로 했다가 이넘 순서를 바꾼다면 기존의 모든 값이 꼬인다. 무조건 String
	private RoleType roleType;
	
//	@Temporal(TemporalType.TIMESTAMP)	아직도 date를 쓰는 프로젝트라면 어쩔수 없이 사용해야함.
//	private Date createdDate;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date lastModifiedDate;
	
	private LocalDate testLocalDate;
	private LocalDateTime testLocalDatetime;
	
	@Lob
	private String description;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public LocalDate getTestLocalDate() {
		return testLocalDate;
	}

	public void setTestLocalDate(LocalDate testLocalDate) {
		this.testLocalDate = testLocalDate;
	}

	public LocalDateTime getTestLocalDatetime() {
		return testLocalDatetime;
	}

	public void setTestLocalDatetime(LocalDateTime testLocalDatetime) {
		this.testLocalDatetime = testLocalDatetime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", age=" + age + ", roleType=" + roleType
				+ ", testLocalDate=" + testLocalDate + ", testLocalDatetime=" + testLocalDatetime + ", description="
				+ description + "]";
	}
}
