package tableStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue(value = "A")	//Item 테이블의 자식 클래스들을 나누는 컬럼의 구분자
public class Album extends Item{
	private String artist;
}
