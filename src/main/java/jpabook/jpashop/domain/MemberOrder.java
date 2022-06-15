package jpabook.jpashop.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	@Id @GeneratedValue
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
	@ManyToOne(fetch = FetchType.LAZY)
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
	private OrderStatus orderStats;
}
