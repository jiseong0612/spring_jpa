package tableStrategy;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
/*
 * 테이블과 관계 없고, 단순히 엔티티가 공통으로 사용하는 매핑 공통 정보를 모으는 역할
 * 참고로, @Entity 클래스는 엔티티(@Entity가 붙은것) 나 @MappedSuperclass로 지정한 클래스만 상속 가능
 */
@MappedSuperclass
public abstract class BaseEntity {
	private String createdBy;
	private String lastModifiedBy;
	private LocalDateTime createdDate;
	private LocalDateTime lastModifiedDate;
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
