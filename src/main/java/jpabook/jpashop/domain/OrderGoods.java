package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 주문 상품
 * @author User
 *
 */
@Entity
@Getter @Setter
public class OrderGoods {

	/**
	 * 주문 상품 고유번호
	 */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ogIdx;

	/**
	 * 회원 주문
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mo_idx")
	private MemberOrder memberOrder;

	/**
	 * 상품
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goods_idx")
	private Goods goods;

	/**
	 * 주문 가격
	 */
	private int orderPrice;

	/**
	 * 주문 수량
	 */
	private int orderCnt;

	/**
	 * 등록일시
	 */
	private LocalDateTime regDt;

	/**
	 * 수정일시
	 */
	private LocalDateTime updDt;

	// =================================== 양방향 연관관계 ===================================

	// =================================== 연관관계 메소드 ===================================

	// =================================== 생성 메소드 ===================================

	/**
	 * 주문 상품 생성
	 * @param goods 상품
	 * @param orderPrice 주문 가격
	 * @param orderCnt 주문 수량
	 * @return 주문 상품
	 */
	public static OrderGoods createOrderGoods(Goods goods, int orderPrice, int orderCnt) {
		OrderGoods orderGoods = new OrderGoods();
		orderGoods.setGoods(goods);
		orderGoods.setOrderPrice(orderPrice);
		orderGoods.setOrderCnt(orderCnt);

		goods.removeStockCnt(orderCnt);

		return orderGoods;
	}

	// =================================== 비즈니스 로직 ===================================

	/**
	 * 주문 취소
	 */
    public void cancel() {
        getGoods().addStockCnt(orderCnt);
    }

	/**
	 * 주문상품 전체 가격 조회
	 * @return 주문상품 전체 가격
	 */
    public int getTotalPrice() {
        return getOrderPrice() * getOrderCnt();
    }
}
