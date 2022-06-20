package jpabook.jpashop.controller;

import org.springframework.stereotype.Controller;

import jpabook.jpashop.service.GoodsService;
import jpabook.jpashop.service.MemberOrderService;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final MemberOrderService memberOrderService;
    private final MemberService memberService;
    private final GoodsService goodsService;

//    @GetMapping("/order")
//    public String createForm(Model model) {
//
//        List<Member> members = memberService.findMembers();
//        List<Item> items = itemService.findItems();
//
//        model.addAttribute("members", members);
//        model.addAttribute("items", items);
//
//        return "order/orderForm";
//    }
//
//    @PostMapping("/order")
//    public String order(@RequestParam("memberId") Long memberId,
//                        @RequestParam("itemId") Long itemId,
//                        @RequestParam("count") int count) {
//
//        orderService.order(memberId, itemId, count);
//        return "redirect:/orders";
//    }
//
//    @GetMapping("/orders")
//    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
//        List<Order> orders = orderService.findOrders(orderSearch);
//        model.addAttribute("orders", orders);
//
//        return "order/orderList";
//    }
//
//    @PostMapping("/orders/{orderId}/cancel")
//    public String cancelOrder(@PathVariable("orderId") Long orderId) {
//        orderService.cancelOrder(orderId);
//        return "redirect:/orders";
//    }
}
