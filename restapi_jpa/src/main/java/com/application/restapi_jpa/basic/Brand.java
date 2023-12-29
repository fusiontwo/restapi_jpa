package com.application.restapi_jpa.basic;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*	

	# 롬복(lombok)
	
	 - 롬복은 Java 라이브러리로, 반복되는 코드(예: getter, setter, toString 등) 작성을 줄여주는 도구이다. 
	 - 이를 사용하면 클래스의 가독성을 높이고, 유지보수를 용이하게 만들 수 있다.
	
	 - 주요 어노테이션
	 
	   1) @Data  : 클래스의 모든 필드에 대한 getter, setter를 자동으로 생성한다. equals(), hashCode(), toString() 메서드도 포함한다.
	   2) @Getter / @Setter : 클래스 또는 필드 레벨에서 사용할 수 있으며, 각 필드에 대한 getter와 setter 메서드를 생성한다.
	   3) 생성자
			@NoArgsConstructor: 매개변수가 없는 기본 생성자를 생성한다.
			@RequiredArgsConstructor: final 또는 @NonNull 필드에 대한 생성자를 생성한다.
			@AllArgsConstructor: 모든 필드를 매개변수로 하는 생성자를 생성한다.
	   4) @Builder : 객체의 불변성을 유지하면서 객체 생성을 보다 용이하게 하는 빌더 패턴을 구현한다.
	   5) @Slf4j 로깅을 위한 Logger 객체를 자동으로 생성한다. SLF4J(Logging Facade)를 사용한다.
	   6) @Value 불변 클래스를 만들기 위해 사용되며, 모든 필드를 final로 만들고, getter만 생성한다.
	   7) @NonNull 필드가 null이 아님을 나타내며, 해당 필드에 대한 생성자나 setter에서 자동으로 null 체크를 추가한다.
	 
	 - 롬복 사용의 장점
	 
		코드 간소화: 반복적인 메서드 작성을 줄여준다.
		가독성 향상: 필요한 로직에 더 집중할 수 있게 해준다.
		유지보수 용이: 필드 변경 시 관련 메서드를 일일이 수정할 필요가 없다.

*/

@Data
@Entity
public class Brand {
	
	@Id
	private String brandId;
	private String brandNm;
	private String activeYn;
	private Date enteredDt;
	
}

/*

	- JPA 주요 어노테이션
	
	@Entity : 클래스가 JPA 엔티티임을 나타낸다. 클래스 이름이 DB 테이블 이름에 매핑된다.
	@Table  : 엔티티 클래스가 매핑될 테이블의 정보를 명시한다. (name, catalog, schema 등의 속성을 가질 수 있음)
	@Id		: 엔티티의 기본 키(Primary Key)를 나타낸다.
	@GeneratedValue : 기본 키의 값을 자동으로 생성할 전략을 명시한다. (AUTO, IDENTITY, SEQUENCE, TABLE 중 선택)
	@Column : 필드가 매핑될 테이블의 컬럼을 명시한다. (name, nullable, length 등의 속성을 가질 수 있음)
	@ManyToOne, @OneToMany, @OneToOne, @ManyToMany : 엔티티 간의 관계를 명시한다. (@JoinColumn과 함께 사용되는 경우가 많음)
	@JoinColumn : 외래 키(Foreign Key)를 매핑할 때 사용한다. (name, referencedColumnName 등의 속성을 가질 수 있음)
	@Transient : 필드가 영속성 컨텍스트에 저장되거나 검색되지 않음을 나타다.
	@Temporal : 날짜 타입(java.util.Date, java.util.Calendar)의 매핑을 명시한다. (TemporalType.DATE, TemporalType.TIME, TemporalType.TIMESTAMP 중 선택)

*/
