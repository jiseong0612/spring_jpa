package tableStrategy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//@Entity
@DiscriminatorValue(value = "B")	//Item 테이블의 자식 클래스들을 나누는 컬럼의 구분자
public class Book extends Item{
	private String author;
	private String isbn;
}
