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
}
