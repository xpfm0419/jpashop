package jpabook.jpashop.service;

import jpabook.jpashop.domain.Goods;
import jpabook.jpashop.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 상품 서비스
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoodsService {

    /**
     * 상품 Repository
     */
    private final GoodsRepository goodsRepository;

    /**
     * 상품 전체 목록 조회
     * @return 상품 전체 목록
     */
    public List<Goods> selectAllGoodsList() {
        return goodsRepository.selectAllGoodsList();
    }

    /**
     * 상품 조회
     * @param goodsIdx 상품 고유번호
     * @return 상품
     */
    public Goods selectGoods(Long goodsIdx) {
        return goodsRepository.selectGoods(goodsIdx);
    }

    /**
     * 상품 입력/수정
     * @param goods 입력/수정할 정보가 담긴 Goods
     */
    @Transactional
    public void mergeGoods(Goods goods) {
        goodsRepository.mergeGoods(goods);
    }
}
