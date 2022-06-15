package jpabook.jpashop.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import jpabook.jpashop.domain.embedded.Address;
import jpabook.jpashop.domain.enumeration.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * 주문 배송
 * @author User
 *
 */
@Entity
@Getter @Setter
public class OrderDelivery {

	/**
	 * 주문 배송 고유번호
	 */
	@Id @GeneratedValue
	private Long odIdx;

	/**
	 * 배송 상태
	 */
	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;

	/**
	 * 배송 주소
	 */
	@Embedded
	private Address address;

	// =================================== 양방향 연관관계 ===================================

	/**
	 * 회원 주문
	 */
	@OneToOne(mappedBy = "orderDelivery", fetch = FetchType.LAZY)
	private MemberOrder memberOrder;

	// =================================== 연관관계 메소드 ===================================

	// =================================== 생성 메소드 ===================================

	// =================================== 비즈니스 로직 ===================================
}
