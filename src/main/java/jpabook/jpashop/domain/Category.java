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

	/*
	@OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //==연관관계 메서드==//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
    */
}
