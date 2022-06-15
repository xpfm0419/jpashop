package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jpabook.jpashop.domain.composite.CategoryGoodsID;
import lombok.Getter;
import lombok.Setter;

/**
 * 카테고리 상품
 * @author User
 *
 */
@Entity
@IdClass(CategoryGoodsID.class)
@Getter @Setter
public class CategoryGoods {

	/**
	 * 카테고리
	 */
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_idx")
	private Category category;

	/**
	 * 상품
	 */
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goods_idx")
	private Goods goods;
}
