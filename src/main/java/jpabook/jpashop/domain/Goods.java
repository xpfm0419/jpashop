package jpabook.jpashop.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.Setter;

/**
 * 상품
 * @author User
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Goods {

	/**
	 * 상품 고유번호
	 */
	@Id @GeneratedValue
	private Long goodsIdx;

	/**
	 * 상품명
	 */
	private String goodsName;

	/**
	 * 상품 가격
	 */
	private int goodsPrice;

	/**
	 * 재고 수량
	 */
	private int stockCnt;
}
