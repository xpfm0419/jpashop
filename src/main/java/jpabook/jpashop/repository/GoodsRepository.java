package jpabook.jpashop.repository;


import jpabook.jpashop.domain.Goods;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * 상품 Repository
 */
@Repository
@RequiredArgsConstructor
public class GoodsRepository {
    /**
     * EntityManager
     */
    private final EntityManager em;

    /**
     * 상품 전체 목록 조회
     * @return 상품 전체 목록
     */
    public List<Goods> selectAllGoodsList() {
        return em.createQuery("select g from Goods g", Goods.class)
                .getResultList();
    }

    /**
     * 상품 조회
     * @param goodsIdx 상품 고유번호
     * @return 상품
     */
    public Goods selectGoods(Long goodsIdx) {
        return em.find(Goods.class, goodsIdx);
    }

    /**
     * 상품 입력/수정
     * @param goods 입력/수정할 정보가 담긴 Goods
     */
    public void mergeGoods(Goods goods) {
        if(goods.getGoodsIdx() == null) {
            em.persist(goods);
        } else {
            em.merge(goods);
        }
    }
}
