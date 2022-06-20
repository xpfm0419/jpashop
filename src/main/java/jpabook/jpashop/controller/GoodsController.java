package jpabook.jpashop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Goods;
import jpabook.jpashop.service.GoodsService;
import lombok.RequiredArgsConstructor;

/**
 * 상품 controller
 * @author User
 *
 */
@Controller
@RequiredArgsConstructor
public class GoodsController {

	/**
	 * 상품 Service
	 */
    private final GoodsService goodsService;

    /**
     * 상품 목록 조회
     * @param model
     * @return
     */
    @GetMapping("/goods/list")
    public String list(Model model) {
    	model.addAttribute(goodsService.selectAllGoodsList());

        return "goods/list";
    }

    /**
     * 상품 등록 화면
     * @param model Model
     * @return goods/insertForm
     */
    @GetMapping("/goods/insert")
    public String insertForm(Model model) {
        model.addAttribute("book", new BookForm());
        return "goods/insertForm";
    }

    /**
     * 상품 등록 처리
     * @param bookForm 입력 정보가 담긴 BookForm
     * @return
     */
    @PostMapping("/goods/insert")
    public String create(BookForm bookForm) {

        Book book = new Book();
        book.setGoodsName(bookForm.getGoodsName());
        book.setGoodsPrice(bookForm.getGoodsPrice());
        book.setStockCnt(bookForm.getStockCnt());
        book.setAuthor(bookForm.getAuthor());

        goodsService.mergeGoods(book);
        return "redirect:/";
    }

    /**
     * 상품 수정 화면
     * @param goodsIdx
     * @param model
     * @return
     */
    @GetMapping("/goods/{goodsIdx}/edit")
    public String updateItemForm(@PathVariable("goodsIdx") Long goodsIdx, Model model) {
        Book book = (Book) goodsService.selectGoods(goodsIdx);

        BookForm form = new BookForm();
        form.setGoodsIdx(book.getGoodsIdx());
        form.setGoodsName(book.getGoodsName());
        form.setGoodsPrice(book.getGoodsPrice());
        form.setStockCnt(book.getStockCnt());
        form.setAuthor(book.getAuthor());

        model.addAttribute("book", form);
        return "goods/updateForm";
    }

//    @PostMapping("goods/{goodsIdx}/edit")
//    public String updateItem(@PathVariable Long goodsIdx, @ModelAttribute("form") BookForm form) {
//
//        goodsService.updateGoods(goodsIdx, form.getGoodsName(), form.getGoodsPrice(), form.getStockCnt());
//
//        return "redirect:/items";
//    }
}





