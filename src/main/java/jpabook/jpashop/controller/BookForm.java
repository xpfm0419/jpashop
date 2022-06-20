package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

/**
 * 책 상품
 * @author User
 *
 */
@Getter @Setter
public class BookForm {

    private Long goodsIdx;

    private String goodsName;
    private int goodsPrice;
    private int stockCnt;

    private String author;
}
