package jpabook.jpashop.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import jpabook.jpashop.domain.enumeration.OrderStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원 주문
 * @author User
 *
 */
@Entity
@Getter @Setter
public class MemberOrder {

	/**
	 * 회원 주문 고유번호
	 */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long moIdx;

	/**
	 * 회원
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_idx")
	private Member member;

	/**
	 * 주문 배송
	 */
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "od_idx")
	private OrderDelivery orderDelivery;

	/**
	 * 주문일시
	 */
	private LocalDateTime orderDate;

	/**
	 * 주문 상태
	 */
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	// =================================== 양방향 연관관계 ===================================

	/**
	 * 주문 상품 목록
	 */
	@OneToMany(mappedBy = "memberOrder", cascade = CascadeType.ALL)
	private List<OrderGoods> orderGoodsList = new ArrayList<>();

	// =================================== 연관관계 메소드 ===================================

	/**
	 * 회원 셋팅
	 * @param member 회원
	 */
	public void setMember(Member member) {
		this.member = member;
		member.getMemberOrderList().add(this);
	}

	/**
	 * 주문 배송 셋팅
	 * @param orderDelivery
	 */
	public void setOrderDelivery(OrderDelivery orderDelivery) {
		this.orderDelivery = orderDelivery;
		orderDelivery.setMemberOrder(this);
	}

	/**
	 * 주문 상품 추가
	 * @param orderGoods 주문 상품
	 */
	public void addOrderGoods(OrderGoods orderGoods) {
		this.orderGoodsList.add(orderGoods);
		orderGoods.setMemberOrder(this);
	}

	// =================================== 생성 메소드 ===================================

	/**
	 * 회원 주문 생성
	 * @param member 회원
	 * @param orderDelivery 주문 배송
	 * @param orderGoodsList 주문 상품
	 * @return 회원 주문
	 */
	public static MemberOrder createMemberOrder(Member member, OrderDelivery orderDelivery, OrderGoods... orderGoodsList) {
		MemberOrder memberOrder = new MemberOrder();
		memberOrder.setMember(member);
		memberOrder.setOrderDelivery(orderDelivery);

		for (OrderGoods orderGoods : orderGoodsList) {
			memberOrder.addOrderGoods(orderGoods);
		}

		memberOrder.setOrderDate(LocalDateTime.now());
		memberOrder.setOrderStatus(OrderStatus.ORDER);

		return memberOrder;
	}

	// =================================== 비즈니스 로직 ===================================


	/*
    //==비즈니스 로직==//
     // 주문 취소
    public void cancel() {
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }

        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

    //==조회 로직==//
     // 전체 주문 가격 조회
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
    */
}
