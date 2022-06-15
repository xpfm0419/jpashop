package jpabook.jpashop.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 앨범
 * @author User
 *
 */
@Entity
@DiscriminatorValue("ALBUM")
@Getter @Setter
public class Album extends Goods {

	/**
	 * 아티스트
	 */
	private String artist;

	// =================================== 양방향 연관관계 ===================================

	// =================================== 연관관계 메소드 ===================================

	// =================================== 생성 메소드 ===================================

	// =================================== 비즈니스 로직 ===================================
}
