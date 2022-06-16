package jpabook.jpashop.domain;

import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

	// =================================== 양방향 연관관계 ===================================

	// =================================== 연관관계 메소드 ===================================

	// =================================== 생성 메소드 ===================================

	// =================================== 비즈니스 로직 ===================================

	/**
	 * 재고 수량 증가
	 * @param quantity 증가 수량
	 */
	public void addStockCnt(int quantity) {
		this.stockCnt += quantity;
	}

	/**
	 * 재고 수량 차감
	 * @param quantity 차감 수량
	 */
	public void removeStockCnt(int quantity) {
		int remainStockCnt = this.stockCnt - quantity;
		if(remainStockCnt < 0) {
			throw new NotEnoughStockException("need more stock");
		}
		this.stockCnt = remainStockCnt;
	}



	/*
	@ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
    */
}
