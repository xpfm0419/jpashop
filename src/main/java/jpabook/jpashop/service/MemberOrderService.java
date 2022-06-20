package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.domain.Goods;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.MemberOrder;
import jpabook.jpashop.domain.OrderDelivery;
import jpabook.jpashop.domain.OrderGoods;
import jpabook.jpashop.domain.enumeration.DeliveryStatus;
import jpabook.jpashop.domain.search.MemberOrderSearch;
import jpabook.jpashop.repository.GoodsRepository;
import jpabook.jpashop.repository.MemberOrderRepository;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

/**
 * 회원 주문 Service
 * @author User
 *
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class MemberOrderService {

	private final MemberOrderRepository memberOrderRepository;
    private final MemberRepository memberRepository;
    private final GoodsRepository goodsRepository;

    /**
     * 회원 주문 목록 조회
     * @param memberOrderSearch
     * @return
     */
    public List<MemberOrder> findOrders(MemberOrderSearch memberOrderSearch) {
        return memberOrderRepository.selectMemberOrderList(memberOrderSearch);
    }

    /**
     * 주문 생성
     * @param memberIdx
     * @param goodsIdx
     * @param orderCnt
     * @return
     */
    @Transactional
    public Long order(Long memberIdx, Long goodsIdx, int orderCnt) {

        // 회원 조회
        Member member = memberRepository.selectMember(memberIdx);
        // 상품 조회
        Goods goods = goodsRepository.selectGoods(goodsIdx);

        // 배송정보 생성
        OrderDelivery delivery = new OrderDelivery();
        delivery.setAddress(member.getAddress());
        delivery.setDeliveryStatus(DeliveryStatus.READY);

        //주문상품 생성
        OrderGoods orderGoods = OrderGoods.createOrderGoods(goods, orderCnt);

        //주문 생성
        MemberOrder memberOrder = MemberOrder.createMemberOrder(member, delivery, orderGoods);

        //주문 저장
        memberOrderRepository.insertMemberOrder(memberOrder);

        return memberOrder.getMoIdx();
    }

    /**
     * 주문 취소
     * @param moIdx
     */
    @Transactional
    public void cancelOrder(Long moIdx) {
        //주문 엔티티 조회
        MemberOrder memberOrder = memberOrderRepository.selectMemberOrder(moIdx);
        //주문 취소
        memberOrder.cancel();
    }

}
