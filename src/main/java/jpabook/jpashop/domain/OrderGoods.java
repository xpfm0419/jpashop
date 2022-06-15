package jpabook.jpashop.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

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
	@Id @GeneratedValue
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

	/*
	//==생성 메서드==//
    public static OrderItem createOrderItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

    //==비즈니스 로직==//
    public void cancel() {
        getItem().addStock(count);
    }

    //==조회 로직==//

     // 주문상품 전체 가격 조회
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
    */
}
