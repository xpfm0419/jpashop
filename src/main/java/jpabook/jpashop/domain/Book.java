package jpabook.jpashop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 책
 * @author User
 *
 */
@Entity
@DiscriminatorValue("BOOK")
@Getter @Setter
public class Book extends Goods {

	/**
	 * 저자
	 */
	private String author;

	// =================================== 양방향 연관관계 ===================================

	// =================================== 연관관계 메소드 ===================================

	// =================================== 생성 메소드 ===================================

	// =================================== 비즈니스 로직 ===================================
}
