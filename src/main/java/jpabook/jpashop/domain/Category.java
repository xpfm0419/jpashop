package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * 카테고리
 * @author User
 *
 */
@Entity
@Getter @Setter
public class Category {

	/**
	 * 카테고리 고유번호
	 */
	@Id @GeneratedValue
	private Long categoryIdx;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "p_category_idx")
	private Category pCategory;

	/**
	 * 카테고리 명
	 */
	private String categoryName;
}
