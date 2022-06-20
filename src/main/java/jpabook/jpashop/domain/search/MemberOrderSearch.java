package jpabook.jpashop.domain.search;

import jpabook.jpashop.domain.enumeration.OrderStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원 주문 검색
 */
@Getter @Setter
public class MemberOrderSearch {
    /**
     * 회원 이름
     */
    private String memberName;
    /**
     * 주문 상태
     */
    private OrderStatus orderStatus;
}
