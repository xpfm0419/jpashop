package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryIdx;

	/**
	 * 부모 카테고리
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "p_category_idx")
	private Category pCategory;

	/**
	 * 카테고리 명
	 */
	private String categoryName;

	// =================================== 양방향 연관관계 ===================================

	/**
	 * 카테고리 목록
	 */
	@OneToMany(mappedBy = "pCategory")
	private List<Category> categoryList = new ArrayList<>();

	// =================================== 연관관계 메소드 ===================================

	/**
	 * 하위 카테고리 추가
	 * @param category 하위 카테고리
	 */
	public void addChildCategory(Category category) {
		this.categoryList.add(category);
		category.setPCategory(this);
	}

	// =================================== 생성 메소드 ===================================

	// =================================== 비즈니스 로직 ===================================
}
