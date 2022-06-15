package jpabook.jpashop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 영화
 * @author User
 *
 */
@Entity
@DiscriminatorValue("MOVIE")
@Getter @Setter
public class Movie extends Goods {

	/**
	 * 배우
	 */
	private String actor;

	// =================================== 양방향 연관관계 ===================================

	// =================================== 연관관계 메소드 ===================================

	// =================================== 생성 메소드 ===================================

	// =================================== 비즈니스 로직 ===================================
}
